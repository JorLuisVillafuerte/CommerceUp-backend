package ar.com.commerceup.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.commerceup.domain.User;
import ar.com.commerceup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
@Slf4j
public class UserRestController {
    
    @Autowired
    UserService userserivce;
    
    @PostMapping("/")
    public User registrarUsuario(@RequestBody User user){
        return userserivce.save(user);
    }
}
