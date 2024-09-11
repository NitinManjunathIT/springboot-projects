package in.pwskills.nitin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.model.User;

public interface IUserRepo extends JpaRepository<User, Integer> {

}
