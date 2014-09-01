package com.wengs.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("steven").password("asdf1234")
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/secure/**").hasRole("USER")
				.antMatchers("/login.jsp").anonymous().antMatchers("/**")
				.permitAll().and().formLogin()
				.loginProcessingUrl("/j_spring_security_check")
				.loginPage("/login.jsp").failureUrl("/login.jsp?error=1")
				.defaultSuccessUrl("/secure/demo").and().logout()
				.logoutUrl("/j_spring_security_logout").and().csrf().disable();
	}
}
