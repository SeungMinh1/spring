package com.yedam.spring.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	
	@Bean
	public Chef chef() {
		return new Chef();
	}
	
	@Bean
	public Resturant resturant(Chef chef) {
		Resturant res = new Resturant();
		res.setChef(chef);
		return res;
	}
}
