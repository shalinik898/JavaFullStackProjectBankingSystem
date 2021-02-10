package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.dao.DBApplication;
import com.dao.RegisterDao;
import com.model.Login;

/**
 * 
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("Username");
		String s2=request.getParameter("Password");
		
		String str=null;
		
		Login l=new Login();
		l.setUsername(s1);
		l.setPassword(s2);
		List<Login>lst=new ArrayList<Login>();
		lst.add(l);
		RegisterDao db=new RegisterDao();
		int i=db.validatedata(lst);
		String a="";
		if(i>0)
		{
			//String a="Login Successfull";

			HttpSession session=request.getSession(true);
			session.setAttribute("data", a);
			System.out.println("checked");
			response.sendRedirect("Dashboard.jsp");
		}
		else
		{
			response.sendRedirect("ErrorPage.jsp");
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
