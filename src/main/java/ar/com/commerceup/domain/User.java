/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internalid;
    private String name;
    private String lastName;
    private String password;
    private String userName;
    private String email;
    private String roles;
    private boolean active;
    @Column(updatable=false)
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateModified;
    /*
    
        Optional<User> user = repo.findByUserName(username);
        return user.map(ApplicationUser::new).get();
        
    */

    public User(Integer internalid, String password, String userName, String roles) {
        this.internalid = internalid;
        this.password = password;
        this.userName = userName;
        this.roles = roles;
    }

    
    
}
