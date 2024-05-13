package vn.edu.iuh.fit.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.core.models.Student;
import vn.edu.iuh.fit.core.repositories.StudentRepository;

@Service
public class LoginServices {
    @Autowired
    private StudentRepository studentRepository;

    public Student checkLogin(String username, String password) {
        return studentRepository.findStudentByIdAndPassword(username, password).orElse(null);
    }
}
