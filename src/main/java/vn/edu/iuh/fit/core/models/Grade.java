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
@Table(name = "grade")
@IdClass(GradePK.class)
public class Grade {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "subject_id")
//    private Subject subject;

    @Id
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;
    private float grade;
}
