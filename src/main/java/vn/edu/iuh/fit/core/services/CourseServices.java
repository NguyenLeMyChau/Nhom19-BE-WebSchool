package vn.edu.iuh.fit.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.core.dto.RegisteredDTO;
import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.models.Semester;
import vn.edu.iuh.fit.core.repositories.ClassRepository;
import vn.edu.iuh.fit.core.repositories.MajorRepository;
import vn.edu.iuh.fit.core.repositories.SemesterRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseServices {
    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private ClassRepository classRepository;

    public Semester getCurrentSemesters() {
        return semesterRepository.findCurrentSemesters();
    }

    public List<Semester> getSemestersInRange(String course) {
        return semesterRepository.findSemestersInRange(course);
    }

    public List<Object[]> findSubjectsByMajorAndStudent(Integer major, String student) {
        return majorRepository.findSubjectsByMajorAndStudent(major, student);
    }

    public List<Class> findClassesBySubjectAndSemester(String subject, int semester) {
        return classRepository.findClassesBySubjectAndSemester(subject, semester);
    }

    public boolean enrollStudentToClass(String studentId, String classId, LocalDate regisDate) {
        int rowsAffected = classRepository.enrollStudentToClass(studentId, classId, regisDate);
        return rowsAffected > 0;
    }

    public int countStudentsInClass(String classId) {
        return classRepository.countStudentsInClass(classId);
    }

    public List<Object[]> findStudentClasses(String studentId) {
        return classRepository.findStudentClasses(studentId);
    }

    public boolean deleteStudentFromClass(String classId, String studentId) {
        int rowsAffected = classRepository.deleteStudentFromClass(classId, studentId);
        return rowsAffected > 0;
    }
}
