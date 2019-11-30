package com.agenda.interfaces;

import com.agenda.modelo.Contact;

public interface Agenda {
	/**
	 * Agrega un contacto a la lista
	 * 
	 * @param c Contacto a agregar
	 */
	public boolean addContact(Contact c);

	/**
	 * Retorna el listado completo de contactos guardados actualmente
	 */
	public void listContacts();

	/**
	 * Elimina un contacto del listado
	 * 
	 * @param id Identificador del contacto a eliminar
	 * @return true si elimina el registro correctamente, false si el registro no
	 *         existe o no puede ser eliminado
	 */
	public boolean deleteContact(int id);

	/**
	 * Busca un contacto segun el filtro ingresado como parametro. Solo devolvera la
	 * primera ocurrencia del filtro (en caso de existir mas de una coincidencia)
	 * 
	 * @param regex Palabra filtro para la busqueda
	 * @return Contacto encontrado, null si no existe ninguna coincidencia
	 */
	public Contact findContact(String regex);

	/**
	 * Actualiza la informacion de un contacto existente en la lista
	 * 
	 * @param actual  Contacto con la informacion actual
	 * @param updated Contacto con la informacion actualizada
	 */
	public void updateContact(Contact updated);
}
