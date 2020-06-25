package edu.cseju.onetomany.repo;

import edu.cseju.onetomany.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
    public Department findDepartmentByFacultyFacultyCode(String facultyId);
}
