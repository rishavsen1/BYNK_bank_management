package com.tcs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.bean.CustomerBean;
import com.tcs.ilp.dao.CustomerDB;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<CustomerBean> customerInfo = CustomerDB.getCustomerInfo(id);
		
		if(customerInfo != null) {
			request.setAttribute("customerInfo",customerInfo);
			RequestDispatcher rd = request.getRequestDispatcher("view-searched.jsp");
			rd.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("No Customer-ID Found");
		}
		
	}

}
