package com.prem.hotelmanagement.api.config;

import com.prem.hotelmanagement.api.Security.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    EmployeeDetails employeeDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/help","/help/**").permitAll().and()
                .authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')").and()
//                .authorizeRequests().antMatchers("/admin/employee").access("hasRole('ADMIN')").and()

                .authorizeRequests().antMatchers(HttpMethod.GET,"/rooms").permitAll().and()
                .authorizeRequests().antMatchers(HttpMethod.POST,"/rooms").access("hasRole('ADMIN') or hasRole('RECEPTIONIST')").and()

                .authorizeRequests().antMatchers(HttpMethod.GET,"/user","/user/*").access("hasRole('ADMIN') or hasRole('RECEPTIONIST')").and()
                .authorizeRequests().antMatchers("/user","/user/*").access("hasRole('RECEPTIONIST')").and()

                .authorizeRequests().antMatchers(HttpMethod.GET,"/bookings","/bookings/*").access("hasRole('ADMIN') or hasRole('RECEPTIONIST')").and()
                .authorizeRequests().antMatchers("/bookings","/bookings/*").access("hasRole('RECEPTIONIST')").and()

                .authorizeRequests().anyRequest().authenticated().and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.employeeDetails).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
