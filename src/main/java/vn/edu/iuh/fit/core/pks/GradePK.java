package vn.edu.iuh.fit.core.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.core.models.Class;
import vn.edu.iuh.fit.core.models.Student;
import vn.edu.iuh.fit.core.models.Subject;

import java.io.Serializable;

@Getter @Setter
public class GradePK implements Serializable {
    private Student student;
//    private Subject subject;
    private Class aClass;
}
