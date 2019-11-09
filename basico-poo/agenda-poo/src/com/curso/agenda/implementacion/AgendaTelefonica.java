package com.curso.agenda.implementacion;

import java.util.ArrayList;
import java.util.List;

import com.curso.agenda.interfaces.Agenda;
import com.curso.agenda.modelo.Contact;

public class AgendaTelefonica implements Agenda {

	private List<Contact> contacts = new ArrayList<Contact>();

	@Override
	public boolean addContact(Contact c) {
		return contacts.add(c);
	}

	@Override
	public void listContacts() {
		System.out.println("\n==================== Contactos ====================");

		if (contacts.isEmpty())
			System.out.println("No se han agregado contactos.");
		else {
			int i = 1;

			for (Contact c : contacts) {
				System.out.println("(" + i + ")");
				System.out.println("Nombre: " + c.getName());
				System.out.println("Telefono: " + c.getPhoneNumber());
				System.out.println("Email: " + c.getEmail());
				System.out.println("-------------------------------------------------");
				i++;
			}
		}
		System.out.println();
	}

	@Override
	public boolean deleteContact(int id) {
		try {
			Contact contact = findById(id);

			if (contact != null) {
				System.out.println("Registro eliminado: " + contact.getName());
				return contacts.remove(contact);
			} else {
				System.out.println("No existe registro con id: " + id);
			}
		} catch (Exception e) {
			System.out.println("Ocurrio un error al encontrar el contacto.");
		}
		return false;
	}

	@Override
	public Contact findContact(String regex) {
		for (Contact c : contacts) {
			if (c.getName().contains(regex))
				return c;
		}
		return null;
	}


	public Contact findById(int id) {
		try {
			return contacts.get(id);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	@Override
	public void updateContact(int index, Contact updated) {
		Contact previous = contacts.set(index, updated);
		System.out.println("Contacto actualizado: " + previous.toString() + "\n -> " + updated.toString());
	}
}
