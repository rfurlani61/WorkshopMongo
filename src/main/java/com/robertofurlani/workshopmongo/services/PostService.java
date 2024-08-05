package com.robertofurlani.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertofurlani.workshopmongo.domain.Post;
import com.robertofurlani.workshopmongo.domain.User;
import com.robertofurlani.workshopmongo.repository.PostRepository;
import com.robertofurlani.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired	
	private PostRepository repo;
	
	public Post findById(String id) {
		
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
	}
	
}
