package org.springframework.learn.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jing Tao
 * @date 2022/9/6 10:31
 */
public class MainTest {

	@Test
	public void shouldInvokeAwareMethodsInImportBeanDefinitionRegistrar() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("org/springframework/learn/aop/application.xml");
		B b = ctx.getBean(B.class);
		b.test();
	}
}
