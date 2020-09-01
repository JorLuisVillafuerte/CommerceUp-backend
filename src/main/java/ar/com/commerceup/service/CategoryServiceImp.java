/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.service;

import ar.com.commerceup.dao.CategoryDAO;
import ar.com.commerceup.domain.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    @Qualifier("category")
    CategoryDAO categorydao;
    
    @Override
    public Category save(Category category) {
        return categorydao.save(category);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categorydao.findAll();
    }

    @Override
    public Optional<Category> findByCategoryCode(String categorycode) {
        return categorydao.findByCategoryCode(categorycode);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categorydao.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return categorydao.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        categorydao.deleteById(id);
    }

    @Override
    public void delete(Category category) {
        categorydao.delete(category);
    }
    
}
