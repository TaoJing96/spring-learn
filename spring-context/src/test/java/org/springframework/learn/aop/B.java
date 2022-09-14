package org.springframework.learn.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Jing Tao
 * @date 2022/9/6 10:31
 */
@Component
@Configuration
public class B {

	@Bean
	public String buildStringBean() {
		return "aa";
	}

	public void test() {
		System.out.println("test");
	}
}
