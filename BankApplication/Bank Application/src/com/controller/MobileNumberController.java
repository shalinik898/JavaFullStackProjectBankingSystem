package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RegisterDao;
import com.model.Register;
import com.model.Search;
import com.model.Temporary;

/**
 * Servlet implementation class MobileNumberController
 */
@WebServlet("/MobileNumberController")
public class MobileNumberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileNumberController() {
        super();
        // TODO Auto-generated constructor stub
    }
   /* List<Temporary> lst1=null;
   	public void init()
   	{
   		lst1=new ArrayList<Temporary>();
   	}
   	List<Register> lst2=null;
   	public void init1()
   	{
   		lst2=new ArrayList<Register>();
   	}*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String account_no=request.getParameter("Account_no");
		//int no =Integer.parseInt(s1);
		//String pass=request.getParameter("pass");
		
	Search	s=new Search();
		
		s.setAccount_no(account_no);
		//s.setPass(pass);
		
		List<Search> lst=new ArrayList<Search>();
		lst.add(s);
		
		RegisterDao rd= new RegisterDao();
		List<Temporary> lst1=rd.Profiledata(lst);
		
		PrintWriter pw=response.getWriter();
		Temporary r =new Temporary();
		r=lst1.get(0);
		
		
		HttpSession session=request.getSession(true);
		session.setAttribute("data", r);
		response.sendRedirect("Profile.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
