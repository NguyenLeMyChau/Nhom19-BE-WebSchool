package vn.edu.iuh.fit.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.core.dto.GradeInfoDTO;
import vn.edu.iuh.fit.core.dto.StudentClassInfoDTO;
import vn.edu.iuh.fit.core.models.*;
import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    private SubjectRepository subjectRepository;
    private SemesterRepository semesterRepository;

    @Autowired
    private GradeRepository gradeRepository;

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
                studentClassInfo.setStartDate(aclass.getStartDate());
                studentClassInfo.setEndDate(aclass.getEndDate());

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

    public List<GradeInfoDTO> getGradesByStudentAndSemester(String studentId, int semesterId) {
        List<GradeInfoDTO> gradeInfoList = new ArrayList<>();

        // Lấy danh sách Grade từ repository
        List<Grade> grades = gradeRepository.findGradesByStudentIdAndSemesterId(studentId, semesterId);

        // Ánh xạ thông tin từ Grade sang GradeInfoDTO
        for (Grade grade : grades) {
            GradeInfoDTO gradeInfo = new GradeInfoDTO();
            gradeInfo.setNameSemester(grade.getSubject().getSemester().getName());
            gradeInfo.setCourse(grade.getSubject().getSemester().getCourse());
            gradeInfo.setNameSubject(grade.getSubject().getName());
            gradeInfo.setStatusSubject(grade.getSubject().isStatus());
            gradeInfo.setTk1(grade.getTk1());
            gradeInfo.setTk2(grade.getTk2());
            gradeInfo.setTk3(grade.getTk3());
            gradeInfo.setTk4(grade.getTk4());
            gradeInfo.setTk5(grade.getTk5());
            gradeInfo.setTk6(grade.getTk6());
            gradeInfo.setTh1(grade.getTh1());
            gradeInfo.setTh2(grade.getTh2());
            gradeInfo.setTh3(grade.getTh3());
            gradeInfo.setTh4(grade.getTh4());
            gradeInfo.setTh5(grade.getTh5());
            gradeInfo.setCk(grade.getCk());
            gradeInfo.setGk(grade.getGk());

            gradeInfoList.add(gradeInfo);
        }

        return gradeInfoList;
    }

}