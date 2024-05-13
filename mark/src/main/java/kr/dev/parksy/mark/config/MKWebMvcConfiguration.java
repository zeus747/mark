package kr.dev.parksy.mark.config;



import java.util.List;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.dev.parksy.mark.interceptor.CheckHandlerInterceptor;
import kr.dev.parksy.mark.resolver.PageRequestMethodArgumentResolver;
import lombok.extern.slf4j.Slf4j;




//접근 IP 설정
@Slf4j
@Configuration(proxyBeanMethods = false)
public class MKWebMvcConfiguration implements WebMvcConfigurer, BeanFactoryAware{

	 @Autowired
	 private CheckHandlerInterceptor interceptor;
	 
	 private BeanFactory beanFactory;
	 
	// private final Logger logger = LogManager.getLogger(MKWebMvcConfiguration.class);
	 
	 
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory=beanFactory;
		
		
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns();
    }
	
	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(beanFactory.getBean(PageRequestMethodArgumentResolver.class));
    }

}
