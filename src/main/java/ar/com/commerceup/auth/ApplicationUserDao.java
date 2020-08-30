package ar.com.commerceup.auth;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserDao extends CrudRepository<ApplicationUser, Integer>{

    Optional<ApplicationUser> findByUserName(String username);
    
}
