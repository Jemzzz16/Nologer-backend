package com.nology.nologer;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String studentId;
    private String firstName;
    private String lastName;
    private String age;
    private String location;
    private String[] interests;



    public Student(String studentId, String firstName, String lastName, String age, String location, String[] interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.interests = interests;
        }

        // getters
        public String getStudentId() {
        return studentId;
         }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAge() {
            return age;
        }

        public String getLocation() {
            return location;
        }

        public String[] getInterests() {
            return interests;
        }


       // setters
    public void setId(String id) {
        this.studentId = id;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void setAge(String age) {

        this.age = age;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public void setInterests(String[] interests) {

        this.interests = interests;
    }
}
