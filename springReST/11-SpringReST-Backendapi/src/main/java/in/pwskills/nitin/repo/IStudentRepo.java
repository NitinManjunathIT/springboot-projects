package in.pwskills.nitin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer>{

}
