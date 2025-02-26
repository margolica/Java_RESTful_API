package edu.school21.java_RESTful_API.service;

import edu.school21.java_RESTful_API.model.Images;
import edu.school21.java_RESTful_API.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ImagesService {

    private final ImagesRepository imagesRepository;

    @Autowired
    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    @Transactional
    public void update(UUID id, byte[] image) {
        Images newImages = getById(id);
        newImages.setData(image);
        imagesRepository.save(newImages);
    }

    @Transactional
    public Images save(Images image) {
        return imagesRepository.save(image);
    }

    public Images getById(UUID id) {
        return imagesRepository.findById(id).get();
    }

    @Transactional
    public boolean delete(UUID id) {
        Optional<Images> image = imagesRepository.findById(id);
        if (image.isPresent()) {
            imagesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
