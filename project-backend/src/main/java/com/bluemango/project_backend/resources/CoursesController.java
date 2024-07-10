package com.bluemango.project_backend.resources;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bluemango.project_backend.models.Course;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin
public class CoursesController {

    List<Course> courses = new ArrayList<>();

    @GetMapping("courses")
    public List<Course> getCourses() {
        return courses;
    }

    @PostConstruct
    public void init(){
        courses.add(new Course(1, "Java"));
        courses.add(new Course(2, "Angular"));
        courses.add(new Course(3, "SQL"));
    }
    
    
    

    
    
}
