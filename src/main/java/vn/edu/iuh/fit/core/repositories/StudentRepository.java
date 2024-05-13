package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.core.models.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findStudentByIdAndPassword(String id, String password);
}