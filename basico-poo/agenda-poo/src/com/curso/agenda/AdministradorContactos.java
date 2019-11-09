package com.curso.agenda;

import java.util.List;
import java.util.Scanner;

import com.curso.agenda.implementacion.AgendaTelefonica;
import com.curso.agenda.modelo.Contact;

/**
 * Clase que contiene el manejo de la logica de administracion de contactos
 * @author ropherpanama
 *
 */
public class AdministradorContactos {

	private Scanner scanner = new Scanner(System.in);
	private AgendaTelefonica agenda = new AgendaTelefonica();

	/**
	 * Rutina principal del programa
	 * @param contacts Lista de contactos que debe manejar la rutina
	 */
	private void runAdmin(List<Contact> contacts) {
		int index = 0;
		int id = 0;

		while (true) {
			System.out.println("\n================= MENU =================\n");
			System.out.println("1. Añadir contacto");
			System.out.println("2. Listar contactos");
			System.out.println("3. Eliminar contacto");
			System.out.println("4. Buscar contacto");
			System.out.println("5. Actualizar contacto");
			System.out.println("6. Salir");
			System.out.print("\nSeleccione una opcion: ");

			int opc = scanner.nextInt();
			scanner.nextLine();

			switch (opc) {
			case 1:
				System.out.println("\n==================== Agregar contacto ====================");

				String name;
				String phoneNumber;
				String email;

				System.out.print("\nIngrese el nombre: ");
				name = scanner.nextLine();
				System.out.print("\nIngrese el numero telefonico: ");
				phoneNumber = scanner.next();
				System.out.print("\nIngrese el correo electronico: ");
				email = scanner.next();

				Contact contact = new Contact(name, phoneNumber, email);

				if (agenda.addContact(contact))
					System.out.println("Contacto agregado.");
				else
					System.out.println("No se pudo agregar el contacto.");
				break;
			case 2:
				agenda.listContacts();
				break;
			case 3:
				System.out.println("\n==================== Eliminar contacto ====================");

				if (contacts.isEmpty())
					System.out.println("No se han agregado contactos.");
				else {
					System.out.print("\nIngrese el identificador del contacto: ");
					id = scanner.nextInt();
					index = id - 1;

					if (agenda.deleteContact(index))
						System.out.println("Contacto eliminado.");
					else
						System.out.println("No se pudo eliminar el contacto.");
				}
				break;
			case 4:
				System.out.println("\n==================== Buscar contacto ====================");

				if (contacts.isEmpty())
					System.out.println("No se han agregado contactos.");
				else {
					System.out.print("Ingrese el nombre del contacto: ");
					String regex = scanner.nextLine();

					Contact c = agenda.findContact(regex);

					if (c != null) {
						System.out.println("Nombre: " + c.getName());
						System.out.println("Telefono: " + c.getPhoneNumber());
						System.out.println("Email: " + c.getEmail());
						System.out.println("-------------------------------------------------");
					} else
						System.out.println("No existen coincidencias de contacto.");
				}
				break;
			case 5:
				System.out.println("\n==================== Actualizar contacto ====================");

				if (contacts.isEmpty())
					System.out.println("No se han agregado contactos.");
				else {
					System.out.print("\nIngrese el identificador del contacto: ");
					id = scanner.nextInt();
					scanner.nextLine();
					index = id - 1;

					Contact actual = agenda.findById(index);

					if (actual != null) {
						String newName;
						String newPhoneNumber;
						String newEmail;
						String oldName = actual.getName();
						String oldPhoneNumber = actual.getPhoneNumber();
						String oldEmail = actual.getEmail();

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

						Contact updated = new Contact(newName, newPhoneNumber, newEmail);

						agenda.updateContact(index, updated);

					} else
						System.out.println("No existe registro con id: " + id);
				}
				break;
			case 6:
				System.out.println("I'll be back ...");
				System.exit(0);
				break;
			default:
				System.out.println("Opcion incorrecta, seleccione una opcion del listado.");
				break;
			}
		}
	}

	/**
	 * Retorna la instancia de la clase agenda telefonica
	 * @return Objeto de tipo AgendaTelefonica
	 */
	public AgendaTelefonica getAgenda() {
		return agenda;
	}

	//Rutina main
	public static void main(String[] args) {
		AdministradorContactos admin = new AdministradorContactos();
		List<Contact> contacts = admin.getAgenda().getContacts();
		admin.runAdmin(contacts);
	}
}
