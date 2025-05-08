package com.quocchung.SPRINGBOOT_BASE.config;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


public class LocalResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    String language_header = request.getHeader("Accept-Language");

    return StringUtils.hasLength(language_header) ? Locale.lookup(Locale.LanguageRange.parse(language_header),
        List.of(new Locale("en"), new Locale("fr"))
    ) : Locale.getDefault();
  }
}
