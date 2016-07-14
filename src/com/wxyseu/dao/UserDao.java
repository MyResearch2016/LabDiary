package com.wxyseu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wxyseu.model.User;
import com.wxyseu.tools.ConnectDB;

public class UserDao {
	private ConnectDB conn = null;

	public UserDao() {
		conn = new ConnectDB();
	}
	
	// 验证用户的方法，返回值为1表示登录成功，否则表示登录失败
		public int login(User user) {
			int flag = 0;
			String sql = "SELECT * FROM tb_user where userName='"
					+ user.getUsername() + "'";
			ResultSet rs = conn.executeQuery(sql);// 执行SQL语句
			try {
				if (rs.next()) {
					String pwd = user.getPwd();// 获取密码
					int uid = rs.getInt(1);// 获取第一列的数据
					if (pwd.equals(rs.getString(3))) {
						flag = uid;
						rs.last(); // 定位到最后一条记录
						int rowSum = rs.getRow();// 获取记录总数
						rs.first();// 定位到第一条记录
						if (rowSum != 1) {
							flag = 0;
						}
					} else {
						flag = 0;
					}
				} else {
					flag = 0;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();// 输出异常信息
				flag = 0;
			} finally {
				conn.close();// 关闭数据库连接
			}
			return flag;
		}
}
