package in.pwskills.nitin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	AuthenticationManager authenticationManager(
			AuthenticationConfiguration configuration
			) throws Exception {
		return configuration.getAuthenticationManager();
		
	}
	
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		
		//Perform Authentication using BCryptPasswordEncoder for the given input by loading the data from Database 
		System.out.println("SecurityConfig.authenticationProvider() for authentication...");
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		authenticationProvider.setUserDetailsService(userDetailsService);
		return authenticationProvider;
	}
	

	//1. Authorization
	@Bean
	SecurityFilterChain configurePath(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				request-> request.requestMatchers("/home","/").permitAll()
								 .requestMatchers("/admin").hasAuthority("ADMIN")
								 .requestMatchers("/customer").hasAuthority("CUSTOMER")
								 .requestMatchers("/user/**").permitAll()
								 .requestMatchers("/hello").authenticated()
								 .anyRequest().permitAll()
				
				).formLogin(form->form.loginPage("/login").permitAll())
				 .logout(logout->logout.permitAll()).build();
	}
	

	
	
	
	
	
}
