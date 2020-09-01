/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.service;

import ar.com.commerceup.dao.ProductDAO;
import ar.com.commerceup.domain.Category;
import ar.com.commerceup.domain.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductDAO productdao;
    
    @Override
    public List<Product> findAllByCategoryId(Category category) {
        return (List<Product>) productdao.findAllByCategoryId(category);
    }

    @Override
    public Product save(Product product) {
        return productdao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productdao.findAll();
    }

    @Override
    public Optional<Product> findByProductCode(String productcode) {
        return productdao.findByProductCode(productcode);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productdao.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return productdao.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        productdao.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        productdao.delete(product);
    }
    
}
