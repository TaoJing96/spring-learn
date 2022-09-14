package org.springframework.learn.factorybean;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jing Tao
 * @date 2022/9/6 10:31
 */
public class MainTest {

	@Test
	public void shouldInvokeAwareMethodsInImportBeanDefinitionRegistrar() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(FactoryBeanDemo.class);
		A a = ctx.getBean(A.class);
		a.test();
	}
}
