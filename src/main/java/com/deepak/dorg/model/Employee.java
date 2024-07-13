//package com.deepak.dorg.model;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity
//public class Employee {
//	@Id
//    private String email;
//	
//    private String name;
//    
//    private String designation;
//    
//    private double ctc;
//    
//    public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDesignation() {
//		return designation;
//	}
//	public void setDesignation(String designation) {
//		this.designation = designation;
//	}
//	public double getCtc() {
//		return ctc;
//	}
//	public void setCtc(double ctc) {
//		this.ctc = ctc;
//	}
//}




package com.deepak.dorg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String designation;
    private double ctc;
    private String email;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getCtc() {
		return ctc;
	}
	public void setCtc(double ctc) {
		this.ctc = ctc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
