package com.onlinevotingsystem.ovs.service;

import com.onlinevotingsystem.ovs.model.User;

public interface UserService {
	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent (User user);
}
