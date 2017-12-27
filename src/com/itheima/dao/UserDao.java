package com.itheima.dao;

import java.util.Date;

import com.itheima.beans.User;
import com.itheima.util.BeanHandler;

/*
	用户登录的Servlet
*/
public class UserDao extends BaseDao {

	public boolean valdateUser(String userName, String userPass) {
		String sql = "select * from forum_user_table where username=? and password=?";
		
		Object o = find(sql, new Object[]{userName,userPass}, new BeanHandler(User.class));
		return o != null;
	}

	public boolean validateAdminUser(String name, String password) {
		String sql = "select * from forum_user_table where username=? and password=? and role = 3";
		
		Object o = find(sql, new Object[]{name,password}, new BeanHandler(User.class));
		return o != null;
	}
	
	/*private String username; //用户名 
	private String password; //用户密码 
	private Integer sexy; //性别 
	private String phone; //联系电话 
	private String email; //电子邮件 
	private Integer status; //用户状态， 1代表激活状态 2代表冻结状态 
	private Integer role; //用户角色，1代表普通会员 2代表版主 3代表管理员 
	private Date registTime; //注册时间 
*/
	public void addUser(String username,String password,String sexy,String phone,String email){
		String sql = "insert into forum_user_table (username,password,sexy,phone,email,status,role,registTime)"+
				" values (?,?,?,?,?,?,?,now())";
		
		update(sql, new Object[]{username,password,sexy,phone,email,"1","1"});
	}
	
}
