package com.yedam.spring.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Resturant {
	private Chef chef;
	
//	Restaurant(Chef chef){
//		this.chef = chef;
//	}
	@Autowired //생성자나 setter
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public void run() {
		chef.cooking();
	}
	
}
