package com.bl.evoting.bean;

import java.util.HashSet;
import java.util.Set;

public class CandidatesSet {

	private Set<Candidates> candidatesSet = new HashSet<Candidates>();

	public Set<Candidates> getCandidatesSet() {
		return candidatesSet;
	}

	public void setCandidatesSet(Set<Candidates> candidatesSet) {
		this.candidatesSet = candidatesSet;
	}

	public boolean addCandidates(Candidates candidate) {
		candidatesSet.add(candidate);
		return true;
	}

	public boolean removeCandidates(Candidates candidate) {
		candidatesSet.remove(candidate);
		return true;
	}

	public int countNumberOfCandidates() {
		return candidatesSet.size();
	}
	
	public static void main(String[] args) {
		
		Candidates c1 = new Candidates();
		c1.setId(1);
		c1.setName("Yuan");
		
		Candidates c2 = new Candidates();
		c2.setId(2);
		c2.setName("Edmund");
		
		CandidatesSet candidateSet = new CandidatesSet();
		candidateSet.addCandidates(c1);
		candidateSet.addCandidates(c2);
		
		for (Candidates c : candidateSet.candidatesSet) {
			System.out.println(c.getId()+" "+c.getName());
		}
		
	}

}
