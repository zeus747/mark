package kr.dev.parksy.mark.config;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


import kr.dev.parksy.mark.annotation.MarkAware;
import kr.dev.parksy.mark.properties.MAWebSecurityProperties;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@Configuration(proxyBeanMethods = false)  

public class MKSecurityAutoConfiguration  implements BeanFactoryAware{
	
	
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		
	log.debug("#MKSecurityAutoConfiguration  ##setBeanFactory  ###beanFactory={}",beanFactory);
		
	}
	
	
	
	

}
