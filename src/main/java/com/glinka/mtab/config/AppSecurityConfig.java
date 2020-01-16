package com.glinka.mtab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String DEF_USERS_BY_USERNAME_QUERY = "select login, password, enable " + "from user " + "where login = ?";
    public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY = "select u.login, r.role from user u, role r where u.login = ? and u.role_Id = r.id";
    public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY = "select g.id, g.group_name, ga.authority " +
            "from groups g, group_members gm, group_authorities ga " +
            "where gm.username = ? " + "and g.id = ga.group_id " + "and g.id = gm.group_id";

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(DEF_USERS_BY_USERNAME_QUERY)
                .authoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY);
//                .withDefaultSchema()
//                .withUser("user")
//                    .password(passwordEncoder().encode("pass"))
//                    .password("pass")
//                        .roles("USER").and()
//                .withUser("admin")
//                    .password(passwordEncoder().encode("pass"))
//                    .password("pass")
//                        .roles("ADMIN");
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/js/**").permitAll()
//
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/register.html").permitAll()
                .antMatchers("/**").authenticated()
                .antMatchers("/profile-1**", "/table**").hasAuthority("ROLE_USER")
                .antMatchers("/agency**", "/buses**", "/trips**", "/profile.html**", "/index**").hasAuthority("ROLE_ADMIN")
//
//                .antMatchers("/**").hasAnyAuthority()
//                .anyRequest()
//                .permitAll()
//                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login.html")
                    .loginProcessingUrl("/authenticate")
                    .permitAll()
                .and()
                .logout().permitAll();


        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
