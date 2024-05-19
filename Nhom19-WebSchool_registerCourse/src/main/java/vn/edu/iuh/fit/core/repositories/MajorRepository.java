package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.core.models.Major;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Integer> {
    @Query(value = "" +
            "SELECT DISTINCT sub.subject_id, sub.credits, sub.name, sub.status, sub.tuition, sub.parent_id\n" +
            "FROM subject sub \n" +
            "JOIN student stu ON sub.major_id = stu.major_id\n" +
            "WHERE stu.major_id = :major \n" +
            "AND sub.subject_id NOT IN (\n" +
            "    SELECT c.subject_id\n" +
            "    FROM student_class sl \n" +
            "    JOIN class c ON c.class_id = sl.class_id\n" +
            "    JOIN subject s ON c.subject_id = s.subject_id\n" +
            "    WHERE student_id = :student\n" +
            ");",
            nativeQuery = true)
    List<Object[]> findSubjectsByMajorAndStudent(@Param("major") Integer major, @Param("student") String student);
}