package com.agenda.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenda.conector.ConectorPostgreSQL;
import com.agenda.modelo.Contact;

public class AgendaTelefonica implements Agenda {

	private List<Contact> contacts = new ArrayList<Contact>();
	private Connection conexion = ConectorPostgreSQL.getConnection();

	@Override
	public boolean addContact(Contact c) {
		try {
			PreparedStatement ps = conexion
					.prepareStatement("insert into contacts (name, phone, email) values (?, ?, ?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getPhoneNumber());
			ps.setString(3, c.getEmail());
			ps.execute();
			return contacts.add(c);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void listContacts() {
		try {
			// se limpia la lista para no re acumular la data
			contacts.clear();
			// consulta a base de datos
			PreparedStatement ps = conexion.prepareStatement("select * from contacts");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Contact c = new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("phone"),
						rs.getString("email"));
				contacts.add(c);
			}

			System.out.println("\n==================== Contactos ====================");

			if (contacts.isEmpty())
				System.out.println("No se han agregado contactos.");
			else {

				for (Contact c : contacts) {
					System.out.println("Identificador: " + c.getId());
					System.out.println("Nombre: " + c.getName());
					System.out.println("Telefono: " + c.getPhoneNumber());
					System.out.println("Email: " + c.getEmail());
					System.out.println("-------------------------------------------------");
				}
			}
			System.out.println();

		} catch (Exception e) {
			System.out.println("Error al consultar datos: " + e.getMessage());
		}
	}

	@Override
	public boolean deleteContact(int id) {
		try {
			Contact contact = findById(id);

			if (contact != null) {
				PreparedStatement ps = conexion.prepareStatement("delete from contacts where id = ?");
				// usamos el id del contacto obtenido de la base de datos
				ps.setInt(1, contact.getId());
				if (ps.executeUpdate() > 0) {
					System.out.println("Registro eliminado: " + contact.getName());
					return true;
				}
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
		try {
			// se limpia la lista para no re acumular la data
			contacts.clear();
			// consulta a base de datos
			PreparedStatement ps = conexion.prepareStatement("select * from contacts where name like ?");
			ps.setString(1, "%" + regex + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Contact c = new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("phone"),
						rs.getString("email"));
				contacts.add(c);
			}

			if (!contacts.isEmpty())
				return contacts.get(0);// se retorna unicamente el primer registro encontrado, se puede delvolver toda
										// la lista modificando el tipo de retorno
		} catch (Exception e) {
			System.out.println("Error al consultar datos: " + e.getMessage());
		}
		return null;
	}

	public Contact findById(int id) {
		// simplemente inicializamos en null para permitir la compilacion
		Contact contact = null;
		try {
			PreparedStatement ps = conexion.prepareStatement("select * from contacts where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				contact = new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("phone"),
						rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("No controlo este error!" + e.getMessage());
		}

		return contact;
	}

	@Override
	public void updateContact(Contact updated) {
		try {
			PreparedStatement ps = conexion.prepareStatement("update contacts set name = ?, phone = ?, email = ? where id = ?");
			ps.setString(1, updated.getName());
			ps.setString(2, updated.getPhoneNumber());
			ps.setString(3, updated.getEmail());
			ps.setInt(4, updated.getId());
			//antes de ejecutar la sentencia debemos setear el autocommit a false: Cannot commit when autoCommit is enabled.
			conexion.setAutoCommit(false);
			ps.executeUpdate();
			conexion.commit();
			System.out.println("Contacto actualizado: " + updated.getName());
		}catch (Exception e) {
			System.out.println("Error al actualizar los datos: " + e.getMessage());
		}
	}
}
