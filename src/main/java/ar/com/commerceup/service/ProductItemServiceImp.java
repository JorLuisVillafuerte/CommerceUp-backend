/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.service;

import ar.com.commerceup.dao.ProductItemDAO;
import ar.com.commerceup.domain.Product;
import ar.com.commerceup.domain.ProductItem;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductItemServiceImp implements ProductItemService{

    @Autowired
    ProductItemDAO productitemdao;
    
    @Override
    public List<ProductItem> findAllByProductId(Product product) {
        return productitemdao.findAllByProductId(product);
    }

    @Override
    public ProductItem save(ProductItem productitem) {
        return productitemdao.save(productitem);
    }

    @Override
    public List<ProductItem> findAll() {
        return (List<ProductItem>) productitemdao.findAll();
    }

    @Override
    public Optional<ProductItem> findByItemCode(String itemcode) {
        return productitemdao.findByItemCode(itemcode);
    }

    @Override
    public Optional<ProductItem> findById(Integer id) {
        return productitemdao.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return productitemdao.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        productitemdao.deleteById(id);
    }

    @Override
    public void delete(ProductItem productitem) {
        productitemdao.delete(productitem);
    }
    
}
