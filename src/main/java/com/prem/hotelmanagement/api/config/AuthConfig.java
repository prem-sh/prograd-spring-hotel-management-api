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
                .csrf()
                    .disable()

                .httpBasic()

                .and()
                .authorizeRequests()
                    .antMatchers("/help","/help/**").permitAll()
                    .antMatchers(HttpMethod.GET,"/rooms","/rooms/**").permitAll()

                    .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                    .antMatchers(HttpMethod.POST,"/rooms").hasAnyAuthority("ADMIN")

                    .antMatchers("/user","/user/**").hasAnyAuthority( "RECEPTIONIST")
                    .antMatchers("/bookings","/bookings/**").hasAnyAuthority( "RECEPTIONIST")
                    .anyRequest().authenticated()

                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
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
