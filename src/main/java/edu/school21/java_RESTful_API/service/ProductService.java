package edu.school21.java_RESTful_API.service;

import edu.school21.java_RESTful_API.model.Product;
import edu.school21.java_RESTful_API.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void updateAvailableStock(Long id, int count) {
        getById(id).setAvailableStock(getById(id).getAvailableStock() - count);
    }

    public List<Product> getAll() {
        List<Product> listProducts = productRepository.findAll();
        List<Product> listProductsResult = new ArrayList<>();
        for (Product product : listProducts) {
            if (product.getAvailableStock() > 0)
                listProductsResult.add(product);
        }
        return listProductsResult;
    }

    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    public boolean delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        } else {
            return false;
        }
    }
}