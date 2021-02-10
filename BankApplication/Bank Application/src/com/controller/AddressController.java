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
import com.model.Personal;

/**
 * Servlet implementation class AddressController
 */
@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String house_no=request.getParameter("House_no");
		String street=request.getParameter("Street");
		String city=request.getParameter("City");
		String pincode=(request.getParameter("Pincode"));
		String state=request.getParameter("State");
		
		Address a=new Address();
		a.setHouse_no(house_no);
		a.setStreet(street);
		a.setCity(city);
		a.setPincode(pincode);
		a.setState(state);
		
		List<Address> lst=new ArrayList<Address>();
		lst.add(a);
		System.out.println("save 2");
		
		RegisterDao r=new RegisterDao();
		int i=r.AddressData(lst);
		
		if(i>0)
			response.sendRedirect("OpenAcc.jsp");
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
