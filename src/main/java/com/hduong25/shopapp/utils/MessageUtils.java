package com.hduong25.shopapp.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author: hduong25
 */

@Component
@RequiredArgsConstructor
public class MessageUtils {

    private final MessageSource messageSource;

    public String getMessage(String code, Object[] args) {
        final Locale currentLocale = LocaleContextHolder.getLocale();
        return this.messageSource.getMessage(code, args, currentLocale);
    }

    public String getMessage(String code) {
        return this.getMessage(code, null);
    }
}
