package in.pwskills.nitin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.model.User;
import in.pwskills.nitin.repo.IUserRepo;

@Service
public class UserService {
	
	@Autowired
	private IUserRepo repo;

	public Integer saveUser(User user) {
		return repo.save(user).getId();
	}

	@Cacheable(value = "users",key="#userId")
	public User getOneUser(Integer userId) {
		return repo.findById(userId).get();
	}

	
	@CachePut(value = "users",key="#userId")
	public void updateUser(Integer userId, User user) {
		User userDb = repo.findById(userId).get();
		userDb.setName(user.getName());
		userDb.setRole(user.getRole());
		repo.save(userDb);
	}

	@CacheEvict(value="users",allEntries = true)
	public void deleteUser(Integer userId) {
		repo.deleteById(userId);
	}

}
