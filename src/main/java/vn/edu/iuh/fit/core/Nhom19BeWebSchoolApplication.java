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

}
