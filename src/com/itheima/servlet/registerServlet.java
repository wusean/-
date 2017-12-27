package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.UserDao;

public class registerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
        UserDao dao=new UserDao();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sexy=request.getParameter("sexy");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
		
		sexy="1";
		dao.addUser(username, password, sexy, phone, email);
		
		
		response.sendRedirect("http://localhost:8080/forum/");
		
		
		
		
		
		
	}

}
