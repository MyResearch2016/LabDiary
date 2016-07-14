package com.wxyseu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.wxyseu.dao.UserDao;
import com.wxyseu.model.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
        userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);// ִ��doPost()����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		if ("login".equals(action)) { // �û���¼
			this.login(request, response);
		} else if ("exit".equals(action)) {// �û��˳�
			this.exit(request, response);
		} 
	}
	/**
	 * ���ܣ��û���¼
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User f = new User();
		f.setUsername(request.getParameter("username")); // ��ȡ�������û���
		f.setPwd(request.getParameter("pwd")); // ��ȡ����������
		int r = userDao.login(f);
		if (r > 0) {// ���û���¼�ɹ�ʱ
			HttpSession session = request.getSession();
			session.setAttribute("userName", f.getUsername());// �����û���
			session.setAttribute("uid", r);// �����û�ID
			System.out.println("��¼�ɹ���  UserName:"+f.getUsername()+" ;UserID:"+r+"��");  
			session.setAttribute("returnValue", "��¼�ɹ���");// ������ʾ��Ϣ
			// request.getRequestDispatcher("listAllDiary.jsp").forward(request,response);// �ض���ҳ��
			new DiaryServlet().listDiary(request, response);
		} else {// ���û���¼���ɹ�ʱ
			// request.setAttribute("returnValue", "��������û���������������������룡");
			request.getRequestDispatcher("index.html").forward(request,
					response);// �ض���ҳ��
		}
	}
	/**
	 * ���ܣ��û��˳�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.html").forward(request, response);
		HttpSession session = request.getSession();// ��ȡHttpSession�Ķ���
		session.invalidate();// ����session
	}

}
