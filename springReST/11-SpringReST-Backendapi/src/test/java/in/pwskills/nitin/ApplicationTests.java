package in.pwskills.nitin;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//Creating the server and container environment
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)

//mocking the annotations(@RequestBody,@ResponseBody) needed  during Testing
@AutoConfigureMockMvc

//Loading the data from properties file(src/main/resources)
@TestPropertySource("classpath:application.properties")
public class ApplicationTests {

	@Autowired
	public MockMvc mockMvc;

	
	@Test
	@DisplayName("SAVING STUDENT OBJECT")
	@Order(1)
	public void createStudentTest() throws Exception {
		String body = "{\"stdName\":\"sachin\",\"stdGen\":\"Male\",\"stdCourse\":\"SBMS\",\"stdAddr\":\"Mumbai-#2/3\"}";

		// 1. Create a dummy request object[M.T,URL,C.T,C.B]
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("http://localhost:9999/v1/api/student/create").contentType(MediaType.APPLICATION_JSON)
				.content(body);

		// 2. Send the request and get the response
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. Retrieve the data from request object to peform testing
		MockHttpServletResponse response = result.getResponse();

		// 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		boolean isTrue = response.getContentAsString().contains("CREATED");
		if (!isTrue) {
			fail("STUDENT NOT CREATED!!!");
		}
	}

	@Test
	@DisplayName("GETTING STUDENT OBJECT")
	@Order(2)
	public void getStudentTest() throws Exception {
		
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.get("http://localhost:9999/v1/api/student/find/{id}",1);
			

		// 2. Send the request and get the response
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. Retrieve the data from request object to peform testing
		MockHttpServletResponse response = result.getResponse();

		// 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		String output = response.getContentAsString();
		System.out.println(output);
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}

}
