package com.ncsoft.platform.report.domain;

public class Sample {

	private Integer mno;
	private String firstName;
	private String lastName;
	
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Sample [mno=" + mno + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}	
}
