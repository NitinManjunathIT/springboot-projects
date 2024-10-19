package in.pwskills.nitin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//1. Authorization
	@Bean
	SecurityFilterChain configurePath(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				request-> request.requestMatchers("/home","/").permitAll()
								 .requestMatchers("/hello").authenticated()
								 .anyRequest().permitAll()
				
				).formLogin(form->form.loginPage("/login").permitAll())
				 .logout(logout->logout.permitAll()).build();
	}
	

	//2. Authentication
	@SuppressWarnings("deprecation")
	@Bean
	UserDetailsService userDetailService()
	{
		
		System.out.println("SecurityConfig.userDetailService()::INMEMORY DATA...");
		
		//Creating a User Object
		UserDetails user1 = User.withDefaultPasswordEncoder()
				.username("sachin")
				.password("tendulkar")
				.build();
		
		UserDetails user2 = User.withDefaultPasswordEncoder()
						.username("virat")
						.password("kohli")
						.build();
		
		//Storing it in RAM(volatile memory)
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	
	
	
}
