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
import com.model.Personal;
import com.model.Register;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Register n=new Register();
		n.setUsername(username);
		n.setPassword(password);
		
		System.out.println("entered to controller");
		
		System.out.println("entered to controller2");
		List<Register> lst=new ArrayList<Register>();
		lst.add(n);
		RegisterDao r=new RegisterDao();
		System.out.println("save 2");
		
		//RegisterDao r=new RegisterDao();
		
		//int i=r.updatePassword();
		int i=r.updatePassword(lst);
		
		if(i>0)
			response.sendRedirect("Dashboard.jsp");
		else
			response.sendRedirect("ErrorPage.jsp");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
