package com.bluemango.project_backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bluemango.project_backend.models.Course;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin
public class CoursesController {

    private List<Course> courses = new ArrayList<>();

    @GetMapping("courses")
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){

        Course course = courses
        .stream()
        .filter(c -> c.getId() == id)
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));

        return ResponseEntity.ok(course); 
    }

    @PostConstruct
    public void init(){
        courses.add(new Course(1, "Java"));
        courses.add(new Course(2, "Angular"));
        courses.add(new Course(3, "SQL"));
    }
    
    
    

    
    
}
