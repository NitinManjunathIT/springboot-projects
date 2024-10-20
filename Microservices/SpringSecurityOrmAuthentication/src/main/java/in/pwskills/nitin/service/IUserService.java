package in.pwskills.nitin.service;

import java.util.Optional;

import in.pwskills.nitin.entity.User;

public interface IUserService {
	Integer saveUser(User user);
	Optional<User> getOneUser(Integer id);
}
