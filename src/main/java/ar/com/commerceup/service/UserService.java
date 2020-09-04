/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.service;

import java.util.List;
import java.util.Optional;
import ar.com.commerceup.domain.User;

public interface UserService {
    
    public User save(User user);
    public List<User> findAll();
    public Optional<User> findByUserName(String userName);
    public Optional<User> findById(Integer id);
    public boolean existsById(Integer id);
    public void deleteById(Integer id);
    public void delete(User user);
}
