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
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductDAO productdao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllByCategoryId(Category category) {
        return (List<Product>) productdao.findAllByCategoryId(category);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productdao.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        
        return (List<Product>) productdao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findByProductCode(String productcode) {
        return productdao.findByProductCode(productcode);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Integer id) {
        return productdao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {
        return productdao.existsById(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        productdao.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productdao.delete(product);
    }

    
}
