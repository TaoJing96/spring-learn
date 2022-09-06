package org.springframework.learn.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jing Tao
 * @date 2022/9/6 10:31
 */
@Component
public class B {

	@Autowired
	private A a;
}
