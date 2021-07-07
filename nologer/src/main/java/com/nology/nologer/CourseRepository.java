package com.nology.nologer;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    // TEMPORARY: keep the courses in a list
    // Find course by Id
    private List<Course> courses = new ArrayList<>();
    public CourseRepository() {
        this.courses.add(new Course("idddd", "Web Developement"));
    }
    public Course findByiD(String courseId) {
        for (Course course : this.courses) {
            if (courseId.equals(course.getCourseId())) {
                return course;
            }
        }
        return null;
    }

    // Find all courses
    public List<Course> findAll() {
        return this.courses;
    }

    // delete course by Id
    public boolean deleteById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return this.courses.remove(course);
            }
        }
        return false;
    }
}
