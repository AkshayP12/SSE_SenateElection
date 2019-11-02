package com.onlinevotingsystem.ovs.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinevotingsystem.ovs.dao.UserDao;
import com.onlinevotingsystem.ovs.model.Role;
import com.onlinevotingsystem.ovs.model.User;
import com.onlinevotingsystem.ovs.repository.RoleRepository;
import com.onlinevotingsystem.ovs.repository.UserRepository;
import com.onlinevotingsystem.ovs.user.CrmUser;

@Service
public class UserServiceImp implements UserService {

	@Autowired
private	BCryptPasswordEncoder encoder;
	@Autowired
private	RoleRepository roleRepository;
	@Autowired
private UserRepository userRepository;
	private UserDao userDao;
	@Override
	public void saveUser(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUniqueId(crmUser.getUniqueId());
		user.setPassword(encoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		user.setStatus("VERIFIED");	
		user.setState(crmUser.getState());
		Role userRole = roleRepository.findByRole("SITE_USER");
	
	
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public boolean isUserAlreadyPresent(CrmUser user) {
		 boolean isUserAlreadyExists = false;
	     User existingUser = userRepository.findByEmail(user.getEmail());
	     if(existingUser != null){
	         isUserAlreadyExists = true; 
	     }
	     return isUserAlreadyExists;
	}
	
	
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUniqueId(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	@Override
	public User findByUserName(String userName) {
		
		return userDao.findByUserName(userName);
	}
}

