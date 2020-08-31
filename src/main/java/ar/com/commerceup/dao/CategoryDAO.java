package ar.com.commerceup.dao;

import ar.com.commerceup.domain.Category;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDAO extends CrudRepository<Category,Integer>{
    public abstract Optional<Category> findyByCategoryCode(String categorycode);
}
