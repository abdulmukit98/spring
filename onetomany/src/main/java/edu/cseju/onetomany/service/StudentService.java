package edu.cseju.onetomany.service;

import edu.cseju.onetomany.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student getStudentByRoll(String stdRoll);
    public void saveOrUpdate(Student student);
    public void removeStudent(String stdRoll);
}
