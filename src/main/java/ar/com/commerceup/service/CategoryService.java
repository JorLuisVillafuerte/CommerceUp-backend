package ar.com.commerceup.service;
import ar.com.commerceup.domain.Category;
import java.util.Optional;

public interface CategoryService {
    public Optional<Category> findyByCategoryCode(String categorycode);
    public Category save(Category category);
    public Optional<Category> findById(Integer id);
    public boolean existsById(Integer id);
    public Iterable<Category> findAll();
    public Iterable<Category> findAllById(Integer id);
    public void deleteById(Integer id);
    public void delete(Category category);
}
