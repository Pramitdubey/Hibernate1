package org.example;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student_gfg_detail {
    @Id
    private int gfg_id;
    private String college;
    private int no_of_problem_solved;
    @OneToOne(mappedBy = "student_gfg_detail",cascade = CascadeType.ALL)
    private Student student;

    public Student_gfg_detail(int gfg_id, String college, int no_of_problem_solved,Student student) {
        this.gfg_id = gfg_id;
        this.college = college;
        this.no_of_problem_solved = no_of_problem_solved;
        this.student=student;
    }
    public Student_gfg_detail(){

    }

    public int getGfg_id() {
        return gfg_id;
    }

    public void setGfg_id(int gfg_id) {
        this.gfg_id = gfg_id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getNo_of_problem_solved() {
        return no_of_problem_solved;
    }

    public void setNo_of_problem_solved(int no_of_problem_solved) {
        this.no_of_problem_solved = no_of_problem_solved;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
