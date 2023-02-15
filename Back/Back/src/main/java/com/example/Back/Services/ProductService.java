package com.example.Back.Services;


import com.example.Back.Entities.Product;
import com.example.Back.Entities.RestauAgent;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long id);
}
