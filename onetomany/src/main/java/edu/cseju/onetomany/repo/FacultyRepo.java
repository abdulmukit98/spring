package edu.cseju.onetomany.repo;

import edu.cseju.onetomany.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, String> {
}
