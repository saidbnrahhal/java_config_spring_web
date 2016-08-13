package com.springtuto.examples.model.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtuto.examples.model.Authority;
import com.springtuto.examples.model.dao.AuthorityRepository;

@Service
public class AuthorityService {
	
	@Autowired
	AuthorityRepository authorityRepository;

	public void save(Authority authority){
		authorityRepository.save(authority);
	}
	public List<Authority> findAll(){
		return authorityRepository.findAll();
	}
	public void delete(Long id){
		authorityRepository.delete(id);
	}
}
