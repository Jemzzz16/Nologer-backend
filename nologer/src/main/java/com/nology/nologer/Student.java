package com.nology.nologer;

public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private String location;
    private String[] interests;



    public Student(String id, String firstName, String lastName, String age, String location, String[] interests) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.interests = interests;
        }

        // getters
        public String getStudentId() {
        return id;
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
        this.id = id;
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
