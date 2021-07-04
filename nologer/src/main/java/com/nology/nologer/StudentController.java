package com.nology.nologer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

    List<Student> students = new ArrayList<Student>();

    public StudentController() {
        String[] johninterests = {"Skiing", "Holidays"};
        Student john = new Student(1, "John", "Doe", 50, "London", johninterests);
        students.add(john);

        String[] alexinterests = {"Sailing", "Walking"};
        Student alex = new Student(2, "Alex", "Frazen", 38, "Bristol", alexinterests);
        students.add(alex);

        String[] timinterests = {"Reading", "Whistling"};
        Student tim = new Student(3, "Tim", "Short", 25, "Glashow", timinterests);
        students.add(tim);

        String[] mickinterests = {"Shooting", "Swimming"};
        Student mick = new Student(4, "Mick", "Brown", 43, "Lincoln", mickinterests);
        students.add(mick);
    }
    // get students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    // get single student by id
    @GetMapping("/students/{studentId}")
    @ResponseBody
    public Student getStudent(@PathVariable String studentId){
        for (Student student : students){
            if (studentId.equals(student.getId())){
                return student;
            }
        }
        return null;
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        System.out.println("the name is " + student.getFirstName());
        this.students.add(student);
        for (Student s : students){
            System.out.println(s.getFirstName());
        }
        return student;
    }
    // delete student by id
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable String studentId){
        for (Student student : students) {
            if (studentId.equals(student.getId())) {
                students.remove(student);
            }
        }
    }

}
