package com.itheima.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.dao.ArticleDao;

public class UpadteArticleServlet extends HttpServlet {

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        request.setCharacterEncoding("utf-8");
		String content=request.getParameter("content");
		System.out.println("--------修改的内容为："+content);
		String title=request.getParameter("title");
		System.out.println("--------修改的内容为："+title);
		String articleId=request.getParameter("articleId");
		HttpSession session=request.getSession();
		String lastUpatePerson=(String)session.getAttribute("adminLoginUser");
		ArticleDao articleDao = new ArticleDao();
		System.out.println("--------修改的内容为："+lastUpatePerson);
		articleDao.UpdateArticle(articleId,title,content,lastUpatePerson);
		response.sendRedirect(request.getContextPath()+"/adminlist");
		
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}

	

}
