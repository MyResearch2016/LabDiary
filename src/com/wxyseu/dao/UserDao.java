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
	
	// ��֤�û��ķ���������ֵΪ1��ʾ��¼�ɹ��������ʾ��¼ʧ��
		public int login(User user) {
			int flag = 0;
			String sql = "SELECT * FROM tb_user where userName='"
					+ user.getUsername() + "'";
			ResultSet rs = conn.executeQuery(sql);// ִ��SQL���
			try {
				if (rs.next()) {
					String pwd = user.getPwd();// ��ȡ����
					int uid = rs.getInt(1);// ��ȡ��һ�е�����
					if (pwd.equals(rs.getString(3))) {
						flag = uid;
						rs.last(); // ��λ�����һ����¼
						int rowSum = rs.getRow();// ��ȡ��¼����
						rs.first();// ��λ����һ����¼
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
				ex.printStackTrace();// ����쳣��Ϣ
				flag = 0;
			} finally {
				conn.close();// �ر����ݿ�����
			}
			return flag;
		}
}
