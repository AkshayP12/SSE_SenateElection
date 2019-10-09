package com.bl.evoting.adminservlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.Admins;
import com.bl.evoting.bean.ReferendumElections;
import com.bl.evoting.bean.Voters;
import com.bl.evoting.dao.DBDao;

/**
 * Servlet implementation class VotingSubmission
 */

public class AddVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddVoter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("votersListForAddToElection") != null) {
			Set<Voters> votersSet = (Set<Voters>) request.getSession().getAttribute("votersListForAddToElection");

			ReferendumElections election = (ReferendumElections) request.getSession().getAttribute("electionForAddVoter");

			int aId = ((Admins) request.getSession().getAttribute("currentAdmin")).getId();
			int eId = election.getId();
			System.out.println("**********aId = " + aId + ",eId=" + eId + "*******");
			try {
				DBDao dbDao = new DBDao();
				for (Voters voter : votersSet) {
					dbDao.insert("insert into admin_voter_election_relation values(?,?,?)", aId, voter.getId(), eId);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getRequestDispatcher("WEB-INF/admin/admin_add_success.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.doGet(request, response);
		//
	}

}
