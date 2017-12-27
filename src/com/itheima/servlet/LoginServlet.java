package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		boolean isSucc = userDao.valdateUser(userName,userPass);
		
		if(isSucc) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userName);
			response.sendRedirect("/forum/ListAtricle");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('用户名或密码不正确！');history.back()</script>");
		}
	}

}
