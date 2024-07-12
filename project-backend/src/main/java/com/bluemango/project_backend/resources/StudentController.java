package com.bluemango.project_backend.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bluemango.project_backend.models.Student;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    
 
    @GetMapping("students/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable int id){
        Student student = students
        .stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")); 

        return ResponseEntity.ok(student); 


        
    }
            
    

    @PostMapping("students")
    public ResponseEntity<Student> save(@RequestBody Student student){
        student.setId(students.size() + 1 );
        students.add(student);


        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/${id}")
        .buildAndExpand(student.getId())
        .toUri();

        return ResponseEntity.created(location).body(student);

    }

    @PostConstruct
    public void main(){
        students.add(new Student(1, "Alice", "alice@example.com", "(11) 98765-4321", 1, 1));
        students.add(new Student(2, "Bob", "bob@example.com", "(22) 98765-4321", 2, 2));
        students.add(new Student(3, "Charlie", "charlie@example.com", "(33) 98765-4321", 3, 3));

        
    }
    




    
}
