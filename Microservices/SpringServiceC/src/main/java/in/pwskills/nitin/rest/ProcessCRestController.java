package in.pwskills.nitin.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/C")
public class ProcessCRestController {
	private static final Logger log = LoggerFactory.getLogger(ProcessCRestController.class);

	@GetMapping("/showC")
	public String showMsg() {
		log.info("We are at C Service...");
		return "FROM C...";
	}

}
