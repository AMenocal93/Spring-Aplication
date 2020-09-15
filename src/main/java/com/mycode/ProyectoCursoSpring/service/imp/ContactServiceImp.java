package com.mycode.ProyectoCursoSpring.service.imp;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.convertToContactModel(contact));
		}
		
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
	return contactRepository.findById(id);
	}
	
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertToContactModel(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if (null != contact) {
			contactRepository.delete(contact);
		}
		
	}

	

}
