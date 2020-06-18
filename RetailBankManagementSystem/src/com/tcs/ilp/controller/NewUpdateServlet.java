package com.tcs.ilp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.dao.CustomerDB;


@WebServlet("/NewUpdateServlet")
public class NewUpdateServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custId = Integer.parseInt(request.getParameter("custId"));
		String custName = request.getParameter("custName");
		int custAge = Integer.parseInt(request.getParameter("custAge"));
		String custAddress = request.getParameter("custAddress");
		String custCity = request.getParameter("custCity");
		String custState = request.getParameter("custState");
		
		if(CustomerDB.updateCustomerInfo(custId,custName, custAge, custAddress, custCity, custState)) {
			request.setAttribute("data","Customer-Updated With Customer-ID " + custId);
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
