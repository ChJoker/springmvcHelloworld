package com.hello.domain;

import java.util.List;

public class Person {
	private String name;
	private List<Son> sons;
	
	public Person () {
		
	}
	
	public Person(String name,List<Son> sons) {
		this.name=name;
		this.sons=sons;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSons(List<Son> sons) {
		this.sons=sons;
	}
	
	public List<Son> getSons() {
		return this.sons;
	}
}
