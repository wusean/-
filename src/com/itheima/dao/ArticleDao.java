package com.itheima.dao;

import java.util.List;

import com.itheima.beans.Article;
import com.itheima.util.BeanHandler;
import com.itheima.util.BeanListHandler;

/*
 	文章的业务处理类
 */
public class ArticleDao extends BaseDao {
	// 获取所有话题
	@SuppressWarnings("unchecked")
	public List<Article> findArticles() {
		String sql = "select * from forum_article_table where parentArticleId is null and status=?";
		/**
		 *第一个参数：sql
		 *第二个参数：参数值
		 *第三个参数：ResultSetHandler对象
		 *
		 *获取Article类的Class对象
		 *	方式一：Class.forName("完整的类名");(最常用)
		 *	方式二：对象名.getClass();
		 *	方式三：类名.Class
		 **/
		List<Article> articles = (List<Article>) find(sql, new Object[]{"1"}, new BeanListHandler(Article.class)); 
		
		return articles;
	}
	
	//发表话题
	public void addArticle(String title, String content, String createPerson) {
		if(createPerson==null||"".equals(createPerson)){
			createPerson="匿名";
		}
		String status="0";//未同意
		
		
		String sql = "insert into forum_article_table (title,content,createTime,createPerson,status)"+
				" values (?,?,now(),?,?)";
		
		update(sql, new Object[]{title, content, createPerson,status});
	}
	

	public Article findArticle(String id) {
		String sql = "select * from forum_article_table where id = ?";
		return (Article) find(sql, new Object[]{id}, new BeanHandler(Article.class));
	}
	
	//根据话题编号查询该话题的所有评论
	@SuppressWarnings("unchecked")
	public List<Article> findArticleReplys(String id) {
		String sql = "select * from forum_article_table where parentArticleId = ?";
		
		List<Article> articleReplys = (List<Article>)find(sql, new Object[]{id}, new BeanListHandler(Article.class));
		return articleReplys;
	}

	//添加回复
	public void addArticleReply(String content, String parentArticleId, String createPerson) {
		String sql = "insert into forum_article_table (content,parentArticleId,createPerson,createTime)"
				+ " values(?,?,?,now())";
		
		update(sql, new Object[]{content,parentArticleId,createPerson});
	}

	public void updateArticleReplyAmount(String articleId) {
		String sql = "update forum_article_table set totalReply = totalReply + 1 where id = ?";
		update(sql, new Object[]{articleId});
		
	}
	
	/*
	根据标题内容查询话题
	*/
	public List<Article> findArticles(String title) {
		if (title != null && ! "".equals(title)) {
			String sql = "select * from forum_article_table where parentArticleId is null and title like ?";
			
			return (List<Article>)find(sql, new Object[]{'%'+title+'%'}, new BeanListHandler(Article.class));
		} else {
			return findArticles();
		}
	}

	public Article getArticle(String articleId) {
		String sql = "select * from forum_article_table  where id = ?";
		
	return (Article)find(sql, new Object[]{articleId}, new BeanHandler(Article.class));
	}
	
	public void UpdateArticle(String articleId,String title,String content,String lastUpdatePerson) {
		String sql = "update forum_article_table set title=?,content=?,lastUpdateTime=now(),lastUpdatePerson=?  where id = ?";
		
		update(sql, new Object[]{title,content,articleId,lastUpdatePerson});
	}
	
	public void DeleteArticle(String articleId){
		String sql="delete from forum_article_table where id=?";
		update(sql, new Object[]{articleId});
	}
	
	
	
	public List<Article> findcheckList() {
		String sql = "select * from forum_article_table where parentArticleId is null and status=?";
		/**
		 *第一个参数：sql
		 *第二个参数：参数值
		 *第三个参数：ResultSetHandler对象
		 *
		 *获取Article类的Class对象
		 *	方式一：Class.forName("完整的类名");(最常用)
		 *	方式二：对象名.getClass();
		 *	方式三：类名.Class
		 **/
		List<Article> articles = (List<Article>) find(sql, new Object[]{"0"}, new BeanListHandler(Article.class)); 
		
		return articles;
	}
	
	
	public List<Article>  findchecktitle(String title) {
		if (title != null && ! "".equals(title)) {
			String sql = "select * from forum_article_table where parentArticleId is null  and status=?  and title like ? ";
			
			return (List<Article>)find(sql, new Object[]{"0",'%'+title+'%'}, new BeanListHandler(Article.class));
		} else {
			return findcheckList();
		}
	}
	public void ageeArticle(String articleId){
	String sql = "update forum_article_table set status=?  where id = ?";
		
		update(sql, new Object[]{"1",articleId});
	}
	
	
}
