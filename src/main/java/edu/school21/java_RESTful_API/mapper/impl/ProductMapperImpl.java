package edu.school21.java_RESTful_API.mapper.impl;

import edu.school21.java_RESTful_API.dto.ProductDto;
import edu.school21.java_RESTful_API.mapper.ProductMapper;
import edu.school21.java_RESTful_API.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDto clientDto) {
        if (clientDto == null) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name(clientDto.getName());
        product.category(clientDto.getCategory());
        product.price(clientDto.getPrice());
        product.availableStock(clientDto.getStock());
        product.lastUpdateDate(clientDto.getLastUpdateDate());

        return product.build();
    }

    @Override
    public ProductDto toDTO(Product client) {
        if (client == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setName(client.getName());
        productDto.setCategory(client.getCategory());
        productDto.setPrice(client.getPrice());
        productDto.setStock(client.getAvailableStock());
        productDto.setLastUpdateDate(client.getLastUpdateDate());

        return productDto;
    }

    @Override
    public List<ProductDto> toDTOList(List<Product> clients) {
        if (clients == null) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>(clients.size());
        for (Product product : clients) {
            list.add(toDTO(product));
        }

        return list;
    }
}