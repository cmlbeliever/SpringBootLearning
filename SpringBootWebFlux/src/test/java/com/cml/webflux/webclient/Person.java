package com.cml.webflux.webclient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Person {

	private String name;


	// No-arg constructor for XML
	public Person() {
	}

	@JsonCreator
	public Person(@JsonProperty("name") String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null || getClass() != other.getClass()) return false;
		Person person = (Person) other;
		return getName().equals(person.getName());
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public String toString() {
		return "Person[name='" + name + "']";
	}

}