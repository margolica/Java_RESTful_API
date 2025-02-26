package edu.school21.java_RESTful_API.controller;

import edu.school21.java_RESTful_API.controller.description.ImagesApi;
import edu.school21.java_RESTful_API.dto.ImagesDto;
import edu.school21.java_RESTful_API.dto.ProductDto;
import edu.school21.java_RESTful_API.mapper.ImagesMapper;
import edu.school21.java_RESTful_API.model.Images;
import edu.school21.java_RESTful_API.service.ImagesService;
import edu.school21.java_RESTful_API.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/images")
@Transactional(readOnly = true)
public class ImagesController implements ImagesApi {

    private final ImagesService imagesService;
    private final ProductService productService;
    private final ImagesMapper imagesMapper;
    private final ProductController productController;

    public ImagesController(ImagesService imagesService, ProductService productService, ImagesMapper imagesMapper, ProductController productController) {
        this.imagesService = imagesService;
        this.productService = productService;
        this.imagesMapper = imagesMapper;
        this.productController = productController;
    }

    @Override
    @Transactional
    public ResponseEntity<Void> create(byte[] data) {
        ImagesDto imagesDto = new ImagesDto();
        imagesDto.setData(data);
        System.out.println(imagesDto.getData());
        Images newImages = imagesService.save(imagesMapper.toEntity(imagesDto));

        if (newImages == null)
            return ResponseEntity.badRequest().build();
        else {
            URI locationNewImages = URI.create("http://localhost:8082/api/v1/images/" + newImages.getId());
            return ResponseEntity.created(locationNewImages).build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<Void> updateImages(UUID id, byte[] data) {
        ImagesDto imagesDto = new ImagesDto(data);

        ResponseEntity<byte[]> response = getImageById(id);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST)
            return ResponseEntity.badRequest().build();
        else if (response.getStatusCode() == HttpStatus.NOT_FOUND)
            return ResponseEntity.notFound().build();

        imagesService.update(id, data);

        byte[] updateImagesDto = response.getBody();

        if(updateImagesDto != null && !imagesDto.getData().equals(updateImagesDto))
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<byte[]> getImageProductId(Long productId) {
        ResponseEntity<ProductDto> response = productController.getProductById(productId);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST)
            return ResponseEntity.badRequest().build();
        else if (response.getStatusCode() == HttpStatus.NOT_FOUND)
            return ResponseEntity.notFound().build();

        ImagesDto imagesDto = imagesMapper.toDTO(productService.getById(productId).getImage());

        return ResponseEntity
                .ok()
                .header("Content-Type", "application/octet-stream")
                .header("Content-Disposition", "attachment; filename=\"image" + ".png\"")
                .body(imagesDto.getData());
    }

    @Override
    public ResponseEntity<byte[]> getImageById(UUID id) {
        ImagesDto imagesDto = imagesMapper.toDTO(imagesService.getById(id));

        if (imagesDto == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity
                    .ok()
                    .header("Content-Type", "application/octet-stream")
                    .header("Content-Disposition", "attachment; filename=\"image" + ".png\"")
                    .body(imagesDto.getData());
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleted(UUID id) {
        if (imagesService.delete(id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}
