package org.springframework.learn.cycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jing Tao
 * @date 2022/9/6 10:31
 */
public class MainTest {

	@Test
	public void shouldInvokeAwareMethodsInImportBeanDefinitionRegistrar() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		A bean = context.getBean(A.class);
		B b = context.getBean(B.class);
		bean.say();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		A bean = context.getBean(A.class);
		bean.say();
	}
}
