package com.nology.nologer;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CourseController {

    public List<Course> courses = new ArrayList<Course>();

    public CourseController() {
    Course webdev = new Course("123", "webdev101");
    this.courses.add(webdev);
    }

    // Getting
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courses;
    }
    // Getting by ID
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        for (Course course : this.courses) {
            if (courseId == course.getCourseId()) {
                return course;
            }
        }
        return null;
    }
    // Deleting
    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable String courseId) {

        for (Course course : courses) {
            if (course.getCourseId().equals(course)) {
                this.courses.remove(course);
                return "course removed";
            }
        }
        return "couldn't find a course with" + courseId;
    }
}
