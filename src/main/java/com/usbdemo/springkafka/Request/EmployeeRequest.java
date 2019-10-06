package com.usbdemo.springkafka.Request;

public class EmployeeRequest {
	
	private String ename ;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getGreeting() {
		return greeting;
	}
	@Override
	public String toString() {
		return "EmployeeRequest [ename=" + ename + ", greeting=" + greeting + "]";
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	private String greeting ;

}
