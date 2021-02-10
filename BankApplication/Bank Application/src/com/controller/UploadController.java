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
import com.model.Address;
import com.model.Upload;

/**
 * Servlet implementation class UploadController
 */
@WebServlet("/UploadController")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Adhar_no=(request.getParameter("Adhar_no"));
		String  PAN_no=(request.getParameter("PAN_no"));
		
		Upload u=new Upload();
		u.setAdhar_no(Adhar_no);
		u.setPan_no(PAN_no);
		
		List<Upload> lst=new ArrayList<Upload>();
		lst.add(u);
		System.out.println("save 3");
		
		RegisterDao r=new RegisterDao();
		int i=r.UploadData(lst);
		
		if(i>0)
		{
			r.insertintotemp();
			response.sendRedirect("FirstPage.jsp");
		}
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
