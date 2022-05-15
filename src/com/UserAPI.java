package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;




@WebServlet("/UserAPI") 

public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User UserObj = new User();
	
	public UserAPI()
	{
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String output = UserObj.insertUser(
				request.getParameter("name"), 
				request.getParameter("uAddress"), 
				request.getParameter("uEmail"),
				request.getParameter("nic"),
				request.getParameter("Pno")); 
				response.getWriter().write(output); 
		
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		 String output = UserObj.updateUser(paras.get("hidUserIDSave").toString(), 
		paras.get("name").toString(), 
		paras.get("uAddress").toString(), 
		paras.get("uEmail").toString(), 
		paras.get("nic").toString(), 
		paras.get("Pno").toString()); 
		response.getWriter().write(output); 
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		 String output = UserObj.deleteUser(paras.get("uID").toString()); 
		response.getWriter().write(output); 

		
	}

	
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request) 
		{ 
		 Map<String, String> map = new HashMap<String, String>(); 
		try
		 { 
		 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
		 String queryString = scanner.hasNext() ? 
		 scanner.useDelimiter("\\A").next() : ""; 
		 scanner.close(); 
		 String[] params = queryString.split("&"); 
		 for (String param : params) 
		 {
			 String[] p = param.split("="); 
			 map.put(p[0], p[1]); 
			 } 
			 } 
			catch (Exception e) 
			 { 
			 } 
			return map; 
		}


}
