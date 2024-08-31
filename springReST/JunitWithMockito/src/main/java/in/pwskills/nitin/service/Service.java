package in.pwskills.nitin.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import in.pwskills.nitin.repository.Repository;

public class Service {
	
	private Repository repo;

	//consturctor injection
	public Service(Repository repo) {
		this.repo = repo;
	}

	//Buisness logic method
	public List<String> getDataByLen() {
		try {
			return repo.getData().stream()
					.filter(d -> d.length() <= 5)
					.collect(Collectors.toList());
			
		} catch (SQLException e) {
			return Arrays.asList();
		}	
	}

}
