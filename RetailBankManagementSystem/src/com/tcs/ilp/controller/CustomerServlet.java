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


@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custName = request.getParameter("custName");
		int custAge = Integer.parseInt(request.getParameter("custAge"));
		String custAddress = request.getParameter("custAddress");
		String custCity = request.getParameter("custCity");
		String custState = request.getParameter("custState");
		int customerId = CustomerDB.addCustomer(custName, custAge, custAddress, custCity, custState);
		
		if(customerId != 0) {
			request.setAttribute("status", "New Customer Added With Customer-ID:" + customerId);
			RequestDispatcher rd = request.getRequestDispatcher("new-customer.jsp");
			rd.forward(request, response);
			
		}
		
		
	}
}
