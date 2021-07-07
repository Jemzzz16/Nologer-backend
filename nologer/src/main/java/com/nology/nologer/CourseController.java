package com.nology.nologer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class CourseController {

    @Autowired
    public ICourseRepository repository;

    //get courses
    @GetMapping("/courses")
    public ResponseEntity<Course> getCourses () {
        return new ResponseEntity(this.repository.findAll(), HttpStatus.OK);
    }
//
//    //get single course by ID
//    @GetMapping("/course/{courseId}")
//    public ResponseEntity getCourse(@PathVariable String courseId) {
//       Course course = this.repository.findById(courseId);
//
//        if (course != null) {
//        return new ResponseEntity(course, HttpStatus.OK);
//        } else {
//            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/course")
//    public ResponseEntity createCourse(@RequestBody Course course) {
////       Integer i = this.repository.courses.size();
////       course.setCourseId(i.toString());
//        this.repository.addCourse(course);
//
//        if(course != null) {
//            return new ResponseEntity(course, HttpStatus.OK);
//        } else {
//            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/course/{courseId}")
//    public ResponseEntity deleteCourse(@PathVariable String courseId) {
//       boolean result = this.repository.deleteById(courseId);
//       if(result) {
//           return new ResponseEntity("Success! We removed the course", HttpStatus.OK);
//       } else {
//           return new ResponseEntity("Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
//       }
//    }
}