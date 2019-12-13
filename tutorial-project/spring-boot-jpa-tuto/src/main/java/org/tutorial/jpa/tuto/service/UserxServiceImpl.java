package org.tutorial.jpa.tuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutorial.jpa.tuto.entity.Userx;
import org.tutorial.jpa.tuto.repository.UserxRepository;

@Service
public class UserxServiceImpl implements UserxService{
	
	@Autowired
	private UserxRepository userRepository;

	@Override
	public Userx addUser(Userx user) {
		return userRepository.save(user);
	}

}
