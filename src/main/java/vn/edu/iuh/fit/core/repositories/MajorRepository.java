package vn.edu.iuh.fit.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.core.models.Major;

public interface MajorRepository extends JpaRepository<Major, Integer> {
}