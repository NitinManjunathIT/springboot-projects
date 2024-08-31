package in.pwskills.nitin.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.exception.ErrorResponse;
import in.pwskills.nitin.exception.StudentNotFoundException;
import in.pwskills.nitin.model.Student;
import in.pwskills.nitin.service.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {
	
	@Autowired
	private IStudentService service;
	
	
	/*
	 * METHOD : POST
	 * PATH   : /create
	 * INPUT  : Student object (@RequestBody)
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	@Operation(summary = "Save the Student Object")
	@ApiResponses(
			value = { 
				  @ApiResponse(
						  responseCode = "201", description = "CREATED A RESOURCE AT PROVIDER", 
						  content = { 
								  		@Content(mediaType = "text/plain") 
							    	}
					    ),
				  @ApiResponse(responseCode = "400", description = "BAD REQUEST", 
						content = 
				  			{
						  		@Content(mediaType ="application/json")
				  			}
				) 
			  }
		)
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(
				@RequestBody @Valid Student student
			)
	{
		Integer id = service.saveStudent(student);
		
		//body = Student '1' created
		String body = "STUDENT '"+id+"' CREATED";
		
		//CREATED : 201
		return new ResponseEntity<String>(body, HttpStatus.CREATED);
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /all
	 * INPUT  : no input
	 * R.T    : ResponseEntity<List<Student>>
	 * 
	 */
	@Operation(summary = "Find all Student")
	@ApiResponses(
			value = { 
				  @ApiResponse(
						  responseCode = "200", description = "SUCCESS", 
						  content = { 
								  	@Content(mediaType = "application/json" , 
								  			array = 
								  			@ArraySchema(
								  						schema = @Schema(implementation = Student.class)
								  					)
								  			)
								  	
							    }
					    )
			   }
			)
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		
		List<Student> body = service.getAllStudents();
			
		return ResponseEntity.ok(body);
	}


	/*
	 * METHOD : GET
	 * PATH   : /find/{id}
	 * INPUT  : id ->  @PathVariable
	 * R.T    : ResponseEntity<Student>
	 * 
	 */
	@Operation(summary = "Find a Student by its id")
	@ApiResponses(
			value = { 
				  @ApiResponse(
						  responseCode = "200", description = "SUCCESS", 
						  content = { 
								  @Content(mediaType = "application/json" , schema = @Schema(implementation =Student.class))
							    }
					    ),
				  @ApiResponse(responseCode = "404", description = "Student not found", 
						content = 
				  			{
						  		@Content(mediaType ="application/json", schema = @Schema(implementation =ErrorResponse.class))
				  			}
				) 
			   }
			)
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getOneStudent(
				@PathVariable Integer id
			) 
	{
		ResponseEntity<Student> response = null;
		try {
				Student s = service.getOneStudent(id);
				response = ResponseEntity.ok(s);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}

	/*
	 * METHOD : DELETE
	 * PATH   : /remove/{id}
	 * INPUT  : id -> @PathVariable
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	@Operation(summary = "Delete a Student by its id")
	@ApiResponses(
			value = { 
				  @ApiResponse(
						  responseCode = "200", description = "SUCCESS", 
						  content = { 
								  @Content(mediaType = "plain/text") 
							    }
					    ),
				  @ApiResponse(responseCode = "404", description = "Student not found", 
						content = 
				  			{
						  		@Content(mediaType ="application/json", schema = @Schema(implementation =ErrorResponse.class))
				  			}
				) 
			   }
			)
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(
			@PathVariable Integer id
		) 
	{
			ResponseEntity<String> response = null;
			try {
				service.deleteStudent(id);
				response = ResponseEntity.ok("STUDENT '"+id+"' REMOVED");
			} catch (StudentNotFoundException e) {
				e.printStackTrace();
				throw e;
			}
			return response;
	}
	
	/*
	 * METHOD : PUT
	 * PATH   : /modify
	 * INPUT  : Student -> @RequestBody
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	@Operation(summary = "Update Student object")
	@ApiResponses(
			value = { 
				  @ApiResponse(
						  responseCode = "200", description = "SUCCESS", 
						  content = { 
								  @Content(mediaType = "plain/text") 
							    }
					    ),
				  @ApiResponse(responseCode = "404", description = "Student not found", 
						content = 
				  			{
						  		@Content(mediaType ="application/json", schema = @Schema(implementation =ErrorResponse.class))
				  			}
				) 
			   }
			)
	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(
				@RequestBody @Valid Student student
		)
	{
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(student);
			response = ResponseEntity.ok("STUDENT '"+student.getStdId()+"' UPDATED");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
}
