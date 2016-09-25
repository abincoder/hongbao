package com.yubin.hongbao.common;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * 扫描spring注解bean
 * @author wyb
 */
public class AnnotationUtil {
	public static Object getBean(String beanName){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(); 
		//扫描范围
		ctx.scan("com.yubin.hongbao.*");  
		ctx.refresh(); 
		Object service = ctx.getBean(beanName);//此处也可以使用ctx.getBean("testServiceImpl") 
		return service;
	}
}
