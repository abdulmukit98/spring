package edu.cseju.onetomany.service;

import edu.cseju.onetomany.model.Department;
import edu.cseju.onetomany.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        return departmentRepo.getOne(departmentId);
    }

    @Override
    public void saveOrUpdate(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public void removeDepartment(String departmentId) {
        departmentRepo.deleteById(departmentId);
    }
}
