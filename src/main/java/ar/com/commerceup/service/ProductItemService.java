/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.service;

import ar.com.commerceup.domain.Product;
import ar.com.commerceup.domain.ProductItem;
import java.util.List;
import java.util.Optional;

public interface ProductItemService {
    
    public List<ProductItem>findAllByProductId(Product product);
    public ProductItem save(ProductItem productitem);
    public List<ProductItem> saveAll(List<ProductItem> productitem);
    public List<ProductItem> findAll();
    public Optional<ProductItem> findByItemCode(String itemcode);
    public Optional<ProductItem> findById(Integer id);
    public boolean existsById(Integer id);
    public void deleteById(Integer id);
    public void delete(ProductItem productitem);
}
