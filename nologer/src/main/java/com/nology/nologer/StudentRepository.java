package com.nology.nologer;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    // Find student by id
    private List<Student> students = new ArrayList<>();
    public StudentRepository() {
        String[] johninterests = {"Skiing", "Holidays"};
        this.students.add(new Student("abc", "John", "Doe", "51", "London", johninterests));
    }
    public Student findById(String studentId) {
        for (Student student : this.students) {
            if (studentId.equals(student.getStudentId())) {
                return student;
            }
        }
        return null;
    }

    // Find all students

    public List<Student> getStudents() {
        return students;
    }


    // Delete student by id
    public boolean deleteById(String StudentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(StudentId)) {
                return this.students.remove(student);
            }
        }
        return false;
    }
}
