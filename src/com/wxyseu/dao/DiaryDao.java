package com.wxyseu.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxyseu.model.Diary;
import com.wxyseu.tools.ConnectDB;

public class DiaryDao {
	private ConnectDB conn = null; // 创建数据库连接对象
	
	public DiaryDao()
	{
		conn = new ConnectDB();	// 实例化数据库连接对象
	}
	
	/*
	 * 查询日记
	 * 
	 * @param sql
	 * @return
	 * */
	public List<Diary> queryDiary(String sql)
	{
		ResultSet rs = conn.executeQuery(sql); // 执行查询语句
		List<Diary> list = new ArrayList<Diary>();
		
		try {
			while(rs.next())
			{
				Diary diary = new Diary();
				diary.setId(rs.getInt(1));	// 获取并设置ID
				// diary.setLabel(rs.getString(2));	// 获取并设置日记标签
				diary.setText(rs.getString(2));	// 获取并设置日记内容
				diary.setTimeString(rs.getTimestamp(3).toLocaleString());	// 设置写日记时间			
				diary.setUserid(rs.getInt(4));	// 获取并设置用户ID
				diary.setUsername(rs.getString(5));	// 获取并设置用户名
				list.add(diary);	// 将体积信息保存到list集合中
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			conn.close();	// 最后要关闭数据库连接
		}

		return list;
	}
	
	/*
	 * 功能：保存日记到数据库
	 * 
	 * @param diary
	 * @return
	 * */
	public int saveDiary(Diary diary)
	{
		// 保存数据的SQL语句
		String sql = "INSERT INTO tb_diary(text,writeTime,"
				+ "userid,username) VALUES('"+diary.getText()+"','"+diary.getWriteTime()
				+"',"+diary.getUserid()+",'"+diary.getUsername()+"')";
		int r = conn.executeUpdate(sql); // 执行更新语句
		conn.close(); // 保存数据后关闭数据库连接
		
		return r;			
	}
	
	/*
	 * 删除指定日记
	 * 
	 * @param id
	 * @return
	 * */
	public int delDiary(int id)
	{
		String sql = "DELETE FROM tb_diary WHERE id="+id;
		int r = 0;
		try {
			r = conn.executeUpdate(sql); // 执行更新语句
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			conn.close();	// 关闭数据库连接
		}
		
		return r;
	}
}
