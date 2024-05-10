package vn.edu.iuh.fit.core.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private int id;
    private String name;
    @OneToMany(mappedBy = "semester",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Subject> subjects;
    @Column(length = 100)
    private String course;
}
