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

    @Query(value = "SELECT \n" +
            "    c.class_id, \n" +
            "    s.name, \n" +
            "    s.credits, \n" +
            "    s.tuition * s.credits AS total, \n" +
            "    sl.regis_date,\n" +
            "    CASE \n" +
            "        WHEN CURRENT_DATE BETWEEN c.start_date AND c.end_date THEN 1 \n" +
            "        ELSE 0 \n" +
            "    END AS status \n" +
            "FROM \n" +
            "    student_class sl \n" +
            "JOIN \n" +
            "    class c ON c.class_id = sl.class_id\n" +
            "JOIN \n" +
            "    subject s ON c.subject_id = s.subject_id \n" +
            "WHERE \n" +
            "    sl.student_id = :studentId \n" +
            "    AND c.semester_id = (\n" +
            "        SELECT \n" +
            "            semester_id\n" +
            "        FROM \n" +
            "            semester\n" +
            "        WHERE \n" +
            "            (\n" +
            "                (MONTH(CURRENT_DATE()) >= 5 AND SUBSTRING(course, 1, 4) = YEAR(CURRENT_DATE()))\n" +
            "                OR (MONTH(CURRENT_DATE()) < 5 AND SUBSTRING(course, 6, 9) = YEAR(CURRENT_DATE()))\n" +
            "            )\n" +
            "            AND (\n" +
            "                (MONTH(CURRENT_DATE()) >= 5 AND NAME = 'HK1')\n" +
            "                OR (MONTH(CURRENT_DATE()) < 5 AND NAME = 'HK2')\n" +
            "            )\n" +
            "    );", nativeQuery = true)
    List<Object[]> findStudentClasses(@Param("studentId") String studentId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM student_class WHERE class_id = :classId AND student_id = :studentId", nativeQuery = true)
    int deleteStudentFromClass(@Param("classId") String classId, @Param("studentId") String studentId);



}