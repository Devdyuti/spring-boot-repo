package org.tutorial.jpa.tuto.service;

import java.util.List;

import org.tutorial.jpa.tuto.entity.Userx;

public interface UserxService {
	public Userx addUser(Userx user);
	public List<Userx> allUser();
}
