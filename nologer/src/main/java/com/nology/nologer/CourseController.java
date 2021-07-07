package com.nology.nologer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
public class CourseController {

    @Autowired
    public ICourseRepository repository;

    //get courses
    @GetMapping("/courses")
    public ResponseEntity<Course> getCourses() {
        return new ResponseEntity(this.repository.findAll(), HttpStatus.OK);
    }

    //get single course by ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity getCourse(@PathVariable String courseId) {
        Optional<Course> course = this.repository.findById(courseId);
        if (course.isPresent()) {
            return new ResponseEntity(course, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        this.repository.save(course);
        return new ResponseEntity(course, HttpStatus.OK);
    }

    //
    @DeleteMapping("/course/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable String courseId) {
        this.repository.deleteById(courseId);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
    }
}