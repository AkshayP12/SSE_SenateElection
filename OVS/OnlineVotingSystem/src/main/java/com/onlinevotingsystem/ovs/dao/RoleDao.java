package com.onlinevotingsystem.ovs.dao;

import com.onlinevotingsystem.ovs.model.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
