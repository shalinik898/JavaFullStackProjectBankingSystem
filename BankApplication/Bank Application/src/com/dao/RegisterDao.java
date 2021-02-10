package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.model.Address;
import com.model.AdminRegister;
import com.model.AdminlLogin;
import com.model.Login;
//import com.model.Address;
import com.model.Personal;
import com.model.Register;
import com.model.Search;
//import com.model.Search;
import com.model.Temporary;
import com.model.Upload;
//import com.model.Personal;
//import com.model.Upload;


public class RegisterDao {
	Connection con=null;
	PreparedStatement ps,ps2;
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
	public int PersonalData(List<Personal> lst){//inserting in table Applicant_personalinfo in database
		Personal r=lst.get(0);
		con=getConnection();
		int i=0;
		int cnt=0;
		
		try {
			
		ps=con.prepareStatement("insert into Applicant_personalinfo values(Bank1.NEXTVAL,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,r.getFirstname());
			ps.setString(2,r.getLastname());
			ps.setString(3, r.getFather_name());
			ps.setString(4,r.getMother_name());
			ps.setString(5, r.getDob());
			ps.setString(6, r.getGender());
			ps.setString(7, r.getOccuption());
			ps.setString(8, r.getMobile_no());
			
			ps.setString(9, r.getEmail_id());
			ps.setString(10,r.getAmount());
			i=ps.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0){
			cnt=1;
		}
		return cnt;
	}
	
	public int AddressData(List<Address> lst){//inserting in table Address in database
		Address r=lst.get(0);
		con=getConnection();
		int i=0;
		int cnt=0;
		
		try {
			ps=con.prepareStatement("insert into Address values(Bank2.NEXTVAL,?,?,?,?,?)");
			ps.setString(1,r.getHouse_no());
			ps.setString(2,r.getStreet());
			ps.setString(3,r.getCity());
			ps.setString(4,r.getPincode());
			ps.setString(5,r.getState());
			//ps.setDouble(3,r.getProdPrice());
			//ps.setInt(4,r.getProdQty());
			i=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0){
			cnt=1;
		}
		return cnt;
	}
	public int UploadData(List<Upload> lst){//insert into upload information
		Upload r=lst.get(0);
		con=getConnection();
		int i=0;
		int cnt=0;
		
		try {
			ps=con.prepareStatement("insert into Upload_Doc values(Bank3.nextval,?,?)");
			ps.setString(1,r.getAdhar_no());
			ps.setString(2,r.getPan_no());
			i=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0){
			cnt=1;
		}
		return cnt;
	}
	
	public int saveData(List<Register> lst)//inserting into register table function(user)
	{
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		Register a=lst.get(0);
		con=getConnection();
		try
		{
			//Iterator<Register> itr=lst.iterator();
		
			System.out.println("dbsave2");
			
			{
				System.out.println("dbsave3");
				//a=itr.next();
				ps=con.prepareStatement("insert into Register values(?,?,?,?,?,?,Registersequence.nextval)");
				ps.setString(1,a.getAccount_no());
				ps.setString(2,a.getFirstname());
				ps.setString(3,a.getLastname());
				ps.setString(4,a.getMobile_no());
				ps.setString(5,a.getUsername());
				ps.setString(6,a.getPassword());
				
				ps2=con.prepareStatement("insert into FinalTable select r.Account_no,a.F_name,a.L_name,a.Father_name,a.Mother_name,a.DOB,a.Gender,a.Occupation,a.Mobile_no,a.Email_id,a.Amount,b.House_no,b.Street,b.City,b.Pincode,b.State,c.Adhar_no ,c.PAN_no from Applicant_personalinfo a inner join Address b on a.sr_no=b.sr_no2 inner join Upload_Doc c on c.sr_no=b.sr_no2 inner join Register r on c.sr_no=r.sr_no3");
				
				
				i = ps.executeUpdate();
				i=ps2.executeUpdate();
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;
	}
	public List<Register> getAllData()
	{
		List<Register> lst=new LinkedList<Register>();
		con=getConnection();
		try
		{
		Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from Register");
			while(rs.next())
			{
				Register a=new Register();
				a.setAccount_no(rs.getString(1));
				a.setFirstname(rs.getString(2));
				a.setLastname(rs.getString(3));
				a.setMobile_no(rs.getString(4));
				a.setUsername(rs.getString(5));
				a.setPassword(rs.getString(6));
				
				lst.add(a);
				System.out.println("cnt");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	public int validatedata(List<Login>lst)//user login validation 
	{
		con=getConnection();
		int cnt=0;
		Login l=lst.get(0);
		int i=0;
		
		try{
			ps=con.prepareStatement("select* from Register where Username=? and Password=?");
			ps.setString(1,l.getUsername());
			ps.setString(2,l.getPassword());
			
			
			rs=ps.executeQuery();
			
			
			if(rs.next()){
				i=1;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(i>0){
			cnt=1;
		}
		return cnt;
		}
	public int saveDataAdmin(List<AdminRegister> lst)//admin Registration for creating new admin
	{
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		AdminRegister a=null;
		con=getConnection();
		try
		{
			Iterator<AdminRegister> itr=lst.iterator();
			System.out.println("dbsave2");
			while(itr.hasNext())
			{
				System.out.println("dbsave3");
				a=itr.next();
				ps=con.prepareStatement("insert into AdminRegister values(?,?)");
				ps.setString(1,a.getAdmin_id());
				ps.setString(2,a.getPassword());
				
				i = ps.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;
	}
	public int Adminvalidatedata(List<AdminlLogin>lst)//admin login validation 
	{
		con=getConnection();
		int cnt=0;
		AdminlLogin l=lst.get(0);
		int i=0;
		
		try{
			ps=con.prepareStatement("select* from AdminRegister where Admin_id=? and Password=?");
			ps.setString(1,l.getAdmin_id());
			ps.setString(2,l.getPassword());
			rs=ps.executeQuery();
			if(rs.next()){
				i=1;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(i>0){
			cnt=1;
		}
		return cnt;
		}
	public void insertintotemp(){
		con=getConnection();
		int i;
		try {
			ps=con.prepareStatement("insert into tempoTable select a.Sr_no,a.F_name,a.L_name,a.Father_name,a.Mother_name,a.DOB,a.Gender,a.Occupation,a.Mobile_no,a.Email_id,a.Amount,b.House_no,b.Street,b.City,b.Pincode,b.State,c.Adhar_no ,c.PAN_no from Applicant_personalinfo a inner join Address b on a.sr_no=b.sr_no2 inner join Upload_Doc c on c.sr_no=b.sr_no2");
			/*ps2=con.prepareStatement("insert into FinalTable select r.Account_no,a.Sr_no,a.F_name,a.L_name,a.Father_name,a.Mother_name,a.DOB,a.Gender,a.Occupation,a.Mobile_no,a.Email_id,a.Amount,b.House_no,b.Street,b.City,b.Pincode,b.State,c.Adhar_no ,c.PAN_no from Applicant_personal_info a inner join Address b on a.sr_no=b.sr_no2 inner join Upload_Doc c on c.sr_no=b.sr_no2 inner join Register r on c.sr_no=r.sr_no3");
			*/
			i=ps.executeUpdate();
			/*i=ps2.executeUpdate();*/
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Temporary> Displaydata()//admin display for approving
	{
		con=getConnection();
		List<Temporary> lst1=new ArrayList<Temporary>();
		try {
			Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select a.Sr_no,a.F_name,a.L_name,a.Father_name,a.Mother_name,a.DOB,a.Gender,a.occupation,a.mobile_no,a.Email_id,a.amount,b.House_no,b.Street,b.City,b.Pincode,b.State,c.Adhar_no ,c.PAN_no from Applicant_personalinfo a inner join Address b on a.sr_no=b.sr_no2 inner join Upload_Doc c on c.sr_no=b.sr_no2");
			while(rs.next())
			{
				Temporary a=new Temporary();
				a.setSr_no(rs.getInt(1));
				a.setFirstname(rs.getString(2));
				a.setLastname(rs.getString(3));
				a.setFather_name(rs.getString(4));
				a.setMother_name(rs.getString(5));
				a.setDob(rs.getString(6));
				a.setGender(rs.getString(7));
				a.setOccuption(rs.getString(8));
				a.setMobile_no(rs.getString(9));
				a.setEmail_id(rs.getString(10));
				a.setAmount(rs.getString(11));
				a.setHouse_no(rs.getString(12));
				a.setStreet(rs.getString(13));
				a.setCity(rs.getString(14));
				a.setState(rs.getString(15));
				a.setPincode(rs.getString(16));
				a.setAdhar_no(rs.getString(17));
				a.setPan_no(rs.getString(18));
				
				lst1.add(a);
				System.out.println("data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst1;
	}
	
	public int updatePassword(List<Register> lst) //for updating password 
	{
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		Register a=null;
		con=getConnection();
		try
		{
			Iterator<Register> itr=lst.iterator();
			System.out.println("dbsave2");
			while(itr.hasNext())
			{
				System.out.println("dbsave3");
				a=itr.next();
				ps=con.prepareStatement("update Register set Password=? where Username=?");
				ps.setString(1,a.getPassword());
				
				ps.setString(2,a.getUsername());
				
				i = ps.executeUpdate();
				//con.close();
			}
		}
		catch(Exception e)
		{
		System.out.println(e);
			//return i;
		}return i;
		/*finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;*/
		//return i;
	}
	/*public void insertfinal(){
		con=getConnection();
		int i;
		try {
			//ps=con.prepareStatement("insert into tempoTable select a.Sr_no,a.F_name,a.L_name,a.Father_name,a.Mother_name,a.DOB,a.Gender,a.Occupation,a.Mobile_no,a.Email_id,a.Amount,b.House_no,b.Street,b.City,b.Pincode,b.State,c.Adhar_no ,c.PAN_no from Applicant_personalinfo a inner join Address b on a.sr_no=b.sr_no2 inner join Upload_Doc c on c.sr_no=b.sr_no2");
			ps=con.prepareStatement("insert into FinalTable select r.Account_no,a.Sr_no,a.F_name,a.L_name,a.Father_name,a.Mother_name,a.DOB,a.Gender,a.Occupation,a.Mobile_no,a.Email_id,a.Amount,b.House_no,b.Street,b.City,b.Pincode,b.State,c.Adhar_no ,c.PAN_no from Applicant_personalinfo a inner join Address b on a.sr_no=b.sr_no2 inner join Upload_Doc c on c.sr_no=b.sr_no2 inner join Register r on c.sr_no=r.sr_no3");
			
			i=ps.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

	/*public List<Temporary> Profiledata1() {
		// TODO Auto-generated method stub
		con=getConnection();
		List<Temporary> lst1=new ArrayList<Temporary>();
		List<Register>  lst2=new ArrayList<Register>();
		try {
			Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("Select r.Account_no,t.F_name,t.L_name,t.Father_name,t.Mother_name,t.DOB,t.Gender,t.occuption,t.mobile_no,t.Email_id,t.amount,t.House_no,t.Street,t.City,t.Pincode,t.State,t.Adhar_no ,t.PAN_no from tempoTable t,Register r where t.Mobile_no in (select Mobile_no from Register where Mobile_no= ?)");
			while(rs.next())
			{
				Temporary a=new Temporary();
				Register r=new Register();
				r.setAccount_no(rs.getString(1));
				a.setFirstname(rs.getString(2));
				a.setLastname(rs.getString(3));
				a.setFather_name(rs.getString(4));
				a.setMother_name(rs.getString(5));
				a.setDob(rs.getString(6));
				a.setGender(rs.getString(7));
				a.setOccuption(rs.getString(8));
				a.setMobile_no(rs.getString(9));
				a.setEmail_id(rs.getString(10));
				a.setAmount(rs.getString(11));
				a.setHouse_no(rs.getString(12));
				a.setStreet(rs.getString(13));
				a.setCity(rs.getString(14));
				a.setState(rs.getString(15));
				a.setPincode(rs.getString(16));
				a.setAdhar_no(rs.getString(17));
				a.setPan_no(rs.getString(18));
				ps.setString(19,r.getMobile_no());
				lst2.add(r);
				lst1.add(a);
				System.out.println("data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst2;
		
	
		//return null;
	}*/
	public List<Temporary> Profiledata(List<Search> lst) {//showing particular user data for profile display
		// TODO Auto-generated method stub
		con=getConnection();
		Search s=lst.get(0);
		List<Temporary> lst1=new ArrayList<Temporary>();
		try {
			ps=con.prepareStatement("select * from FinalTable where Account_no=?");
			ps.setString(1, s.getAccount_no());
			rs=ps.executeQuery();
			if(rs.next())
			{
				Temporary a=new Temporary();
				a.setAccount_no(rs.getString(1));
				a.setFirstname(rs.getString(2));
				a.setLastname(rs.getString(3));
				a.setFather_name(rs.getString(4));
				a.setMother_name(rs.getString(5));
				a.setDob(rs.getString(6));
				a.setGender(rs.getString(7));
				a.setOccuption(rs.getString(8));
				a.setMobile_no(rs.getString(9));
				a.setEmail_id(rs.getString(10));
				a.setAmount(rs.getString(11));
				a.setHouse_no(rs.getString(12));
				a.setStreet(rs.getString(13));
				a.setCity(rs.getString(14));
				a.setState(rs.getString(15));
				a.setPincode(rs.getString(16));
				a.setAdhar_no(rs.getString(17));
				a.setPan_no(rs.getString(18));
				lst1.add(a);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst1;
		
		
	
		//return null;
	}

		
}	

	
	

	
	 
	 

