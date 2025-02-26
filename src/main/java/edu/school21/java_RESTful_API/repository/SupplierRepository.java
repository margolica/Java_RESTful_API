package edu.school21.java_RESTful_API.repository;

import edu.school21.java_RESTful_API.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
