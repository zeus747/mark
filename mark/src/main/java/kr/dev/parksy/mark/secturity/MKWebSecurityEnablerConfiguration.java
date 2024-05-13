package kr.dev.parksy.mark.secturity;

import java.lang.annotation.Annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import kr.dev.parksy.mark.annotation.MarkAware;
import kr.dev.parksy.mark.properties.MAWebSecurityProperties;
import lombok.extern.slf4j.Slf4j;



//로그인  security config 


@Slf4j
@Configuration(proxyBeanMethods = false) //-> 해당 클래스를 빈으로 수동 등록
@EnableConfigurationProperties({MAWebSecurityProperties.class})// => 실제 프로퍼티를 주입함 / 한번주입하면 여러 빈에서 사용 가능
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)//@Secured를 활성화 해줌 -> 로그인 안되어 있으면 login으로 자종 redirect 해줌
@EnableWebSecurity //-> security로 사용

public class MKWebSecurityEnablerConfiguration {}
