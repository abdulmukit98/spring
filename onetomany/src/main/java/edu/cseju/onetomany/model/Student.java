package edu.cseju.onetomany.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    private String studentRoll;
    private String studentName;
    private String studentAdress;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department dept;

    public String getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(String studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAdress() {
        return studentAdress;
    }

    public void setStudentAdress(String studentAdress) {
        this.studentAdress = studentAdress;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentRoll='" + studentRoll + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAdress='" + studentAdress + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Student() {
        this.studentRoll = "abc";
        this.studentName = "";
        this.studentAdress = "";

    }
}
