/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.dao;

import org.springframework.data.repository.CrudRepository;
import ar.com.commerceup.domain.Product;
import ar.com.commerceup.domain.ProductItem;
import java.util.List;
import java.util.Optional;

public interface ProductItemDAO extends CrudRepository<ProductItem,Integer>{
    public abstract List<ProductItem> findAllByProductId(Product product);
    public abstract Optional<ProductItem> findByItemCode(String itemcode);

}
