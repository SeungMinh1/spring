package com.yedam.spring.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Resturant res = (Resturant)ctx.getBean(Resturant.class);
		res.run();
	}

}
