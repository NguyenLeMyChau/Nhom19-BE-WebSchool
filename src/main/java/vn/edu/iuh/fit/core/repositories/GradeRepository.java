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
//    @Query("SELECT g FROM Grade g " +
//            "JOIN g.student s " +
//            "JOIN g.subject subj " +
//            "JOIN subj.classes c " +
////            "join c.semester sem " +
//            "WHERE s.id = :studentId AND c.semester.id = :semesterId")
//    List<Grade> findGradesByStudentIdAndSemesterId(@Param("studentId") String studentId, @Param("semesterId") int semesterId);

    @Query("SELECT DISTINCT g FROM Grade g " +
            "JOIN g.subject s " +
            "JOIN s.classes c " +
            "JOIN c.studentClasses sc " +
            "WHERE g.student.id = :studentId AND c.semester.id = :semesterId")
    List<Grade> findGradesByStudentIdAndSemesterId(@Param("studentId") String studentId, @Param("semesterId") int semesterId);
    @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId")
    List<Grade> findGradesByStudentId(@Param("studentId") String studentId);

    @Transactional
    @Modifying
    @Query("UPDATE Grade g SET g.isPassed = :isPassed WHERE g.student.id = :studentId AND g.subject.id = :subjectId")
    void updateIsPassed(@Param("studentId") String studentId, @Param("subjectId") String subjectId, @Param("isPassed") Boolean isPassed);


    @Query("SELECT g FROM Grade g " +
            "JOIN g.student s " +
            "JOIN g.subject subj " +
            "JOIN subj.classes c " +
//            "join c.semester sem " +
            "WHERE s.id = :studentId AND c.semester.id <= :semesterId")
    List<Grade> findGradesByStudentIdAndSemesterIdLessThan(String studentId, int semesterId);

    @Query("SELECT SUM(subj.credits) FROM Grade g " +
            "JOIN g.student s " +
            "JOIN g.subject subj " +
            "JOIN subj.classes c " +
            "join c.semester sem " +
            "WHERE s.id = :studentId AND sem.id = :semesterId AND g.isPassed = true")
    Integer getTotalPassedCreditsByStudentIdAndSemesterId(String studentId, int semesterId);

    @Modifying
    @Transactional
    @Query("UPDATE Grade g SET g.isPassed = :isPassed WHERE g.subject.id = :id")
    void updateIsPassed(@Param("id") String id, @Param("isPassed") Boolean isPassed);
}