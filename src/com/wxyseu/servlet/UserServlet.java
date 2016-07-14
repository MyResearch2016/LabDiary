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
		doPost(request, response);// 执行doPost()方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		if ("login".equals(action)) { // 用户登录
			this.login(request, response);
		} else if ("exit".equals(action)) {// 用户退出
			this.exit(request, response);
		} 
	}
	/**
	 * 功能：用户登录
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
		f.setUsername(request.getParameter("username")); // 获取并设置用户名
		f.setPwd(request.getParameter("pwd")); // 获取并设置密码
		int r = userDao.login(f);
		if (r > 0) {// 当用户登录成功时
			HttpSession session = request.getSession();
			session.setAttribute("userName", f.getUsername());// 保存用户名
			session.setAttribute("uid", r);// 保存用户ID
			System.out.println("登录成功！  UserName:"+f.getUsername()+" ;UserID:"+r+"。");  
			session.setAttribute("returnValue", "登录成功！");// 保存提示信息
			// request.getRequestDispatcher("listAllDiary.jsp").forward(request,response);// 重定向页面
			new DiaryServlet().listDiary(request, response);
		} else {// 当用户登录不成功时
			// request.setAttribute("returnValue", "您输入的用户名或密码错误，请重新输入！");
			request.getRequestDispatcher("index.html").forward(request,
					response);// 重定向页面
		}
	}
	/**
	 * 功能：用户退出
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
		HttpSession session = request.getSession();// 获取HttpSession的对象
		session.invalidate();// 销毁session
	}

}
