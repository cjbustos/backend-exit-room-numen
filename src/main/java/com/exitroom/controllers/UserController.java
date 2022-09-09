package com.exitroom.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exitroom.db.JPAConector;
import com.exitroom.model.User;
import com.exitroom.utils.Utils;
import com.google.gson.Gson;

//HttpServlet -> Design Patters - Template Method
public class UserController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		
		var conector = new JPAConector();
		var em = conector.getEntityManager();
		var qr = em.createQuery("SELECT u FROM User u", User.class);
		
		var u = qr.getResultList();
		
		//var user = new User(Utils.generateId(), "cbustos", "1234");
		
		var userJson = new Gson().toJson(u);

		PrintWriter out = response.getWriter();
		out.println(userJson);
		
		

		response.setStatus(200);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		var strJson = new StringBuilder();

		while (br.ready()) {
			strJson.append(br.readLine());
		}

		var user = new Gson().fromJson(strJson.toString(), User.class);

		System.out.println("Id: " + user.getId() + "username: " + user.getUsername() + " " + "password: " + user.getPassword());
		
		var conector = new JPAConector();
		var em = conector.getEntityManager();
		var tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
		
		response.setStatus(201);
	}

	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("PUT");

		response.setStatus(200);

	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("DELETE");

		response.setStatus(200);

	}

}
