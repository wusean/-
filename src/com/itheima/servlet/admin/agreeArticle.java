package com.itheima.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.ArticleDao;

public class agreeArticle extends HttpServlet {// admin/agreeArticle

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleDao dao = new ArticleDao();
		String articleId = request.getParameter("articleId");
       dao.ageeArticle(articleId);
       request.getRequestDispatcher("checkArticleList").forward(request, response);
      
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
