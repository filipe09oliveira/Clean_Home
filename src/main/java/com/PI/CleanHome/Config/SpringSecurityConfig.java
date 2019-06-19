package com.PI.CleanHome.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAppUserDetailsService myAppUserDetailsService;
   
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/perfilCliente/**").hasAnyRole("cliente")
                .antMatchers("/tabelaDashbordCleaner/**").hasAnyRole("admin")
                .antMatchers("/perfilCleaner/**").hasAnyRole("cleaner")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/fazer-login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }

    @Autowired
   	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	      auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}
    
}
