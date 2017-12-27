package com.itheima.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.beans.Article;
import com.itheima.dao.ArticleDao;

/**
 * Servlet implementation class ListArticleServlet
 */
@WebServlet("/admin/ListArticle")
public class ListArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleDao articleDao = new ArticleDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response是响应
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		List<Article> articleList = articleDao.findArticles(title);
		request.setAttribute("articles", articleList);
		request.setAttribute("title", title);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/article/list.jsp").forward(request, response);
	}

}
