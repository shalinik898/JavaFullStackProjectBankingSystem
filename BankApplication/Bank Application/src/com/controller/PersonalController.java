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
 * Servlet implementation class PersonalController
 */
@WebServlet("/PersonalController")
public class PersonalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int sr_no=Integer.parseInt(request.getParameter("sr_no"));
		
		String firstname=request.getParameter("F_name");
		String lastname=request.getParameter("L_name");
		String father_name=request.getParameter("Father_name");
		String mother_name=request.getParameter("Mother_name");
		String occuption=request.getParameter("Occuption");
		String dob=request.getParameter("DOB");
		String mobile_no=request.getParameter("Mobile_no");
		String email_id=request.getParameter("Email_id");
		String amount=request.getParameter("amount");
		String gender=request.getParameter("Gender");
		/*String House_no=request.getParameter("House_no");
		String Street=request.getParameter("Street");
		String City=request.getParameter("City");
		String Pincode=request.getParameter("Pincode");
		String State=request.getParameter("State");*/
		
		
		
		
		System.out.println("save 1");
		
		
		Personal p=new Personal();
		//p.setsr_no(sr_no);
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setFather_name(father_name);
		p.setMother_name(mother_name);
		p.setDob(dob);
		p.setGender(gender);
		p.setMobile_no(mobile_no);
		p.setOccuption(occuption);
		p.setEmail_id(email_id);
		p.setAmount(amount);
		/*p.setHouse_no(House_no);
		p.setStreet(Street);
		p.setCity(City);
		p.setPincode(Pincode);
		p.setState(State);*/
	
		
		List<Personal> lst=new ArrayList<Personal>();
		lst.add(p);
		System.out.println("save 2");
		
		RegisterDao r=new RegisterDao();
		int i=r.PersonalData(lst);
		
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
