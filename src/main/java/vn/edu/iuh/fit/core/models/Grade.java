package vn.edu.iuh.fit.core.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.core.pks.GradePK;

@Entity
@IdClass(GradePK.class)
@Table(name = "grade")
public class Grade {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;
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
    private float gk;
    private float ck;


}
