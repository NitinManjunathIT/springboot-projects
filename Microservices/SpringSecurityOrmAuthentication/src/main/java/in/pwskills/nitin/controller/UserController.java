package in.pwskills.nitin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.pwskills.nitin.entity.User;
import in.pwskills.nitin.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	/*
	 * METHOD : GET
	 * PATH   : /register
	 * INPUT  : 
	 * OUTPUT : String(UserRegister)
	 */
	
	@GetMapping("/register")
	public String showReg() {
		return "UserRegister";
	}

	/*
	 * METHOD : POST
	 * PATH   : /save
	 * INPUT  : User (ModelAttribute)
	 * OUTPUT : String(Model)
	 */
	@PostMapping("/save")
	public String saveUser(
			
		@ModelAttribute	User user,
			Model model
			) {
		Integer id = userService.saveUser(user);
		String message = "User '"+id+"' created!";
		model.addAttribute("message",message);
		
		return "UserRegister";
	}
	
	
	
}
