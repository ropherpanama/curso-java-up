package com.curso.agenda.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clase que representa a un contacto de nuestra agenda
 * 
 * @author ropherpanama
 *
 */
@Entity
@Table(name = "contacts")
public class Contact extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "phone")
	private String phoneNumber;
	@Column
	private String email;

	public Contact() {
	}

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
