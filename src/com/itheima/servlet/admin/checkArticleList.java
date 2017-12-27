package com.itheima.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.beans.Article;
import com.itheima.dao.ArticleDao;

public class checkArticleList  extends HttpServlet {//admin/checkArticleList
	private static final long serialVersionUID = 1L;
    ArticleDao articleDao = new ArticleDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		List<Article> articleList = articleDao.findchecktitle(title);
		request.setAttribute("articles", articleList);
		request.setAttribute("title", title);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/article/checklist.jsp").forward(request, response);
	}

}


