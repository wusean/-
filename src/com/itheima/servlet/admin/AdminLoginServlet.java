package com.itheima.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.UserDao;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password  = request.getParameter("password");
		
		boolean isSucc = userDao.validateAdminUser(name, password);
		if(isSucc) {
			request.getSession().setAttribute("adminLoginUser", name);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
		}else {
			request.setAttribute("massage", "用户名或密码不正确");
			request.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(request, response);
		}
	}

}
