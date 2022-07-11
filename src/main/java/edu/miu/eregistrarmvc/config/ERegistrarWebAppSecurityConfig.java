package edu.miu.eregistrarmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author bijayshrestha on 7/10/22
 * @project eRegistrar-mvc
 */
@Configuration
@EnableWebSecurity
public class ERegistrarWebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Autowired
    public ERegistrarWebAppSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//            .csrf().disable() // Note: Do NOT disable CSRF protection
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/static/**", "/css/**", "/images/**", "/js/**", "/eregistrar/public/**").permitAll()
                .antMatchers("/", "/eregistrar").permitAll()
                .antMatchers("/eregistrar/secured/services/admins/**").hasRole("ADMIN")
                .antMatchers("/eregistrar/secured/services/users/**").hasRole("STUDENT")
                .antMatchers("/eregistrar/secured/services/registrars/**").hasRole("REGISTRAR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/eregistrar/public/login")
                .defaultSuccessUrl("/eregistrar/public/home")
                .failureUrl("/eregistrar/public/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/eregistrar/public/logout"))
                .logoutUrl("/eregistrar/public/logout")
                .logoutSuccessUrl("/eregistrar/public/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
    }
}
