package com.bl.evoting.adminservlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bl.evoting.bean.Admins;
import com.bl.evoting.dao.DBDao;

/**
 * Servlet implementation class VoterLoginServlet
 */

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// if login failure, redirect to the login page
		request.getRequestDispatcher("WEB-INF/admin/admin_login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			DBDao dbDao = new DBDao();

			ResultSet rs = dbDao.query("select * from administrator where username=?", username);

			if (rs.next()) {
				if (rs.getString("password").equals(password)) {
					Admins currentAdmin = new Admins();
					currentAdmin.setId(rs.getInt("id"));
					currentAdmin.setUsername(rs.getString("username"));
					currentAdmin.setPassword(rs.getString("password"));

					// put currentVoter into current session
					HttpSession session = request.getSession();
					session.setAttribute("currentAdmin", currentAdmin);

					request.getRequestDispatcher("WEB-INF/admin/admin_login_success.jsp").forward(request, response);
				} else {

					request.getRequestDispatcher("WEB-INF/admin/admin_login_failure.jsp").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("WEB-INF/admin/admin_login_failure.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
