package kr.dev.parksy.mark.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;

public interface MarkAware extends Aware{

	void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
