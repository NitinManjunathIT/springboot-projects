package in.pwskills.nitin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	//1. Authorization
	@Bean
	SecurityFilterChain configurePath(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				request-> request.requestMatchers("/home","/").permitAll()
								 .requestMatchers("/admin").hasAuthority("ADMIN")
								 .requestMatchers("/customer").hasAuthority("CUSTOMER")
								 .requestMatchers("/hello").authenticated()
								 .anyRequest().permitAll()
				
				).formLogin(form->form.loginPage("/login").permitAll())
				 .logout(logout->logout.permitAll()).build();
	}
	

	//2. Authentication
	@Bean
	UserDetailsService userDetailService(DataSource dataSource)
	{
		System.out.println("ADDED DATA TO DATABASE BY SPRINGSECURITY...");
		//JDBC Storage and Authentication using "PreDefined Filter"
		UserDetails user1 = User.withUsername("sachin")
				.password(
							passwordEncoder.encode("tendulkar")
						).authorities("ADMIN")
				.build();
		
		UserDetails user2 = User.withUsername("virat")
				.password(
					"$2a$12$AKqYWiU0zoKdv0pYl9P7jeva2tl4ERN7WANsn.sR81qyZIng2avdu"
				).authorities("CUSTOMER")
				.build();
		
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		userDetailsManager.createUser(user1);
		userDetailsManager.createUser(user2);
	
		return userDetailsManager;
	}
	
	
	
	
}
