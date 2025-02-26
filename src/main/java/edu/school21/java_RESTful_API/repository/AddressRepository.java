package edu.school21.java_RESTful_API.repository;

import edu.school21.java_RESTful_API.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
