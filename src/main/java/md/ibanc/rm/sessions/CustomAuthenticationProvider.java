/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.sessions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import md.ibanc.rm.entities.Users;
import md.ibanc.rm.spring.service.UsersService;
import md.ibanc.rm.util.FormatPassword;
import md.ibanc.rm.util.UtilHashMD5;
import md.ibanc.rm.validators.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Zaițev.Victor
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        LoginFormValidator loginFormValidator = new LoginFormValidator();

        if (!loginFormValidator.isLoginValid(username)) {
            throw new BadCredentialsException("Numele de utilizator contine simboluri interzise");
        }

        if (!loginFormValidator.isValidPassword(password)) {
            throw new BadCredentialsException("Parola contine simboluri interzise");
        }

        Users users = usersService.findUserByEmail(username);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        String hashPassword = UtilHashMD5.createMD5Hash(FormatPassword.CreatePassword(users.getId(), password));

        if (!hashPassword.equals(users.getPassword())) {
            throw new BadCredentialsException("Parola este gresita");
        }

        if (!users.getActive()) {
            throw new AccountExpiredException("Nu aveti drept sa accesati acest serviciu");
        }

        Collection<? extends GrantedAuthority> authoritiesRoles = getAuthorities(users);

        return new UsernamePasswordAuthenticationToken(username, hashPassword, authoritiesRoles);

    }

    @Override
    public boolean supports(Class<?> type) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    private List<GrantedAuthority> getAuthorities(Users users) {

        List<GrantedAuthority> authoritys = new ArrayList<>();

        authoritys.add(new SimpleGrantedAuthority(users.getUserRoles().getUserRole()));

        return authoritys;
    }

}
