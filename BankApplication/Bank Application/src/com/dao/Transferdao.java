package com.dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;

import com.model.Beneficiary;
import com.model.Intra;
//import com.model.Sender;


public class Transferdao {
	Connection con=null;
	PreparedStatement ps,ps1;
	ResultSet rs=null;
	public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Mrunmayi");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	/*public int Save_data(List<Sender> lst)
	{
		con=getConnection();
		int cnt=0;
		Sender s=lst.get(0);
		int i=0;
		
		try {
			ps=con.prepareStatement("insert into Sender_table values(?,?,?,?)");
			ps.setString(1,s.getSendername());
			ps.setString(2, s.getSenderaccno());
			ps.setString(3,s.getSenderbranch());
			ps.setString(4,s.getSenderamount());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0)
		{
			cnt=1;
		}
		return cnt;
	}*/
	
	public int Savedata(List<Beneficiary> lst)
	{
		con=getConnection();
		int cnt=0;
		Beneficiary b=lst.get(0);
		int i=0;
		
		try {
			ps=con.prepareStatement("insert into Beneficiary_table(Name,Account_no,Branch) values(?,?,?)");
			ps.setString(1, b.getBeneficiaryname());
			ps.setString(2, b.getBeneficiaryaccno());
			ps.setString(3,b.getBeneficiarybranch());
			//ps.setString(4, b.getBeneficiaryamount());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0)
		{
			cnt=1;
		}
		return cnt;
		
	}
	
	public void Savetransaction(List<Intra> lst)
	{
		con=getConnection();
		int cnt=0;
		Intra j=lst.get(0);
		int i=0;
		
		try {
			ps=con.prepareStatement("insert into Transfer_table values(?,?,?,?,?)");
			ps.setString(1, j.getBeneficiaryaccno());
			ps.setString(2, j.getSenderaccno());
			ps.setString(3,j.getAmount());
			ps.setString(4,j.getRemark());
			ps.setString(5,j.getPayment_date());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int Updatedata(List<Intra> lst)
	{ 
		con=getConnection();
		int cnt=0;
		Intra j=lst.get(0);
		int i=0;
		int k=0;
		try {
			ps=con.prepareStatement("update Beneficiary_table set BeneficiaryAmount=BeneficiaryAmount+? where Account_no = ?");
			ps.setString(1,j.getAmount());
			ps.setString(2, j.getBeneficiaryaccno());
			
			
			ps1=con.prepareStatement("update FinalTable set Amount =Amount-? where Account_no = ?");
			ps1.setString(1,j.getAmount());
			ps1.setString(2, j.getSenderaccno());
			
			i=ps.executeUpdate();
			k=ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0)
		{
			cnt=1;
		}
		return cnt;
		
	}

		

}
