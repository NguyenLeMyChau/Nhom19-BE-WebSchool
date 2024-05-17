package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.models.Semester;
import vn.edu.iuh.fit.core.models.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    @Query("SELECT c FROM Class c WHERE c.subject.id = :subjectId")
    List<Class> findClassesBySubjectId(@Param("subjectId") String subjectId);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Grade g SET g.isPassed = :ispassed WHERE g.subject.id = :id")
//    void updateIsPassed(@Param("id") String id, @Param("ispassed") Boolean ispassed);

    @Query("SELECT SUM(s.credits) FROM Subject s " +
            "JOIN s.grades g " +
            "WHERE g.isPassed IS NOT NULL")
    Integer getTotalCreditsWhereIsPassedIsNotNull();
}