package edu.school21.java_RESTful_API.controller;

import edu.school21.java_RESTful_API.controller.description.ProductApi;
import edu.school21.java_RESTful_API.dto.ProductDto;
import edu.school21.java_RESTful_API.mapper.ProductMapper;
import edu.school21.java_RESTful_API.model.Product;
import edu.school21.java_RESTful_API.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController implements ProductApi {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public ResponseEntity<String> createProduct(ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Product not valid", HttpStatus.BAD_REQUEST);
        Product newProduct = productService.save(productMapper.toEntity(productDto));
        if (newProduct == null)
            return ResponseEntity.badRequest().build();
        else {
            URI locationNewProduct = URI.create("http://localhost:8082/api/v1/products/" + newProduct.getId());
            return ResponseEntity.created(locationNewProduct).build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<Void> updateAvailableStock(Long id, int count) {
        ResponseEntity<ProductDto> response = getProductById(id);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST || count < 0 || count > response.getBody().getStock())
            return ResponseEntity.badRequest().build();
        else if (response.getStatusCode() == HttpStatus.NOT_FOUND)
            return ResponseEntity.notFound().build();

        productService.updateAvailableStock(id, count);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Long id) {
        if (id < 0)
            return ResponseEntity.badRequest().body(null);
        ProductDto productDto = productMapper.toDTO(productService.getById(id));
        if (productDto == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(productDto);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> listProductDto =  productMapper.toDTOList(productService.getAll());
        return ResponseEntity.ok(listProductDto);
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleted(Long id) {
        if (productService.delete(id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}
