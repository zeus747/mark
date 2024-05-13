package kr.dev.parksy.mark.authentication;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
public class MKAuthenticationController {
	
	/*private OSMProperties properties;
	
	public MKAuthenticationController(OSMProperties properties)
	{		
		this.properties=properties;
	}*/
	

	
	@GetMapping("/login")
	 public String login() {
		log.debug("#MKAuthenticationController  ##login");
	        return "authentication/login";
	   }
	

	
	@Secured("ROLE_ADMIN")
	@GetMapping("/")
	 public String app() {
		
		log.debug("#MKAuthenticationController  ##app");
	        return "main";
	   }


}
