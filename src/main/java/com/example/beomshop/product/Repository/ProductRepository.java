package com.example.beomshop.product.Repository;

import com.example.beomshop.product.domain.Category;
import com.example.beomshop.product.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
  List<Product> findAll();

  Product insert(Product product);

  Product update(Product product);

  Optional<Product> findById(UUID productId);

  Optional<Product> findByName(String productName);

  List<Product> findByCategory(Category category);

  void deleteById(UUID productId);
}
