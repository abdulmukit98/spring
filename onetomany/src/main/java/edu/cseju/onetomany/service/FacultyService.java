package edu.cseju.onetomany.service;

import edu.cseju.onetomany.model.Faculty;

import java.util.List;

public interface FacultyService {
    public List<Faculty> getAllFaculty();
    public Faculty getFacultyById(String facultyId);
    public void saveOrUpdate(Faculty faculty);
    public void removeFaculty(String facultyId);
}
