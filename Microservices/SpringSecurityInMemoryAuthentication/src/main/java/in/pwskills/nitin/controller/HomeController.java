package in.pwskills.nitin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//requestMatcher("/home","/").permitAll()
	@GetMapping({"/home","/"})
	public String showHome() {
		return "home";
	}
	
	//requestMatcher("/hello").authenticated()
	@GetMapping("/hello")
	public String showHello() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}	
}
