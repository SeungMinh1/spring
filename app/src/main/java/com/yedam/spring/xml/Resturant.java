package com.yedam.spring.xml;

public class Resturant {
	private Chef chef;
	
//	Restaurant(Chef chef){
//		this.chef = chef;
//	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public void run() {
		chef.cooking();
	}
	
}
