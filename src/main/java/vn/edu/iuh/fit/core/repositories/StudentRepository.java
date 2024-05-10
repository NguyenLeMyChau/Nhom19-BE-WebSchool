package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.core.models.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}