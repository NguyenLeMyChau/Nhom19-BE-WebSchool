package vn.edu.iuh.fit.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.core.models.Grade;


@Getter
@Setter
public class GradeInfoDTO {
    private String nameSemester;
    private String course;
    private String classId;
    private String nameSubject;
    private boolean statusSubject;
    private float tk1;
    private float tk2;
    private float tk3;
    private float tk4;
    private float tk5;
    private float tk6;
    private float th1;
    private float th2;
    private float th3;
    private float th4;
    private float th5;
    private float ck;
    private float gk;
}
