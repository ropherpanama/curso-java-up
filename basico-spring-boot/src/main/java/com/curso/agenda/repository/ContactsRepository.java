package com.curso.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.agenda.modelo.Contact;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Integer> {
}
