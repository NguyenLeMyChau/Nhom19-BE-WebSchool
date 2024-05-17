package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.core.models.Class;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, String> {

}