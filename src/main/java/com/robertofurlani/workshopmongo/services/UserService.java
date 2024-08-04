package com.robertofurlani.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertofurlani.workshopmongo.domain.User;
import com.robertofurlani.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired	
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
