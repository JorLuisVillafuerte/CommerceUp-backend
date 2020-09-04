package ar.com.commerceup.auth;

import ar.com.commerceup.domain.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ar.com.commerceup.dao.UserDAO;

@Service
public class ApplicationUserService implements UserDetailsService {

  
    @Autowired
    PasswordEncoder passwordEncoder;
            
    @Autowired
    UserDAO repo;
   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<User> user = repo.findByUserName(username);
        return user.map(ApplicationUser::new).get();
        
        /*return applicationUserDao
                .selectApplicationUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );*/
    }
}
