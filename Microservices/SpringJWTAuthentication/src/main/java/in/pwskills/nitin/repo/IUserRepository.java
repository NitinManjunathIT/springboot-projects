package in.pwskills.nitin.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}


