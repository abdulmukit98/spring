package edu.cseju.onetomany.service;

import edu.cseju.onetomany.model.Department;
import edu.cseju.onetomany.repo.DepartmentRepo;
import edu.cseju.onetomany.repo.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public List<Department> getDepartmentByFaculty(String facultyId) {

        List<Department> list = departmentRepo.findAll();
        List<Department> l = new ArrayList<Department>();
        //System.out.println(list.toString());
        for(int i =0; i<list.size(); i++)
        {
            String s = list.get(i).getFaculty().getFacultyCode();
            if(s.equals(facultyId))
            {
                l.add(list.get(i));
            }
        }
        return l;

    }
}
