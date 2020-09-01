package ar.com.commerceup.dao;

import ar.com.commerceup.domain.Category;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "category")
public interface CategoryDAO extends CrudRepository<Category,Integer>{
    public abstract Optional<Category> findByCategoryCode(String categorycode);
    
}
