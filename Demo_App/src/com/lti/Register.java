package com.lti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get Values from JSP
		String name = request.getParameter("uname");
		String age = request.getParameter("age");
		String password = request.getParameter("pname");
		String phone = request.getParameter("phone");

		// Pass to User Modal
		User user = new User(name, age, password, phone);
		RegisterDao registerDao = new RegisterDao();

		registerDao.insert(user);
		response.getWriter().println("Success");

	}

}
