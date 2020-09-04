package ar.com.commerceup.dao;

import ar.com.commerceup.domain.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface UserDAO extends CrudRepository<User, Integer> {
   public abstract Optional<User> findByUserName(String username);
}
