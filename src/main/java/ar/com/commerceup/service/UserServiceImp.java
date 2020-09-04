package ar.com.commerceup.service;

import ar.com.commerceup.dao.UserDAO;
import ar.com.commerceup.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImp implements UserService{

    @Autowired  
    UserDAO userservice;
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userservice.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userservice.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByUserName(String userName) {
        return userservice.findByUserName(userName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        return userservice.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {
        return userservice.existsById(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        userservice.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userservice.delete(user);
    }
    
}
