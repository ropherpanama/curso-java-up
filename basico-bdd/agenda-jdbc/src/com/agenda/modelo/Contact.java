package com.agenda.modelo;

/**
 * Clase que representa a un contacto de nuestra agenda
 * @author ropherpanama
 *
 */
public class Contact extends Person {

	private String phoneNumber;
	private String email;

	public Contact(int id, String name, String phoneNumber, String email) {
		super(id, name);
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
}
