package com.mycode.ProyectoCursoSpring.service;


import java.util.List;

import com.mycode.ProyectoCursoSpring.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel); 
	
	public abstract List<ContactModel> listAllContacts();

}
