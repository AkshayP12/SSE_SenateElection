package com.onlinevotingsystem.ovs.dao;

import com.onlinevotingsystem.ovs.model.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}
