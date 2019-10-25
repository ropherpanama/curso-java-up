package com.curso.agenda;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import java.util.StringTokenizer;

/**
 * @author ropherpanama
 * Programa basico para mostrar aspectos generales de Java
 */
public class Agenda {

	List<String> contacts = new ArrayList<String>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		while (true) {
			System.out.println("\n================= MENU =================\n");
			System.out.println("1. Añadir contacto");
			System.out.println("2. Listar contactos");
			System.out.println("3. Eliminar contacto");
			System.out.println("4. Buscar contacto");
			System.out.println("5. Actualizar contacto");
			System.out.print("\nSeleccione una opcion: ");

			int opc = scanner.nextInt();
			scanner.nextLine();

			switch (opc) {
			case 1:
				agenda.addContact();
				break;
			case 2:
				agenda.listContacts();
				break;
			case 3:
				agenda.deleteContact();
				break;
			case 4:
				agenda.findContact();
				break;
			case 5:
				agenda.updateContact();
			default:
				break;
			}
		}
	}

	public boolean addContact() {
		String name;
		String phoneNumber;
		String email;

		System.out.println("\n==================== Agregar contacto ====================");
		System.out.print("\nIngrese el nombre: ");
		name = scanner.nextLine();
		System.out.print("\nIngrese el numero telefonico: ");
		phoneNumber = scanner.next();
		System.out.print("\nIngrese el correo electronico: ");
		email = scanner.next();
		String contact = name + "," + phoneNumber + "," + email;
		return contacts.add(contact);
	}

	public void listContacts() {
		System.out.println("\n==================== Contactos ====================");

		if (contacts.isEmpty())
			System.out.println("No se han agregado contactos.");
		else {
			for (int i = 0; i < contacts.size(); i++) {
				String contact = contacts.get(i);
				StringTokenizer tokenizer = new StringTokenizer(contact, ",");
				System.out.println("(" + (i + 1) + ")");
				System.out.println("Nombre: " + tokenizer.nextToken());
				System.out.println("Telefono: " + tokenizer.nextToken());
				System.out.println("Email: " + tokenizer.nextToken());
				System.out.println("-------------------------------------------------");
			}
		}
		System.out.println();
	}

	public void deleteContact() {
		System.out.println("\n==================== Eliminar contacto ====================");

		System.out.print("\nIngrese el identificador del contacto: ");
		int id = scanner.nextInt();
		int index = id - 1;

		if (contacts.isEmpty() || id > contacts.size())
			System.out.println("No existe el id ingresado.");
		else {
			String contact = contacts.get(index);
			contacts.remove(index);
			System.out.println("Registro eliminado: " + contact);
		}
	}

	public void findContact() {
		System.out.println("\n==================== Buscar contacto ====================");

		System.out.print("Ingrese el nombre del contacto: ");
		String name = scanner.nextLine();

		for (String s : contacts) {
			if (s.contains(name))
				System.out.println(s);
		}

	}

	public void updateContact() {
		System.out.println("\n==================== Actualizar contacto ====================");
		System.out.print("\nIngrese el identificador del contacto: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		int index = id - 1;

		if (contacts.isEmpty() || id > contacts.size())
			System.out.println("No existe el id ingresado.");
		else {
			String newName;
			String newPhoneNumber;
			String newEmail;
			String contact = contacts.get(index);
			StringTokenizer tokenizer = new StringTokenizer(contact, ",");
			String oldName = tokenizer.nextToken();
			String oldPhoneNumber = tokenizer.nextToken();
			String oldEmail = tokenizer.nextToken();
			
			System.out.println("Para conservar el valor actual escriba n y presione ENTER");
			
			System.out.print("\nIngrese el nombre [" + oldName + "]: ");
			newName = scanner.nextLine();
			newName = ("n".equals(newName)) ? oldName : newName;
			
			System.out.print("\nIngrese el numero telefonico [" + oldPhoneNumber + "]: ");
			newPhoneNumber = scanner.next();
			newPhoneNumber = ("n".equals(newPhoneNumber)) ? oldPhoneNumber : newPhoneNumber;
			
			System.out.print("\nIngrese el correo electronico [" + oldEmail + "]: ");
			newEmail = scanner.next();
			newEmail = ("n".equals(newEmail)) ? oldEmail : newEmail;
			
			String updated = newName + "," + newPhoneNumber + "," + newEmail;
			contacts.set(index, updated);
			System.out.println("Registro actualizado: " + updated);
		}
	}
}