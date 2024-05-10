package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.core.models.Grade;
import vn.edu.iuh.fit.core.pks.GradePK;

public interface GradeRepository extends JpaRepository<Grade, GradePK> {
}