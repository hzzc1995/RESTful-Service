package com.example.demo;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/contacts")
public class ContactController {
	
	static Map<Integer, Contact> contacts = Collections.synchronizedMap(new HashMap<Integer, Contact>());
	
	// GET all contacts from the address book
	@GetMapping("")
	public ResponseEntity<?> getContactList() {
		try {
			List<Contact> contactsList = new ArrayList<Contact>(contacts.values());
			return new ResponseEntity(contactsList, HttpStatus.OK);
		}catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Add a new contact to the address book
	@PostMapping("")
    public ResponseEntity<?> postContact(@RequestBody Contact contact) {
		try {
			int index = contacts.size() + 1;
			contact.setId(String.valueOf(index));
	        contacts.put(index, contact);
	        return new ResponseEntity(contact, HttpStatus.CREATED);
		}catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
    }
	
	// Delete all contacts from the address book
    @DeleteMapping("")
    public ResponseEntity<?> deleteAllContact() { 
    	try {
    		List<Contact> contactsList = new ArrayList<Contact>(contacts.values());
            contacts.clear();
            return new ResponseEntity(contactsList, HttpStatus.OK);
    	}catch (Exception ex) {
    		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    	}
    	
    } 
	
    // Retrieve contact by ID
    @GetMapping("/{id}")
    public ResponseEntity getContact(@PathVariable String id) {
        try {
        	Contact contact = contacts.get(Integer.parseInt(id));
        	if(contact == null) {
        		return new ResponseEntity(HttpStatus.NOT_FOUND);
        	}
        	else {
        		return new ResponseEntity(contact, HttpStatus.OK);
        	}
        }catch (Exception ex) {
        	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

    
    // Update an existing contact by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> putContact(@PathVariable String id, @RequestBody Contact contact) {
    	try {
    		if (contacts.get(Integer.parseInt(id)) == null) {
    			return new ResponseEntity(HttpStatus.NOT_FOUND);
    		}
    		else {
    			Contact c = contacts.get(Integer.parseInt(id));
                c.setFirstName(contact.getFirstName());
                c.setFamilyName(contact.getFamilyName());
                c.setPhoneNumber(contact.getPhoneNumber());
                c.setEmail(contact.getEmail());
                contacts.put(Integer.parseInt(id), c);
                return new ResponseEntity(c, HttpStatus.OK);
    		}
    	}catch (Exception ex) {
    		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    	}
    }
    
	// Delete an existing contact by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable String id) { 
    	try {
    		int i = Integer.parseInt(id);
    		Contact c = contacts.get(i);
    		if (c == null) {
    			return new ResponseEntity(HttpStatus.NOT_FOUND);
    		}
    		else {
    			contacts.remove(i);
    			return new ResponseEntity(c, HttpStatus.OK);
    		}	
    	}catch (Exception ex) {
    		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    	}
    }
}