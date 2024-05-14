package vn.edu.iuh.fit.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.core.dto.StudentClassInfoDTO;
import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.models.Student;
import vn.edu.iuh.fit.core.models.Subject;
import vn.edu.iuh.fit.core.repositories.ClassRepository;
import vn.edu.iuh.fit.core.repositories.StudentRepository;
import vn.edu.iuh.fit.core.repositories.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<StudentClassInfoDTO> getStudentClassInfo(String studentId) {
        List<StudentClassInfoDTO> studentClassInfoList = new ArrayList<>();

        // Lấy sinh viên từ repository
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            // Lấy các lớp học mà sinh viên tham gia
            List<Class> classes = student.getClasses();
            for (Class aclass : classes) {
                // Tạo một đối tượng StudentClassInfoDTO và thiết lập thông tin
                StudentClassInfoDTO studentClassInfo = new StudentClassInfoDTO();
                studentClassInfo.setClassName(aclass.getName());
                studentClassInfo.setClassCode(aclass.getId());
                studentClassInfo.setLesson(aclass.getLesson());
                studentClassInfo.setClassroom(aclass.getClassroom());
                studentClassInfo.setDateOfWeek(aclass.getDayOfWeek());

                // Lấy thông tin môn học từ class
                Subject subject = aclass.getSubject();
                if (subject != null) {
                    studentClassInfo.setSubjectName(subject.getName());
                }

                // Lấy thông tin giáo viên từ class
                studentClassInfo.setTeacherName(aclass.getTeacher());

                studentClassInfoList.add(studentClassInfo);
            }
        }

        return studentClassInfoList;
    }
}