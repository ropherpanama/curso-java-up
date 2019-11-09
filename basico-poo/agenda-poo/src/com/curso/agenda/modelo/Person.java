package com.curso.agenda.modelo;

/**
 * Clase padre de todos los contactos
 * @author ropherpanama
 */
public class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
