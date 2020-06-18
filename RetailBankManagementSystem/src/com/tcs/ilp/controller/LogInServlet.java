package com.tcs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.dao.UserDB;


@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		if(UserDB.getUser(uname,upass)) {
			HttpSession session = request.getSession();
			session.setAttribute("is_logged_in",uname);
			if(UserDB.getUserDomain(uname, upass).equals("Executive")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("actions.jsp");
				dispatcher.forward(request, response);
			}
			if(UserDB.getUserDomain(uname, upass).equals("Cashier")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("cashier-actions.jsp");
				dispatcher.forward(request, response);
			}
			
		}else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("Sorry,Invalid Information");
		}
	}

}
