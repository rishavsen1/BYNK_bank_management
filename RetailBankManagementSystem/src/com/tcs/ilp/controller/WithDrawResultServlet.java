package com.tcs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.dao.CustomerDB;


@WebServlet("/WithDrawResultServlet")
public class WithDrawResultServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amount = Integer.parseInt(request.getParameter("amount"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		int final_amount = CustomerDB.updateAccountsWithDraw(id, amount);
		
		if(final_amount != 0 && final_amount >=0) {
			request.setAttribute("balance-withdraw", "Final Balance For Customer-ID " + id + 
								":Rs" + final_amount);
			RequestDispatcher rd = request.getRequestDispatcher("result2.jsp");
			rd.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.print("You can't withdraw money:Insufficient Balance..");
		}
	}

}
