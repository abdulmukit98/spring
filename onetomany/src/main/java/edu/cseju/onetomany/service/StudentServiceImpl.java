package edu.cseju.onetomany.service;

import edu.cseju.onetomany.model.Student;
import edu.cseju.onetomany.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentByRoll(String stdRoll) {
        return studentRepo.getOne(stdRoll);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void removeStudent(String stdRoll) {
        studentRepo.deleteById(stdRoll);
    }
}
