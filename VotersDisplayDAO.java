package com.bl.evoting.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.bl.evoting.bean.Candidates;
import com.bl.evoting.bean.Voters;

public class VotersDisplayDAO {

	

	public Voters getVoterById(int id) throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;

		try {
			rs = dbDao.query("select * from voter where id = ?;", id);

			if (rs.next()) {
				Voters voter = new Voters();
				voter.setId(rs.getInt("id"));
				voter.setUsername(rs.getString("username"));

				return voter;
			} else {
				return null;
			}
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}
	

	public ArrayList<Voters> getAllVoters() throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;
		ArrayList<Voters> votersList = new ArrayList<Voters>();

		try {

			rs = dbDao.query("select * from voter;");

			while (rs.next()) {
				Voters voter = new Voters();
				voter.setId(rs.getInt("id"));
				voter.setUsername(rs.getString("username"));
				
				votersList.add(voter);
			}
			return votersList;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}
	}
	
	public Set<Candidates> getCandidatesByEId(int eid) throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;
		Set<Candidates> candidatesList = new HashSet<Candidates>();
		try {

			rs = dbDao.query("select can.id, can.name from candidate can join candidate_referendum_election_relation cr on cr.c_id=can.id join referendum_election re on re.id = cr.e_id where e_id = ?;",eid);
			
			while (rs.next()) {
				Candidates candidate = new Candidates();
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));
				
				candidatesList.add(candidate);
				
			}
			return candidatesList;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}
	}
	
	public  static void main(String[] agrs) throws Exception {
		VotersDisplayDAO cdDao = new VotersDisplayDAO();
		Set<Candidates> candidatesSet = cdDao.getCandidatesByEId(17);
		int i = 0;
		System.out.println("*****"+candidatesSet.size()+"*****");
		for (Candidates candidates : candidatesSet) {
			System.out.println(candidates.getId()+candidates.getName() + (i++));
		}
	}
}
