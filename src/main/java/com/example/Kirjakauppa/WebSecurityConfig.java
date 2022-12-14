package com.example.Kirjakauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;




@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/css/**").permitAll()
		.and()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/booklist")
			.permitAll()
			.and()
		.logout()
			.permitAll();
		
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
	
	
	/**
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		Collection<UserDetails> users = new ArrayList<UserDetails>();
		UserDetails user = User.withDefaultPasswordEncoder()
					.username("user")
					.password("user")
					.roles("USER")
					.build();
		
		users.add(user);
		
		UserDetails user1 = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("USER", "ADMIN")
				.build();
		
		users.add(user1);
		
		return new InMemoryUserDetailsManager(users);
	}
	
	**/

}
