package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.core.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}