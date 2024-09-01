package in.pwskills.nitin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.model.Book;

public interface IBookRepo extends JpaRepository<Book, Integer> {

}
