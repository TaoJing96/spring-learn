package org.springframework.jdbc.learn.tx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jing Tao
 * @date 2022/9/14 18:20
 */
public class TestMain {

	public static void main(String[] args) {
		// 获取容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		// 容器中获取数据库操作组件
		PersonService personService = (PersonService) context.getBean("personService");
//		personService.add();
		personService.addPerson();
	}
}
