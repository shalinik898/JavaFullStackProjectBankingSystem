package com.controller;
import com.dao.RegisterDao;
import com.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminDisplayController
 */
@WebServlet("/AdminDisplayController")
public class AdminDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }
    List<Temporary> lst1=null;
   	public void init()
   	{
   		lst1=new ArrayList<Temporary>();
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterDao rd= new RegisterDao();
		lst1=rd.Displaydata();
		
		request.setAttribute("empList",lst1);
		RequestDispatcher view = request.getRequestDispatcher("AdminApproval.jsp");
		view.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
