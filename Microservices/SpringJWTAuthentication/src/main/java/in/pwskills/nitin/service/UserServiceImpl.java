package in.pwskills.nitin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.entity.User;
import in.pwskills.nitin.repo.IUserRepository;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Autowired
	private IUserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Integer saveUser(User user) {
		// saving the user object
		String pwd = encoder.encode(user.getPassword());
		user.setPassword(pwd);
		return repo.save(user).getId();
	}

	@Override
	public User findByUsername(String username) {
		//while login check whether the user is found in database or not
		Optional<User> opt = repo.findByUsername(username);
		if(opt.isPresent())
			return opt.get();
		return null;//Security coding we throw Exception(UserNotFoundException)
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = findByUsername(username);
		if(null == user)
			throw new UsernameNotFoundException(username + " not exist");
		
		List<GrantedAuthority> list = 
				user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(
				username, user.getPassword(), list);
	}


}
