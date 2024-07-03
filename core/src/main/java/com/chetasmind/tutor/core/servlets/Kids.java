package com.chetasmind.tutor.core.servlets;

public class Kids {
	
	private String name;
	private String email;
	private String dob;
	private String gender;
	private String grade;
	
	public Kids(String name, String email, String dob, String gender, String grade) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}

	public String getGrade() {
		return grade;
	}
	
	
	
	

}
