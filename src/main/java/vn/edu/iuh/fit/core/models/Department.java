//package vn.edu.iuh.fit.core.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@Table(name = "department")
//public class Department {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "department_id")
//    private int id;
//    @Column(length = 50)
//    private String name;
//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//    private List<Major> majors;
//
//}
