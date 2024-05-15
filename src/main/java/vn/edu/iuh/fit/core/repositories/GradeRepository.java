package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.core.dto.GradeInfoDTO;
import vn.edu.iuh.fit.core.models.Grade;
import vn.edu.iuh.fit.core.pks.GradePK;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, GradePK> {
    @Query("SELECT g FROM Grade g " +
            "JOIN g.student s " +
            "JOIN g.subject subj " +
            "JOIN subj.semester sem " +
            "WHERE s.id = :studentId AND sem.id = :semesterId")
    List<Grade> findGradesByStudentIdAndSemesterId(@Param("studentId") String studentId, @Param("semesterId") int semesterId);

}