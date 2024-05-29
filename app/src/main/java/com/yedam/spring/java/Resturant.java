package com.yedam.spring.java;

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
