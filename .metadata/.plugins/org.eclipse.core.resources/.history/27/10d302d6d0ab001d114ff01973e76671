package com.tek.java.day6.implement;

public class Square extends Shape implements AreaCalculation {

	private int length;
	private int height;
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	// this is the implmenetation of the AreaCalculation interface
	@Override
	public double calculateArea() {
		int area = length * height;
		return area;
	}
	
	@Override
	public String shapeName() {
		return "Squre";
	}

}
