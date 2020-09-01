package ar.com.commerceup.service;
import ar.com.commerceup.domain.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    
    public Category save(Category category);
    public List<Category> findAll();
    public Optional<Category> findByCategoryCode(String categorycode);
    public Optional<Category> findById(Integer id);
    public boolean existsById(Integer id);
    public void deleteById(Integer id);
    public void delete(Category category);
}
