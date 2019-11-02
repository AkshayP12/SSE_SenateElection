package com.onlinevotingsystem.ovs.model;

import java.util.ArrayList;
import java.util.Iterator;

public class ValidUsers {
	
	private ArrayList <Newuser>users;

	public ArrayList getUsers() {
		return users;
	}

	public void setUsers(ArrayList users) {
		this.users = users;
	}
	
	public void addedusers() {
		
	ArrayList<Newuser> list = new ArrayList	<>();
		list.add(new Newuser("Joe", "Joe","a12345"));
		list.add(new Newuser("Jay", "Jay","b12345"));
		list.add(new Newuser("Daniel", "Daniel","c12345"));
		list.add(new Newuser("Chris","Chris","d12345"));
		this.setUsers(list);
		
	}

	
}