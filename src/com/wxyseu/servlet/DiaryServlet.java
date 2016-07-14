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
    
	MyPagination pagination = null;  // ���ݷ�ҳ��Ķ���
	DiaryDao dao = null;	// �ռ���ص����ݿ����
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
        dao = new DiaryDao();	// ʵ�����ռ���ص����ݿ������Ķ���
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	// ִ��doPost()����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("publish".equals(action))
			save(request,response);	// �����������ռ�
		else if("listDiary".equals(action))
			listDiary(request,response);	// ��ѯ�ҵ��ռ�
		else if("delDiary".equals(action))
			delDiary(request,response);		// ɾ���ҵ��ռ�
	}
	
	/*
	 * ���ܣ�ɾ���ռ�
	 * 
	 * @param request
	 * @param response
	 * @throws ServeletException
	 * @throws IOException
	 * */
	private void delDiary(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{
		// ��ȡҪɾ���ռǵ�ID
		int id = Integer.parseInt(request.getParameter("id"));
		String url = request.getParameter("url"); // ��ȡ���ص�URL��ַ
		int result = dao.delDiary(id); // ɾ���ռ�
		PrintWriter out = response.getWriter();
		if(result>0)
		{
			out.println("<script>window.location.href="
					+ "'DiaryServlet?action="+url+"';</script>");
			System.out.println("ɾ���ռǣ�");
		}else{
			out.println("<script>alert('ɾ���ռ�ʧ�ܣ����Ժ����ԣ�');"
					+ "history.back();</script>");
		}
	}
	
	/*
	 * ���ܣ���ѯ�ҵ��ռ�
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * */
	protected void listDiary(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{

		// ��ȡ��ǰҳ�� strPage
		String strPage = (String)request.getParameter("Page");
		int Page = 1;
		List<Diary> list = null;
		if(strPage==null)
		{
			HttpSession session = request.getSession();
			// ��ȡ�û�ID��
			 int userid = Integer.parseInt(session.getAttribute("uid").toString());
			 System.out.println("GeUserID:"+userid);
			// sql:Ӧ�������Ӳ�ѯ�ռ���Ϣ
			String sql = "select d.*,u.username from tb_diary d inner "
					+ "join tb_user u on u.id=d.userid where d.userid="
					+userid+" order by d.writeTime DESC";	
			pagination = new MyPagination();
			list = dao.queryDiary(sql);		// ��ȡ�ռ�����
			int  pagesize = 8;	// ָ��ÿҳ��ʾ�ļ�¼��
			list = pagination.getInitPage(list, Page, pagesize); // ��ʼ����ҳ��Ϣ
			request.getSession().setAttribute("pagination", pagination); // �����ҳ��Ϣ
		}else{
			pagination = (MyPagination)request.getSession().getAttribute("pagination");// ��ȡ��ҳ��Ϣ
			Page = pagination.getPage(strPage);
			list = pagination.getAppointPage(Page);	// ��ȡָ��ҳ����
		}
		request.setAttribute("diaryList", list);	// ���浱ǰ���ռ���Ϣ
		request.setAttribute("Page", Page);		// ���浱ǰҳ��
		request.setAttribute("url", "listDiary");	// ���浱ǰ��URL��ַ
		// �ض���ҳ�浽listAllDiary.jsp
		request.getRequestDispatcher("listDiary.jsp").forward(request, response);
	}
	/*
	 * ���ܣ������ռ������ݿ�
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
		// �����ռǸ�������
		 String string = request.getParameter("note");
		 if(string=="")
		 {
			 out.println("<script>alert('�������ռ�');history.back();</script>");
		 }else{
			diary.setText(string.toString());
			diary.setWriteTime(new Timestamp(new Date().getTime()));
			diary.setUserid(Integer.parseInt(session.getAttribute("uid").toString()));
			diary.setUsername(session.getAttribute("userName").toString());
			// �����ռ�
			int rtn = dao.saveDiary(diary);
			
			if(rtn>0)
			{
				listDiary(request, response);
				System.out.println("д�ռǣ�");
			}
			else{
				out.println("<script>alert('�����ռ�ʧ�ܣ����Ժ����ԣ�');"
						+ "history.back();</script>");
			}
		}			
	}

}
