package com.mahoney.web.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mahoney.entities.Firearm;
import com.mahoney.web.jdbc.FirearmsDbUtil;

@WebServlet("/FirearmsInventoryControllerServlet")
public class FirearmsInventoryControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private FirearmsDbUtil firearmsDbUtil;
	
	// Define datasource/connection for Resource Injection
	@Resource(name="jdbc/firearms_inventory")
	private DataSource dataSource;
       
	@Override
	public void init() throws ServletException
	{
		super.init();
		
		// create instance of db util and pass in dataSource
		try
		{
			firearmsDbUtil = new FirearmsDbUtil(dataSource);
		}
		catch(Exception e)
		{
			throw new ServletException(e);
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			// read the command param
			String theCommand = request.getParameter("command");
			if(theCommand == null)
				theCommand="LIST";
			
			// route to appropriate method
			switch (theCommand) 
			{
				case "LIST":
					listFirearms(request, response);
					break;
				case "VIEW":
					viewFirearm(request, response);
					break;
				default:
					listFirearms(request, response);
			}
		}
		catch(Exception e)
		{
			throw new ServletException(e);
		}
	}
	
	private void listFirearms(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// get students from db util
		List<Firearm> firearms = firearmsDbUtil.getFirearms();
		
		// add students to the request
		request.setAttribute("FIREARM_LIST", firearms);
		
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/firearms-collection.jsp");
		dispatcher.forward(request, response);
	}
	
	private void viewFirearm(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String theSerialNumber = request.getParameter("serialNumber");
		
		// get students from db util
		Firearm firearm = firearmsDbUtil.getFirearm(theSerialNumber);
		
		// add students to the request
		request.setAttribute("FIREARM", firearm);
		
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-firearm.jsp");
		dispatcher.forward(request, response);
	}
}
