package vn.edu.iuh.fit.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.models.Student;
import vn.edu.iuh.fit.core.models.Subject;

import vn.edu.iuh.fit.core.repositories.ClassRepository;
import vn.edu.iuh.fit.core.repositories.StudentRepository;
import vn.edu.iuh.fit.core.repositories.SubjectRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Nhom19BeWebSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(Nhom19BeWebSchoolApplication.class, args);
    }
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;



    @Bean
    CommandLineRunner initData(ClassRepository classRepository,
                               SubjectRepository subjectRepository,
                               StudentRepository studentRepository) {
        return args -> {

            Subject parentSubject = new Subject();
            parentSubject.setName("Parent Subject");
            subjectRepository.save(parentSubject);


// Tạo một đối tượng Subject mới
            Subject subject = new Subject();
            subject.setName("Child Subject");
            subject.setParent(parentSubject);
            subjectRepository.save(subject);

            // Tạo một danh sách sinh viên
            List<Student> students = new ArrayList<>();

            // T���o một sinh viên và thêm vào danh sách sinh viên
            Student student1 = new Student();
            student1.setName("John Doe"); // Đặt tên của sinh viên
            students.add(student1);
            studentRepository.save(student1);


            // Tạo một đối tượng LocalDate cho startDate và endDate
            LocalDate startDate = LocalDate.of(2024, 5, 10);
            LocalDate endDate = LocalDate.of(2024, 12, 31);


            Class myClass = new Class(
                    "Tên lớp học", // Tên lớp học
                    subject, // Môn học
                    30, // Số lượng tối đa học viên
                    null, // Danh sách học viên, bạn có thể thêm sau
                    "Tên giáo viên", // Tên giáo viên
                    "Thứ hai", // Ngày học
                    "Buổi sáng", // Buổi học
                    LocalDate.of(2024, 5, 10), // Ngày bắt đầu
                    LocalDate.of(2024, 8, 10) // Ngày kết thúc
            );

            classRepository.save(myClass);

        };
    }

}
