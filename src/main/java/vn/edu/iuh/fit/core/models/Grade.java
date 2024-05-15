package vn.edu.iuh.fit.core.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.core.pks.GradePK;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @Column(nullable = true)
    private float tk1;
    @Column(nullable = true)
    private float tk2;
    @Column(nullable = true)
    private float tk3;
    @Column(nullable = true)
    private float tk4;
    @Column(nullable = true)
    private float tk5;
    @Column(nullable = true)
    private float tk6;
    @Column(nullable = true)
    private float th1;
    @Column(nullable = true)
    private float th2;
    @Column(nullable = true)
    private float th3;
    @Column(nullable = true)
    private float th4;
    @Column(nullable = true)
    private float th5;
    @Column(nullable = true)
    private float gk;
    @Column(nullable = true)
    private float ck;


}
