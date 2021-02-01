package com.example.SpringSecurity;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserService userService;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        /*http.authorizeRequests()
	                    .antMatchers(
	                            "/registration**",
	                            "/js/**",
	                            "/css/**",
	                            "/img/**",
	                            "/webjars/**").permitAll()
	                    .anyRequest().authenticated()
	                .and()
	                    .formLogin()
	                        .loginPage("/login")
	                            .permitAll()
	                .and()
	                    .logout()
	                        .invalidateHttpSession(true)
	                        .clearAuthentication(true)
	                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                        .logoutSuccessUrl("/login?logout")
	                .permitAll();*/
		 http.csrf().disable().authorizeRequests().antMatchers("/listIncident").permitAll().antMatchers("/AddIncident").permitAll().
		 antMatchers("/onGetAllPhotoBy").permitAll().antMatchers("/GetUserByEmail").permitAll().antMatchers("/AddPhoto").permitAll().
		 antMatchers("/GetPhoto").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
			.authenticated().and()
			// .formLogin().and()
			.httpBasic();
	    }

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	        auth.setUserDetailsService(userService);
	        auth.setPasswordEncoder(passwordEncoder());
	        return auth;
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());}
    

	
}
