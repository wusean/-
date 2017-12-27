package com.itheima.servlet;

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
 * Servlet implementation class ListAtricleServlet
 */
@WebServlet("/ListAtricle")
public class ListAtricleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArticleDao atricleDao = new ArticleDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有的话题
		List<Article> articles = atricleDao.findArticles();
		
		/**
		 *jsp的域对象:
		 *	pageContext 对于同一个页面
		 *	session  从打开浏览开始，到关闭浏览器为止
		 * 	servletContext
		 *	request  同一个请求地址栏不会发生变化
		 **/
		//吧数据存储到request域对象中
		request.setAttribute("articles", articles);
		
		//页面条状到首页的JSP页面
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

}
