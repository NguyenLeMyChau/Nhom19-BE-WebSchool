package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.core.models.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {
}