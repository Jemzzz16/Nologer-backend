package com.nology.nologer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

    List<Student> students = new ArrayList<Student>();

    public StudentController() {
        String[] interests = {"Skiing", "Holidays"};
        Student john = new Student(1, "John", "Doe", 50, "London", interests);
        students.add(john);
    }
    // get students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }
    // get single student by id
    @GetMapping("/students/{studentsId}")
    public Student getStudent(@PathVariable String studentId, @RequestParam String key) {
    // creating a string in a int
        int idAsInt = Integer.parseInt(studentId);
        System.out.println("the key was" + key);
        return this.students.get(idAsInt);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        System.out.println("the name is" + student.getFirstName());
        this.students.add(student);
        return student;
    }
    // delete student by id
    @DeleteMapping("/students/delete")
    public Student deleteStudent(@PathVariable String studentId) {
        int idAsInt = Integer.parseInt(studentId);
        return this.students.remove(idAsInt);
    }

}
