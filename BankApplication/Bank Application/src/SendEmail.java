
//import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Upload;
//import java.util.Random;
/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }
   /* public class Account_NoDao
    {
    	Connection con=null;
    	PreparedStatement ps;
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
    	public int AccountNo_generator(){
    		//Upload r=lst.get(0);
    		con=getConnection();
    		int i=0;
    		int cnt=0;
    		
    		try {
    			ps=con.prepareStatement("insert into Accountno_Table values(Bank4.nextval,Account_no.nextval)");
    			//ps.setString(1,r.getAdhar_no());
    			//ps.setString(2,r.getPAN_no());
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
    	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		Connection con=null;
    	PreparedStatement ps;
    	ResultSet rs=null;
    	//public Connection getConnection(){
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
		
		
    		//con=getConnection();
    		int i=0;
    		int cnt=0;
    		
    		try {
    			ps=con.prepareStatement("insert into Accountno_Table values(Bank4.nextval,Account_no.nextval)");
    			//ps.setString(1,r.getAdhar_no());
    			//ps.setString(2,r.getPAN_no());
    			i=ps.executeUpdate();
    			con.close();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		if(i>0){
    			cnt=1;
    		}

		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    
	   
	    //HelloWorld h=new HelloWorld(); 
	    String to= ;
	    String subject="Account is approved in Bank"; 
	    
	    String sqlIdentifier="select Account_number.nextVal from dual";

	    try {
			ps=con.prepareStatement("sqlIdentifier");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String message="Your account number is :"+sqlIdentifier;
	    
	    Mailer.send(to, subject,sqlIdentifier );  
	    out.print("message has been sent successfully");  
	    out.close();  
	    }  
    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
