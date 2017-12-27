package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.ArticleDao;

/**
 * Servlet implementation class AddArticleReplyServlet
 */
@WebServlet("/ReplyServlet")
public class AddArticleReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao = new ArticleDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		String parentArticleId = request.getParameter("articleId");
		String createPerson = (String)request.getSession().getAttribute("loginUser");
		
		articleDao.addArticleReply(content, parentArticleId, createPerson);
		articleDao.updateArticleReplyAmount(parentArticleId);
		
		response.sendRedirect("/forum/SaveComment?id=" + parentArticleId);
	}

}
