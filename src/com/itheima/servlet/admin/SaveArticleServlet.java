package com.itheima.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.ArticleDao;

/**
 * Servlet implementation class SaveArticleServlet
 */
@WebServlet(name = "admin/SaveArticleServlet", urlPatterns = { "/admin/SaveArticle" })
public class SaveArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao = new ArticleDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String createPerson = (String) request.getSession().getAttribute("andminLoginUser");
		
		articleDao.addArticle(title, content, createPerson);
		
		//request.getRequestDispatcher(request.getContextPath() +"/adminlist").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/adminlist");
	}

}
