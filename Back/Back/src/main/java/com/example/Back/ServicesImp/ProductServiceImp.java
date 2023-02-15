package com.example.Back.ServicesImp;

import com.example.Back.Entities.Product;
import com.example.Back.Reposiroty.ProductRepository;
import com.example.Back.Services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No product ID: " + id));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);

    }

    @Override
    public Product updateProduct(Product product) {
        if(!productRepository.existsById(product.getId())){
            throw new NoSuchElementException("No Group With ID: " + product.getId());
        }

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
