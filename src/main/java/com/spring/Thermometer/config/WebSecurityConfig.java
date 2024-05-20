package com.spring.Thermometer.config;

import com.spring.Thermometer.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig{
    private static final ClearSiteDataHeaderWriter.Directive[] SOURCE =
            {ClearSiteDataHeaderWriter.Directive.CACHE, ClearSiteDataHeaderWriter.Directive.COOKIES, ClearSiteDataHeaderWriter.Directive.STORAGE, ClearSiteDataHeaderWriter.Directive.EXECUTION_CONTEXTS};
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    @Qualifier("BCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return authProvider;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.requestMatchers("/WEB-INF/jsp/**").permitAll());
        http.authorizeHttpRequests(
                        auth -> auth.requestMatchers("/register").permitAll()
                                .anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login")
                        .failureUrl("/login?error=true")
                        .loginProcessingUrl("/loginUser")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout=true")
                        .addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(SOURCE))).permitAll()
                );
        return http.build();
    }


}