package com.robertofurlani.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertofurlani.workshopmongo.domain.User;
import com.robertofurlani.workshopmongo.dto.UserDTO;
import com.robertofurlani.workshopmongo.repository.UserRepository;
import com.robertofurlani.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired	
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("User not found"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO userDto) {
		User user = new User(userDto.getId(), userDto.getName(), userDto.getEmail());
		return user;
	}

}
