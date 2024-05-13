package kr.dev.parksy.mark.secturity;

import java.lang.annotation.Annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

import kr.dev.parksy.mark.annotation.MarkAware;
import kr.dev.parksy.mark.properties.MAWebSecurityProperties;
import lombok.extern.slf4j.Slf4j;



//로그인  security config 


@Slf4j
@Configuration(proxyBeanMethods = false) //-> 해당 클래스를 빈으로 수동 등록

public class MKWebSecurityConfiguration implements BeanFactoryAware{

	private MAWebSecurityProperties mASecurityProperties;
	
	
	
	
	MKWebSecurityConfiguration(MAWebSecurityProperties mASecurityProperties)
	{
		
		this.mASecurityProperties=mASecurityProperties;
		
		log.debug("MKWebSecurityConfiguration = {}",mASecurityProperties);
		
		
	}
	
	
	@Bean
	protected SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
			
		((HttpSecurity) ((HttpSecurity) http.anonymous().disable()).csrf().disable()).exceptionHandling();
		
	//	http.formLogin(f->f.failureForwardUrl(null));
		
		 http.csrf().disable();
	        http.authorizeHttpRequests()
	                .requestMatchers("/user/**").authenticated() //인증만 되면 들어갈 수 있는 주소
	                .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
	                //hasAnyRole : 역할중 하나 가지고 있어야 허용
	                .requestMatchers("/admin/**").hasRole("ADMIN")// 이 역할 필요
	                .anyRequest().permitAll() //모두 허용
	                .and() //return HttpSecurity
	                .formLogin() //return FormLoginConfigurer <HttpSecurity>
	                //.usernameParameter("username") 기본값은 username임
	                .loginPage("/login") //로그인 페이지 지정(Controller)
	               // .loginProcessingUrl("/login")
	                //이 Url이 오면 가로채서 UserDetailsService의 loadUserByname 메서드로 연결
	                .defaultSuccessUrl("/");
	                //로그인 성공시 url
		
		/*http.formLogin()
	    .loginPage("/login")				// 사용자 정의 로그인 페이지
	    .defaultSuccessUrl("/home")				// 로그인 성공 후 이동 페이지
	    .failureUrl("/login.html?error=true")		// 로그인 실패 후 이동 페이지
	    .usernameParameter("username")			// 아이디 파라미터명 설정
	    .passwordParameter("password")			// 패스워드 파라미터명 설정
	    .loginProcessingUrl("/login");*/
		
		/*http.formLogin()
	    .loginPage("/login.html")				// 사용자 정의 로그인 페이지
	    .defaultSuccessUrl("/home")				// 로그인 성공 후 이동 페이지
	    .failureUrl("/login.html?error=true")		// 로그인 실패 후 이동 페이지
	    .usernameParameter("username")			// 아이디 파라미터명 설정
	    .passwordParameter("password")			// 패스워드 파라미터명 설정
	    .loginProcessingUrl("/login")			// 로그인 Form Action Url
	    .successHandler(loginSuccessHandler())		// 로그인 성공 후 핸들러
	    .failureHandler(loginFailureHandler())		// 로그인 실패 후 핸들러
	    */
	
	

		
		log.debug("# MKWebSecurityConfiguration ##defaultSecurityFilterChain http= {}",http);
		return http.build();
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		log.debug("#MKWebSecurityConfiguration ##setBeanFactory  ###beanFactory={}",beanFactory);
		
		DefaultListableBeanFactory d = (DefaultListableBeanFactory) beanFactory;
		
		
	/*	for(String s: d.getBeanDefinitionNames())
		{
			log.debug("#MKWebSecurityConfiguration ##setBeanFactory  ###getBeanDefinitionNames={}",s);
		}
		*/
		
		String[] beanNames = d.getBeanNamesForType(CorsConfigurationSource.class);
		for(String s: beanNames)
		{
			log.debug("#MKWebSecurityConfiguration ##setBeanFactory  ###getBeanDefinitionNames={}",s);
		}
		
	}


	

}
