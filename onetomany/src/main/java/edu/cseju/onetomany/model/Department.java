package edu.cseju.onetomany.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {

    @Id
    private String deptId;
    private String deptName;
    private String deptCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", faculty=" + faculty +
                '}';
    }

    public Department() {
        this.deptId = "abc";
        this.deptName = "";
        this.deptCode = "";

    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dept", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<Student>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
