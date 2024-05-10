//package vn.edu.iuh.fit.core.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Table(name = "teacher")
//public class Teacher {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "teacher_id")
//    private int id;
//    @Column(length = 100)
//    private String name;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id")
//    private Department department;
//    @Column(length = 100)
//    private String email;
//}
