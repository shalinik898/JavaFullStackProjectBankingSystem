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
import com.dao.Transferdao;
import com.model.Beneficiary;


/**
 * Servlet implementation class BeneficiaryController
 */
@WebServlet("/BeneficiaryController")
public class BeneficiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeneficiaryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String beneficiaryname=request.getParameter("beneficiaeryname");
		String beneficiaryaccno=request.getParameter("accno");
		String beneficiarybranch=request.getParameter("branch");
		String beneficiaryamount=request.getParameter("beneficiaryamount");
		
		Beneficiary b=new Beneficiary();
		
		b.setBeneficiaryname(beneficiaryname);
		b.setBeneficiaryaccno(beneficiaryaccno);
		b.setBeneficiarybranch(beneficiarybranch);
		b.setBeneficiaryamount(beneficiaryamount);
		
		List<Beneficiary> lst=new ArrayList<Beneficiary>();
		lst.add(b);
		
		Transferdao rd= new Transferdao();
		int i=rd.Savedata(lst);
		
		if(i>0)
		{
		
		response.sendRedirect("Intra.jsp");
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
