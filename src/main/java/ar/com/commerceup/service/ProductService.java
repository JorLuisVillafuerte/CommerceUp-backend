/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.service;

import ar.com.commerceup.domain.Category;
import ar.com.commerceup.domain.Product;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author villa
 */
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
