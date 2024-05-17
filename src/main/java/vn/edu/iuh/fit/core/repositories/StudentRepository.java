package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.models.Semester;
import vn.edu.iuh.fit.core.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findStudentByIdAndPassword(String id, String password);

    @Query("SELECT sc.classInfo FROM StudentClass sc WHERE sc.student.id = :studentId")
    List<Class> findClassesByStudentId(@Param("studentId") String studentId);

//    @Modifying
//    @Transactional
//    @Query("UPDATE Student s SET s.completedCredits = :completedCredits WHERE s.id = :studentId")
//    void updateCompletedCredits(String studentId, int completedCredits);


    @Query("SELECT DISTINCT c.semester FROM StudentClass sc JOIN sc.classInfo c WHERE sc.student.id = :studentId ORDER BY c.semester.id ASC")
    List<Semester> findSemestersByStudentIdOrderBySemesterIdAsc(String studentId);

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.completedCredits = :completedCredits WHERE s.id = :studentId")
    void updateCompletedCredits(@Param("studentId") String studentId, @Param("completedCredits") int completedCredits);


//    @Transactional
//    @Modifying
//    @Query("UPDATE Student s SET s.completedCredits = :newCompletedCredits WHERE s.id = :studentId")
//    void updateCompletedCredits(@Param("studentId") String studentId, @Param("newCompletedCredits") int newCompletedCredits);
}