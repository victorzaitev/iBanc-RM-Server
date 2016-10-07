/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Zaițev.Victor
 */
public class LoginFormValidator {

    private final Pattern passwordPattern;
    private final Pattern loginPattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*#?&\\.-_,|~`])[A-Za-z\\d$@$!%*#?&\\.-_,|~`]{6,20}$";

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_\\.-]{3,15}$";

    public LoginFormValidator() {

        passwordPattern = Pattern.compile(PASSWORD_PATTERN);
        loginPattern = Pattern.compile(USERNAME_PATTERN);
    }

    public boolean isLoginValid(final String loginName) {
        matcher = loginPattern.matcher(loginName);
        return matcher.matches();
    }

    public boolean isValidPassword(final String password) {
        matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
}
