package com.nology.nologer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

    public StudentRepository repository = new StudentRepository();

    List<Student> students = new ArrayList<Student>();

    public StudentController() {
        String[] johninterests = {"Skiing", "Holidays"};
        Student john = new Student("abc", "John", "Doe", "50", "London", johninterests);
        students.add(john);

        String[] alexinterests = {"Sailing", "Walking"};
        Student alex = new Student("2", "Alex", "Frazen", "38", "Bristol", alexinterests);
        students.add(alex);

        String[] timinterests = {"Reading", "Whistling"};
        Student tim = new Student("3", "Tim", "Short", "25", "Glashow", timinterests);
        students.add(tim);

        String[] mickinterests = {"Shooting", "Swimming"};
        Student mick = new Student("4", "Mick", "Brown", "43", "Lincoln", mickinterests);
        students.add(mick);

        String[] jessinterests = {"Shooting", "Swimming"};
        Student jess = new Student("5", "Jess", "Moffit", "21", "Oxford", jessinterests);
        students.add(jess);

    }
    // get students
    @GetMapping("/students")
    public ResponseEntity getStudents() {
        return new ResponseEntity(this.repository, HttpStatus.OK);
    }

    // get single student by id
    @GetMapping("/students/{studentId}")
    @ResponseBody
    public ResponseEntity getStudent(@PathVariable String studentId){
        Student student = this.repository.findById(studentId);

            if (student != null) {
                return new ResponseEntity(student, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.NOT_FOUND);
            }
        }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        this.students.add(student);

        return student;
    }


    // delete student by id
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable String studentId){
        for (Student student : students) {
            if (studentId.equals(student.getStudentId())) {
                students.remove(student);
            }
        }
    }

}
