package ar.com.commerceup;

import ar.com.commerceup.auth.ApplicationUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
public class CommerceupApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommerceupApplication.class, args);
    }

}
