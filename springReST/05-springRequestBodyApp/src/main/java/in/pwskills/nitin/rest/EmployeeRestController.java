package in.pwskills.nitin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Employee;
/*
 *  XML INPUT 
 * <Employee>
    <empId>10</empId>
    <empName>sachin</empName>
    <empSal>25000.0</empSal>
    <address>
        <hno>25/1</hno>
        <loc>bandra</loc>
    </address>
    <friendNames>
        <friendNames>saurav</friendNames>
        <friendNames>dravid</friendNames>
        <friendNames>sehwagh</friendNames>
    </friendNames>
    <accountDetails>
        <hdfc>2345</hdfc>
        <canara>1234</canara>
    </accountDetails>
	</Employee>
	
	b. JSON INPUT
	{
	"Employee": {
		"empId": "10",
		"empName": "sachin",
		"empSal": "25000.0",
		"address": {
			"hno": "25/1",
			"loc": "bandra"
		},
		"friendNames": {
			"friendNames": [
				"saurav",
				"dravid",
				"sehwagh"
			]
		},
		"accountDetails": {
			"hdfc": "2345",
			"canara": "1234"
		}
	}
}
 * 
 * 
 * 
 */

@RestController
@RequestMapping("/v1/api/employee")
public class EmployeeRestController {

	
	/*
	 *  R.T    : ResponseEntity<String>
	 *  PATH   : /save
	 *  INPUT  : Employee @RequestBody
	 *  METHOD : POST  
	 * 
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveObject(
			@RequestBody Employee employee) {

		String body = employee.toString();
		//CREATED : resource got created at the producer side, to indicate to the consumer e
		return new ResponseEntity<>(body,HttpStatus.CREATED);
	}
	
}
