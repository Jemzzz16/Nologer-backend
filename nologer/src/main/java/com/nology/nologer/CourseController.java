package com.nology.nologer;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CourseController {

    public CourseRepository repository = new CourseRepository();

    public List<Course> courses = new ArrayList<Course>();

    public CourseController() {
    Course webdev = new Course("123", "webdev101");
    this.courses.add(webdev);
    }

    // Getting
    @GetMapping("/courses")
    public ResponseEntity getCourses() {
        return new ResponseEntity(this.repository, HttpStatus.OK);
    }

    // Getting by ID
    @GetMapping("/courses/{courseId}")
    public ResponseEntity getCourse(@PathVariable String courseId) {
        Course course = this.repository.findByiD(courseId);

        if (course != null) {
            return new ResponseEntity(course, HttpStatus.OK);
            } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
    // Deleting course bt ID
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable String courseId) {
        boolean result = this.repository.deleteById(courseId);
        if (result) {
            return new ResponseEntity("success we reomved your course", HttpStatus.OK);
        } else {
            return new ResponseEntity("Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // return 404 if course not found
        //return 200 if course deleted correctly
//        for (Course course : courses) {
//            if (course.getCourseId().equals(course)) {
//                this.courses.remove(course);
//                return new ResponseEntity("course removed", HttpStatus.OK);
//            }
//        }
//        //        this.courses.removeIf(course -> course.getCourseId().equals(courseId));
//        return new ResponseEntity("couldn't find a course with" + courseId, HttpStatus.NOT_FOUND);
    }
}
