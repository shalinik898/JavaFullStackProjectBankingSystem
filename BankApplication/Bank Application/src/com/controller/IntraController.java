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
import com.model.Intra;

/**
 * Servlet implementation class IntraController
 */
@WebServlet("/IntraController")
public class IntraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntraController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String beneficiaryaccno=request.getParameter("beneficiaryaccno");
		String senderaccno=request.getParameter("senderaccno");
		String amount=request.getParameter("amount");
		String remark=request.getParameter("remark");
		String payment_date=request.getParameter("paymentdate");
		
		Intra j=new Intra();
		
		j.setBeneficiaryaccno(beneficiaryaccno);
		j.setSenderaccno(senderaccno);
		j.setAmount(amount);
		j.setRemark(remark);
		j.setPayment_date(payment_date);
		
		List<Intra> lst=new ArrayList<Intra>();
		lst.add(j);
		Transferdao rd= new Transferdao();
		rd.Savetransaction(lst);
		
		int i=rd.Updatedata(lst);
		
		if(i>0)
		{
		
		response.sendRedirect("Done.jsp");
		}
		else
			response.sendRedirect("ErrorPage.jsp");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
