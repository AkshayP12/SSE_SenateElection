package com.onlinevotingsystem.ovs.service;

import com.onlinevotingsystem.ovs.model.User;
import com.onlinevotingsystem.ovs.user.CrmUser;

public interface UserService {
	public void saveUser(CrmUser user);
	
	public boolean isUserAlreadyPresent (CrmUser user);
}
