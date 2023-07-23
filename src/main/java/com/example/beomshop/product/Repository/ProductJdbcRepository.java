package com.example.beomshop.product.Repository;

import com.example.beomshop.product.domain.Category;
import com.example.beomshop.product.domain.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

import static com.example.beomshop.util.JdbcUtil.*;

@Repository
public class ProductJdbcRepository implements ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final RowMapper<Product> productRowMapper = (resultSet, i) -> {
        UUID productId = toUUID(resultSet.getBytes("product_id"));
        String productName = resultSet.getString("product_name");
        Category category = Category.valueOf(resultSet.getString("category"));
        long price = resultSet.getLong("price");
        String description = resultSet.getString("description");
        LocalDateTime createdAt = toLocalDateTime(resultSet.getTimestamp("created_at"));
        LocalDateTime updatedAt = toLocalDateTime(resultSet.getTimestamp("updated_at"));
        return new Product(productId, productName, category, price, description, createdAt, updatedAt);
    };

    private Map<String, Object> toParamMap(Product product) {
        return Map.of(
                "productId", product.getProductId().toString(),
                "productName", product.getProductName(),
                "category", product.getCategory().toString(),
                "price", product.getPrice(),
                "description", product.getDescription(),
                "createdAt", product.getCreatedAt(),
                "updatedAt", product.getUpdatedAt()
        );
    }

    public ProductJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product insert(Product product) {
        jdbcTemplate.update("INSERT INTO products(product_id, product_name, category, price, description, created_at, updated_at)" +
              " VALUES (:productId, :productName, :category, :price, :description, :createdAt, :updatedAt)", toParamMap(product));

        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        return jdbcTemplate.query("SELECT * FROM products WHERE product_id = :productId",
                Collections.singletonMap("productId", productId), productRowMapper).stream()
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM products", productRowMapper);
    }

    @Override
    public Optional<Product> findByName(String productName) {
        return jdbcTemplate.query("SELECT * FROM products WHERE product_name = :productName",
                Collections.singletonMap("productName", productName), productRowMapper).stream()
                .findFirst();
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return jdbcTemplate.query(
                        "SELECT * FROM products WHERE category = :category",
                        Collections.singletonMap("category", category.toString()),
                        productRowMapper
                );
    }

    @Override
    public void deleteById(UUID productId) {
        jdbcTemplate.update(
                        "DELETE FROM products WHERE product_id = :product_id;", Collections.singletonMap("product_id", productId));
    }
}
