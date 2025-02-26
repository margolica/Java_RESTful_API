package edu.school21.java_RESTful_API.mapper;

import edu.school21.java_RESTful_API.dto.ProductDto;
import edu.school21.java_RESTful_API.model.Product;

import java.util.List;

public interface ProductMapper {
    Product toEntity(ProductDto clientDto);

    ProductDto toDTO(Product client);

    List<ProductDto> toDTOList(List<Product> clients);
}
