package vn.edu.iuh.fit.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.core.dto.GradeInfoDTO;
import vn.edu.iuh.fit.core.dto.SemesterGradeInfo;
import vn.edu.iuh.fit.core.dto.StudentClassInfoDTO;
import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.models.Grade;
import vn.edu.iuh.fit.core.models.Response;
import vn.edu.iuh.fit.core.models.Semester;
import vn.edu.iuh.fit.core.services.StudentServices;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("")
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @GetMapping("/{studentId}/schedule")
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

    @GetMapping("/{studentId}/grades")
    public ResponseEntity<List<GradeInfoDTO>> getGradesByStudentAndSemester(
            @PathVariable String studentId,
            @RequestParam int semesterId) {
        List<GradeInfoDTO> grades = studentServices.getGradesByStudentAndSemester(studentId, semesterId);
        return ResponseEntity.ok(grades);
    }


    @GetMapping("/{studentId}/semesters")
    public ResponseEntity<List<Semester>> getSemestersByStudentId(@PathVariable String studentId) {
        List<Semester> semesters = studentServices.findSemestersByStudentIdOrderBySemesterIdAsc(studentId);
        return ResponseEntity.ok().body(semesters);
    }

    @GetMapping("/{studentId}/semester-average")
    public ResponseEntity<SemesterGradeInfo> getSemesterAverage(
            @PathVariable String studentId,
            @RequestParam int semesterId) {
        SemesterGradeInfo semesterGradeInfo = studentServices.calculateSemesterAverage(studentId, semesterId);
        return ResponseEntity.ok(semesterGradeInfo);
    }


}

