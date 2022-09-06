package org.springframework.learn.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jing Tao
 * @date 2022/9/6 10:24
 */
@Component
public class A {

	@Autowired
	private B b;

	public void say() {
		System.out.println("adasdas...");
	}
}
