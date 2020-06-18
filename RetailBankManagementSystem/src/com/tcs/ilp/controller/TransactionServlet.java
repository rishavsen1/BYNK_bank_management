package com.tcs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.bean.TransactionBean;
import com.tcs.ilp.dao.CustomerDB;


@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id1 = Integer.parseInt(request.getParameter("id1"));
		int id2 = Integer.parseInt(request.getParameter("id2"));

		int amount = Integer.parseInt(request.getParameter("amount"));

		TransactionBean tr = CustomerDB.performTransaction(id1, id2, amount);

		if(tr != null) {
			request.setAttribute("transaction", tr);
			RequestDispatcher rd = request.getRequestDispatcher("result3.jsp");
			rd.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("Transaction Failed..Try again!!");
		}
	}

}
