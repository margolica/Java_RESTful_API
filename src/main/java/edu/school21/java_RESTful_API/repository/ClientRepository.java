package edu.school21.java_RESTful_API.repository;

import edu.school21.java_RESTful_API.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByFirstNameAndLastName(String firstName, String lastName);
}
