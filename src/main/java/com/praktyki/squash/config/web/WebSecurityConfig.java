package com.praktyki.squash.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity security) throws Exception
	{
		security
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/login").permitAll() //login page is always open
			.anyRequest().fullyAuthenticated()
			.and()
			.formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/rounds/view", true)
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails admin =
//				User.withDefaultPasswordEncoder()
//						.username("admin")
//						.password("admin")
//						.roles("USER", "ADMIN")
//						.build();
//
//		UserDetails user =
//				User.withDefaultPasswordEncoder()
//						.username("user")
//						.password("user")
//						.roles("USER")
//						.build();
//
//		return new InMemoryUserDetailsManager(admin, user);
//	}
}
