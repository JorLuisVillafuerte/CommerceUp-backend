/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.dao;

import ar.com.commerceup.domain.Category;
import org.springframework.data.repository.CrudRepository;
import ar.com.commerceup.domain.Product;
import java.util.Optional;

public interface ProductDAO extends CrudRepository<Product,Integer> {
    public abstract Optional<Product> findyByProductCode(String productcode);
    public abstract Iterable<Product> findAllByCategoryId(Category category);

}
