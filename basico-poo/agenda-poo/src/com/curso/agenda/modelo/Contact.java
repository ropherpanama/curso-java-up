package com.curso.agenda.modelo;

/**
 * Clase que representa a un contacto de nuestra agenda
 * @author ropherpanama
 *
 */
public class Contact extends Person {

	private String phoneNumber;
	private String email;

	public Contact(String name, String phoneNumber, String email) {
		super(name);
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Contact [phoneNumber=%s, email=%s, name=%s]", phoneNumber, email, getName());
	}
	
	
}
