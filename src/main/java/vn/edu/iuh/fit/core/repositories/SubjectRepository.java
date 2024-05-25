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

    @Query("SELECT s FROM Subject s WHERE s.id NOT IN " +
            "(SELECT g.subject.id FROM Grade g join Student s join StudentClass sc join Class c WHERE g.student.id = :studentId AND c.semester.id = :semesterId)")
    List<Subject> findSubjectsWithoutGrades(@Param("studentId") String studentId, @Param("semesterId") int semesterId);

}