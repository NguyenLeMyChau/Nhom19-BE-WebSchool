package vn.edu.iuh.fit.core.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.fit.core.pks.StudentIdGenerator;

import java.time.LocalDate;
import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private String id;
    @Column(length = 200)
    private String name;
    private boolean gender;
    private LocalDate dateOfBirth;
    @Column(length = 300)
    private String address;
    private String password;
    private String course;
    private int completedCredits;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Class classInfo;
    // Constructor
    public Student() {
        // Tạo ID duy nhất khi khởi tạo sinh viên mới
        this.id = StudentIdGenerator.generateUniqueId();
    }

    public Student(String name, boolean gender, LocalDate dateOfBirth, String address, String password, String course, int completedCredits, Major major, Class classInfo) {
        this();
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.password = password;
        this.course = course;
        this.completedCredits = completedCredits;
        this.major = major;
        this.classInfo = classInfo;
    }
}
