package org.springframework.learn.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Jing Tao
 * @date 2022/9/14 15:04
 */
@Component
@ComponentScan
//支持用户自定义bean的生命周期，不需要遵循BeanFactory的bean的生命周期
public class FactoryBeanDemo implements FactoryBean<A> {

	@Override
	public A getObject() throws Exception {
		return new A();
	}

	@Override
	public Class<?> getObjectType() {
		return A.class;
	}
}
