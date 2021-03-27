package com.nnamdi.notification.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }


    /**
     * Validates email with regular expression
     * @param email
     * @return true for valid email and false for invalid email.
     */
    public boolean isValid(final String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
