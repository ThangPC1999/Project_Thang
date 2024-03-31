package com.am.woman;

public class NguyenKyDuyen {
	// private
	// default
	// protected
	// public
	
	
	// Variable (Global)
	
	// private
	private String name = "Thanh Hang";
	private String address = "28 Bis Mac Dinh Chi";
	
	// default
	String dateOfBirth = "01/01/1999";
	
	String getWomanDataOfBirth() {
		return this.dateOfBirth;
	}
	
	// protected
	protected String womanID="021982867112";
	
	protected String getWomanID() {
		return this.womanID;
	}
	
	//public
	public String sex="Woman";
	
	public String getSex() {
		return this.sex;
	}
	
	// Mothod
	
	private String getWomenName() {
		return name;
	}
	private String getAddress() {
		return address;
	}
	private void setWonmenName(String name) {
		// local variable
		this.name = name;
	}
	
	// public variable
	public String womanCarName = "Lambo";
	
	// private method
	private String getWomanCarName() {
		return this.womanCarName;
	}
	
	// public variable
	private String womanMotorName = "Sirus";
	
	// private method
	public String getWomanMotorName() {
		return this.womanMotorName;
	}
}
