package edu.school21.java_RESTful_API.repository;

import edu.school21.java_RESTful_API.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
