package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.core.dto.GradeInfoDTO;
import vn.edu.iuh.fit.core.models.Grade;
import vn.edu.iuh.fit.core.pks.GradePK;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, GradePK> {
}