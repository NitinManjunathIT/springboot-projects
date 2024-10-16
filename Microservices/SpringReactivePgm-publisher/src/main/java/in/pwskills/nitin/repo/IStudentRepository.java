package in.pwskills.nitin.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.pwskills.nitin.entity.Student;

public interface IStudentRepository extends ReactiveMongoRepository<Student, String> {

}
