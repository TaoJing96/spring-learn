package org.springframework.learn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author Jing Tao
 * @date 2022/9/6 10:31
 */
@ComponentScan
@Aspect
@Component
public class AopConfig {

	@Pointcut("execution(public void org.springframework.learn.aop.B.test())")
	public void pointCut() {}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoin) {
		System.out.println("go go go MyAspectJ process!!!");
		Object obj = null;
		try {
			obj = joinPoin.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		return obj;
	}
}
