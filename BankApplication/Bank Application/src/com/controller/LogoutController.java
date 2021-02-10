package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("FirstPage.jsp").include(request,response);

		
		HttpSession session = request.getSession();
		
      
	
		
           // session.invalidate();
		
		
		/*Cookie ck=new Cookie("name","");
		ck.setMaxAge(0);
		response.addCookie(ck);
	*/	
         
        
        	
	 response.setHeader("Cache-Control","no-cache");
	 response.setHeader("Pragma","no-cache");
	 response.setDateHeader("Expires",0);
	 
	 ServletRequest session1 = null;
	if(session1.getAttribute("username")==null)
		response.sendRedirect("LoginPage.jsp");
	 	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
