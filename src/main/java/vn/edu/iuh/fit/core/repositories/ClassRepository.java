package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.core.dto.RegisteredDTO;
import vn.edu.iuh.fit.core.models.Class;

import java.time.LocalDate;
import java.util.List;

public interface ClassRepository extends JpaRepository<Class, String> {
    @Query(value = "SELECT *" +
            "FROM class " +
            "WHERE subject_id = :subject AND semester_id = :semester", nativeQuery = true)
    List<Class> findClassesBySubjectAndSemester(@Param("subject") String subject, @Param("semester") int semester);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO student_class(student_id, class_id, regis_date) VALUES (:studentId, :classId, :regisDate)", nativeQuery = true)
    int enrollStudentToClass(@Param("studentId") String studentId, @Param("classId") String classId, @Param("regisDate") LocalDate regisDate);

    @Query(value = "SELECT COUNT(*) FROM student_class WHERE class_id = :classId", nativeQuery = true)
    int countStudentsInClass(@Param("classId") String classId);

    @Query(value = "SELECT c.class_id, s.name, s.credits, s.tuition * s.credits AS total, sl.regis_date, " +
            "CASE WHEN CURRENT_DATE BETWEEN c.start_date AND c.end_date THEN 1 ELSE 0 END AS status " +
            "FROM student_class sl " +
            "JOIN class c ON c.class_id = sl.class_id " +
            "JOIN subject s ON c.subject_id = s.subject_id " +
            "WHERE sl.student_id = :studentId", nativeQuery = true)
    List<Object[]> findStudentClasses(@Param("studentId") String studentId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM student_class WHERE class_id = :classId AND student_id = :studentId", nativeQuery = true)
    int deleteStudentFromClass(@Param("classId") String classId, @Param("studentId") String studentId);



}