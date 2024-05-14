package vn.edu.iuh.fit.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.core.dto.StudentClassInfoDTO;
import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.models.Response;
import vn.edu.iuh.fit.core.services.StudentServices;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/schedule")
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @GetMapping("/{studentId}")
    public ResponseEntity<Response> getStudentClasses(@PathVariable String studentId) {
        List<StudentClassInfoDTO> studentClasses = studentServices.getStudentClassInfo(studentId);
        if (studentClasses != null && !studentClasses.isEmpty()) {
            Response response = new Response(200, "Success", studentClasses);
            return ResponseEntity.ok(response);
        } else {
            Response response = new Response(404, "Not Found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}

