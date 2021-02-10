package com.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.AdminRegister;
import com.model.Register;

/**
 * Servlet implementation class AdminRegisterController
 */
@WebServlet("/AdminRegisterController")
public class AdminRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("saveserv1");
		String s1=request.getParameter("Admin_id");
		String s2=request.getParameter("Password");
		System.out.println("saveserv2");
		
		AdminRegister r=new AdminRegister();
		System.out.println("saveserv3");
		r.setAdmin_id(s1);
		r.setPassword(s2);
		
		
		System.out.println("saveserv4");
		
		RegisterDao db=new RegisterDao();
		List<AdminRegister> lst=new LinkedList<AdminRegister>();
		lst.add(r);
		System.out.println("test1");
		int i=db.saveDataAdmin(lst);
		System.out.println("test2 i value"+i);
		if(i>0)
		{
			System.out.println("test3");
			response.sendRedirect("AdminLog.jsp");
		}
		else{
			response.sendRedirect("ErrorPage.jsp");
		}
		System.out.println("test4");
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
