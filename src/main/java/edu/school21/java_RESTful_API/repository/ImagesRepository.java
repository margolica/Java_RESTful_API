package edu.school21.java_RESTful_API.repository;

import edu.school21.java_RESTful_API.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ImagesRepository extends JpaRepository<Images, UUID>{

}
