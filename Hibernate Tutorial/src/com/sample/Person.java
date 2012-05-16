package com.sample;

public class Person {

	Long id;
	String name;
	String surname;
	String address;

	public Long getId() {

		return id;

	}

	private void setId(Long id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getSurname() {

		return surname;

	}

	public void setSurname(String surname) {

		this.surname = surname;

	}

	public String getAddress() {

		return address;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	@Override
	public String toString() {		
		return  "Person: \"" + getId() +"\", " + getName() +"\", " + getSurname() +"\", " +this.getAddress();
	}
	
	

}
