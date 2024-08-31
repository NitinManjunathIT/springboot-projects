package in.pwskills.nitin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import in.pwskills.nitin.repository.Repository;
import in.pwskills.nitin.service.Service;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	
	@Mock
	Repository respository;
	
	@InjectMocks
	Service service;
	

	@Test
	public void getDataByLenTest() {
		//Give mocking implementation when the code is not ready
		try {
			when(respository.getData()).thenReturn(
					Arrays.asList("sachin","saurav","dravid","dhoni","kohli","yuvi"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Test your code
		int expectedSize =3;
		List<String> actual = service.getDataByLen();
		
		//checking the comparison is made on the actual object
		assertNotNull(actual);
		
		
		int actualSize = service.getDataByLen().size();
		assertEquals(expectedSize, actualSize);
		
	}
	
	@Test
	public void getDataThrowException() {
		
		try {
			when(respository.getData()).thenThrow(new SQLException("SQLEXCEPTION OCCURED"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> actual = service.getDataByLen();
		//assertNotNull(actual);
		assertEquals(0,actual.size());
	}
}
