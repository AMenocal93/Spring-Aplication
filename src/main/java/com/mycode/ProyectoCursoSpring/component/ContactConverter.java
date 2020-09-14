package com.mycode.ProyectoCursoSpring.component;

import org.springframework.stereotype.Component;

import com.mycode.ProyectoCursoSpring.entity.Contact;
import com.mycode.ProyectoCursoSpring.model.ContactModel;

@Component("contactConverter") 
public class ContactConverter {

	public Contact convertToContact(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setCity(contactModel.getCity());
		contact.setTelephone(contactModel.getTelephone());
		return contact;
	}
	
	public ContactModel convertToContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setCity(contact.getCity());
		contactModel.setTelephone(contact.getTelephone());
		return contactModel;
	}  
	
	
	
}
