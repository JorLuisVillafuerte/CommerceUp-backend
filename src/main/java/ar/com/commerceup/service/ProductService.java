package ar.com.commerceup.service;

import ar.com.commerceup.domain.Category;
import ar.com.commerceup.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    
    public List<Product>findAllByCategoryId(Category category);
    public Product save(Product product);
    public List<Product> findAll();
    public Optional<Product> findByProductCode(String productcode);
    public Optional<Product> findById(Integer id);
    public boolean existsById(Integer id);
    public void deleteById(Integer id);
    public void delete(Product product);
}
