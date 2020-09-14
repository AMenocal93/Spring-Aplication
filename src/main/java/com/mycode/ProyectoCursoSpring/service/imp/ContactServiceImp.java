package com.mycode.ProyectoCursoSpring.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycode.ProyectoCursoSpring.component.ContactConverter;
import com.mycode.ProyectoCursoSpring.entity.Contact;
import com.mycode.ProyectoCursoSpring.model.ContactModel;
import com.mycode.ProyectoCursoSpring.repository.ContactRepository;
import com.mycode.ProyectoCursoSpring.service.ContactService;

@Service("contactServiceImp")
public class ContactServiceImp implements ContactService {
	
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertToContact(contactModel));
		return contactConverter.convertToContactModel(contact);
	}

}
