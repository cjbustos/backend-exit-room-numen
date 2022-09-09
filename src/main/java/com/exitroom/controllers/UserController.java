package com.exitroom.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends HttpServlet {
	
	List<String> listOfUsers = Arrays.asList("cbustos", "jsosa", "cgutierrez");

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Lista de usuarios</h1>");
		out.println("<ul>");
		for(String name: listOfUsers) {
			out.println("<li>" + name + "</li>");
		}
		out.println("</ul>");
		
		response.setStatus(200);

	}

}
