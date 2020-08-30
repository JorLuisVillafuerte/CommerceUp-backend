package ar.com.commerceup.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;
import static ar.com.commerceup.security.ApplicationUserPermission.*;

//CONTIENE LOS ROLES DE LA APLICACION
//DEPENDIENDO EL ROL SE TIENEN X PERMISOS A RECURSOS
public enum ApplicationUserRole {
    USER(Sets.newHashSet(PRODUCT_READ, CATEGORY_READ)),
    ADMIN(Sets.newHashSet(PRODUCT_READ,PRODUCT_WRITE, CATEGORY_READ,CATEGORY_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    //RETORNA LOS PERMISOS AUTORIZADOS
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
