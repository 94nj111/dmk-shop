package com.example.dmk.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@SuppressWarnings(value = "deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/sign-up")
            .permitAll()
            .and()
            .exceptionHandling()
            .and()
            .formLogin()
            .loginProcessingUrl("/j_spring_security_check")
            .failureUrl("/login?error")
            .usernameParameter("j_login")
            .passwordParameter("j_password")
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout");
  }
}
