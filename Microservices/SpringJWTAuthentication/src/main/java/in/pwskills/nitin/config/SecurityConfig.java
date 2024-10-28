package in.pwskills.nitin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import in.pwskills.nitin.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private SecurityFilter securityFilter;
	
	@Bean
	AuthenticationManager authenticationManager(
				AuthenticationConfiguration configuration
			) throws Exception 
	{
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	 DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

	
    @Bean
    SecurityFilterChain configureAuth(HttpSecurity http) throws Exception {
	return 
			
    	http
        // Disable CSRF as we're working with stateless JWT tokens
        .csrf(AbstractHttpConfigurer::disable)
        
        // Configure endpoint access
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/user/save", "/user/login").permitAll() // Public endpoints
            .anyRequest().authenticated() // Secure all other endpoints
        )

        // Exception handling configuration
        .exceptionHandling(exception -> exception
            .authenticationEntryPoint(authenticationEntryPoint)
        )
        
        //Stateless session management (for JWT-based authentication)
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        
        // Add custom security filter before UsernamePasswordAuthenticationFilter
        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
        
        .build();
	
	
		
	}	

	
	
	
}
