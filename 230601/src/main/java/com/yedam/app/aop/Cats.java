package com.yedam.app.aop;


public class Cats {
	
	private String name;
	private int age;
	private String color;
	
	public void printInfo() {
		System.out.println(this.name + ", " + this.age + ", " + this.color);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}
