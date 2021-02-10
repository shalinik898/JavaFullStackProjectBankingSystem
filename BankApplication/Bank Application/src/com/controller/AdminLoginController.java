package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.AdminlLogin;
import com.model.Login;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("Admin_id");
		String s2=request.getParameter("Password");
		
		String str=null;
		
		AdminlLogin l=new AdminlLogin();
		l.setAdmin_id(s1);
		l.setPassword(s2);
		List<AdminlLogin>lst=new ArrayList<AdminlLogin>();
		lst.add(l);
		RegisterDao db=new RegisterDao();
		int i=db.Adminvalidatedata(lst);
		String a="Login successfully";
		if(i>0)
		{
			System.out.println("checked");
			response.sendRedirect("Home.jsp");
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
