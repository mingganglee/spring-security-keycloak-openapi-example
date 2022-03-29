package com.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Component
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .mvcMatchers("/api/myapp/**").authenticated()
                .mvcMatchers("/oauth2-redirect.html", "/swagger-ui.html", "/v3/api-docs", "/swagger-ui/index.html", "/swagger-ui/**",
                        "/api/loggedin/confirm/**", "/api/loggedin/confirm/", "/public/oauth2-redirect.html", "/context-path/v3/api-docs", "/context-path/v3/api-docs/**", "/swagger-ui-custom.html").permitAll()
                .mvcMatchers("/api/myapp/testpage").hasAuthority("SCOPE_write")
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {


            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:9090");
            }
        };
    }
}



