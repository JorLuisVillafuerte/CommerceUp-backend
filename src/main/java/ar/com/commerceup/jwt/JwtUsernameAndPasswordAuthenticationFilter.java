package ar.com.commerceup.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
//import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

//CLASE QUE AUTENTICA LAS CREDENCIALES
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtconfig;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager, JwtConfig jwtconfig) {
        this.authenticationManager = authenticationManager;
        this.jwtconfig = jwtconfig;
    }

    //FUNCION - VALIDA EL INTENTO DE LOG IN
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper().readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );
            return authenticationManager.authenticate(authentication);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    //FUNCION - GENERA TOKEN EN CASO DE UNA AUTENTICACION EXITOSA
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String secret = "kokokokokokokokokokokokokokokokokokokokokokokokokokokokokokokokokokokoko";

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
                            SignatureAlgorithm.HS256.getJcaName());
        
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new java.util.Date())
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 900000))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                //.signWith(SignatureAlgorithm.HS256, hmacKey)
                //.signWith(Keys.hmacShaKeyFor(jwtconfig.getSecretKeyForLogin()))
                //.signWith(SignatureAlgorithm.HS256, jwtconfig.getSecretKeyForLogin())
                .compact();
        response.addHeader(jwtconfig.getAuthorizationHeader(),jwtconfig.getPrefix()+token);
    }
}
