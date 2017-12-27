package com.itheima.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.beans.Article;
import com.itheima.dao.ArticleDao;

public class ModifyArticleSevlet extends HttpServlet {

	
	//@WebServlet("/admin/ModyfyArticle")admin/ModifyArticleSevlet
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleDao articleDao = new ArticleDao();
		String articleId=request.getParameter("articleId");
		System.out.println("id为"+articleId);
		Article article=articleDao.getArticle(articleId);
		request.setAttribute("article", article);
		/*
		 将article传给modify.jsp
		 */
		request.getRequestDispatcher("/WEB-INF/jsp/admin/article/modify.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request,response);
	}


}
