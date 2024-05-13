package kr.dev.parksy.mark.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties(prefix = "mark.web.security")//=> 바인딩
@Getter
@Setter
@ToString
public class MAWebSecurityProperties {
	
	private String loginPage;
	private String loginProcessingUrl;
	private String loginSuccessUrl;
	
	/*private String loginFailureUrl;
	private String logoutUrl;
	private String logoutSuccessUrl;
	private String usernameParameter;
	private String passwordParameter;*/

}
