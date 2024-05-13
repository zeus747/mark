package kr.dev.parksy.mark.controller;



import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.dev.parksy.mark.config.MKWebMvcConfiguration;
import kr.dev.parksy.mark.module.abstractModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AppController extends abstractModule{
	
	/// private final Logger logger = LogManager.getLogger(AppController.class);
	 
	 @GetMapping("/shop")
	 public String process() {
		 log.info("==========================================>");
		 
		// logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	        return "main";
	   }

	@Override
	public void setMessageSource(MessageSource messageSource) {
		
		
		
		System.out.println("------------------------AppController="+messageSource);
		
	}

}
