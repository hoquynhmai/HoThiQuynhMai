package com.codegym.config;

import com.codegym.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf
        http.csrf().disable();

        // login
        http.formLogin()
                .loginProcessingUrl("/checkLogin")
                .loginPage("/home")

                // login successful
                .defaultSuccessUrl("/home")

                // login failed
                .failureUrl("/login/error")

                // setting username, password
                .usernameParameter("username")
                .passwordParameter("password")

                // logout
                .and().logout().logoutUrl("/logout")

                // logout successful
                .logoutSuccessUrl("/home");


        // ----------------------- Authorization ---------------------------------
        // guest
        http.authorizeRequests().antMatchers("/", "/home", "/login", "/logout").permitAll();

        // member
//        http.authorizeRequests().antMatchers("/", "/student", "/student/detail").hasRole("USER");
//        http.authorizeRequests().antMatchers("/", "/student", "/student/detail")
//                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')");
        http.authorizeRequests().antMatchers(
                "/customer/**", "/employee/**", "/service/**", "/contract/**", "/contractDetail/**")
//                , "/customer/{id}/view", "/customer/create", "/customer/{id}/edit", "/customer/{id}/delete",
//                "/employee", "/employee/{id}/view",
//                "/service", "/service/{id}/view",
//                "/contract", "/contract/{id}/view",
//                "/contractDetail", "/contractDetail/{id}/view")
                .hasRole("MEMBER");

        // manager - director
//        http.authorizeRequests().antMatchers(
//                "/employee/create", "/employee/{id}/edit", "/employee/{id}/delete",
//                "/service/create", "/service/{id}/edit", "/service/{id}/delete",
//                "/contract/create", "/contract/{id}/edit", "/contract/{id}/delete",
//                "/contractDetail/create", "/contractDetail/{id}/edit", "/contractDetail/{id}/delete")
//                .access("hasAnyRole('ROLE_MANAGER')");

        // no permission
        http.exceptionHandling().accessDeniedPage("/403");

        // remember me
        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("rememberMeCookie")
                .tokenValiditySeconds(365*24*60*60)
                .tokenRepository(this.persistentTokenRepository());
    }

    // Token stored in Table - persistent_login
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
}
