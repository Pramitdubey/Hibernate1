package org.example;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gfg_id")
    private Student_gfg_detail student_gfg_detail;

    public Student(int id, String firstName, String lastName, String email, Student_gfg_detail student_gfg_detail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.student_gfg_detail = student_gfg_detail;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student_gfg_detail getStudent_gfg_detail() {
        return student_gfg_detail;
    }

    public void setStudent_gfg_detail(Student_gfg_detail student_gfg_detail) {
        this.student_gfg_detail = student_gfg_detail;
    }
}