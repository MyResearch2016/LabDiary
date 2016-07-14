package com.wxyseu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxyseu.dao.DiaryDao;
import com.wxyseu.model.Diary;
import com.wxyseu.tools.MyPagination;

/**
 * Servlet implementation class DiaryServlet
 */
public class DiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	MyPagination pagination = null;  // 数据分页类的对象
	DiaryDao dao = null;	// 日记相关的数据库操作
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
        dao = new DiaryDao();	// 实例化日记相关的数据库操作类的对象
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	// 执行doPost()方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("publish".equals(action))
			save(request,response);	// 发布并保存日记
		else if("listDiary".equals(action))
			listDiary(request,response);	// 查询我的日记
		else if("delDiary".equals(action))
			delDiary(request,response);		// 删除我的日记
	}
	
	/*
	 * 功能：删除日记
	 * 
	 * @param request
	 * @param response
	 * @throws ServeletException
	 * @throws IOException
	 * */
	private void delDiary(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{
		// 获取要删除日记的ID
		int id = Integer.parseInt(request.getParameter("id"));
		String url = request.getParameter("url"); // 获取返回的URL地址
		int result = dao.delDiary(id); // 删除日记
		PrintWriter out = response.getWriter();
		if(result>0)
		{
			out.println("<script>window.location.href="
					+ "'DiaryServlet?action="+url+"';</script>");
			System.out.println("删除日记！");
		}else{
			out.println("<script>alert('删除日记失败，请稍后重试！');"
					+ "history.back();</script>");
		}
	}
	
	/*
	 * 功能：查询我的日记
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * */
	protected void listDiary(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{

		// 获取当前页码 strPage
		String strPage = (String)request.getParameter("Page");
		int Page = 1;
		List<Diary> list = null;
		if(strPage==null)
		{
			HttpSession session = request.getSession();
			// 获取用户ID号
			 int userid = Integer.parseInt(session.getAttribute("uid").toString());
			 System.out.println("GeUserID:"+userid);
			// sql:应用内联接查询日记信息
			String sql = "select d.*,u.username from tb_diary d inner "
					+ "join tb_user u on u.id=d.userid where d.userid="
					+userid+" order by d.writeTime DESC";	
			pagination = new MyPagination();
			list = dao.queryDiary(sql);		// 获取日记内容
			int  pagesize = 8;	// 指定每页显示的记录数
			list = pagination.getInitPage(list, Page, pagesize); // 初始化分页信息
			request.getSession().setAttribute("pagination", pagination); // 保存分页信息
		}else{
			pagination = (MyPagination)request.getSession().getAttribute("pagination");// 获取分页信息
			Page = pagination.getPage(strPage);
			list = pagination.getAppointPage(Page);	// 获取指定页数据
		}
		request.setAttribute("diaryList", list);	// 保存当前的日记信息
		request.setAttribute("Page", Page);		// 保存当前页码
		request.setAttribute("url", "listDiary");	// 保存当前的URL地址
		// 重定向页面到listAllDiary.jsp
		request.getRequestDispatcher("listDiary.jsp").forward(request, response);
	}
	/*
	 * 功能：保存日记至数据库
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * */
	public void save(HttpServletRequest request,HttpServletResponse
			response)throws ServletException,IOException
	{
		HttpSession session = request.getSession();
		Diary diary = new Diary();
		PrintWriter out = response.getWriter();
		// 设置日记各项内容
		 String string = request.getParameter("note");
		 if(string=="")
		 {
			 out.println("<script>alert('请输入日记');history.back();</script>");
		 }else{
			diary.setText(string.toString());
			diary.setWriteTime(new Timestamp(new Date().getTime()));
			diary.setUserid(Integer.parseInt(session.getAttribute("uid").toString()));
			diary.setUsername(session.getAttribute("userName").toString());
			// 保存日记
			int rtn = dao.saveDiary(diary);
			
			if(rtn>0)
			{
				listDiary(request, response);
				System.out.println("写日记！");
			}
			else{
				out.println("<script>alert('保存日记失败，请稍后重试！');"
						+ "history.back();</script>");
			}
		}			
	}

}
