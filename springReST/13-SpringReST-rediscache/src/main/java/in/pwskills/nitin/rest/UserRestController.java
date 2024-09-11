package in.pwskills.nitin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.model.User;
import in.pwskills.nitin.service.UserService;

@RestController
@RequestMapping("/v1/api/user")
public class UserRestController {

	@Autowired
	private UserService service;
	
	
	/*
	 * METHOD : POST
	 * PATH   : /create
	 * INPUT  : User object
	 * OUTPUT : String
	 *  CACHING IS NOT NEEDED AS IT IS "SAVE" OPERATION
	 */

	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		Integer id = service.saveUser(user);
		return "User '"+id+"' created!";
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /find
	 * INPUT  : path variable -> id
	 * OUTPUT : User
	 *  CACHING IS  NEEDED AS IT IS "GET" OPERATION ON 1-object
	 */
	@GetMapping("/find/{id}")
	public User findOneUser(@PathVariable Integer id) {
		return service.getOneUser(id);
	}
	
	/*
	 * METHOD : DELETE
	 * PATH   : /remove
	 * INPUT  : path variable -> id
	 * OUTPUT : String
	 *  CACHING IS NEEDED AS IT IS "DELETE" OPERATION ON ONE OBJECT
	 */
	@DeleteMapping("/remove/{id}")
	public String deleteUser(@PathVariable Integer id) {
		service.deleteUser(id);
		return "User Deleted!";
	}
	
	/*
	 * METHOD : PUT
	 * PATH   : /modify
	 * INPUT  : User object
	 * OUTPUT : String
	 *  CACHING IS NEEDED AS IT IS "UPDATE" OPERATION ON ONE OBJECT
	 */
	@PutMapping("/modify")
	public String updateUser(@RequestBody User user) {
		service.updateUser(user.getId(), user);
		return "User Updated!";
	}

	
}
