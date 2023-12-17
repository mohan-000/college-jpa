package com.pentagon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/re")
public class Login extends HttpServlet 
{
@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	String sid=req.getParameter("s");
	String pass=req.getParameter("p");
	
	Connection con=null;
	PreparedStatement pre=null;
	ResultSet re=null;
	
	String query="SELECT * FROM STUDENT WHERE SID=? AND PASSWORD=?";
	
	PrintWriter out= resp.getWriter();
	 try 
	 {
		con=Connector.requestConnection();
		pre=con.prepareStatement(query);
		
		int p1=Integer.parseInt(sid);
		pre.setInt(1, p1);
		pre.setString(2,pass);
		
		re=pre.executeQuery();
		if (re.next()) 
		{
			
			String name=re.getString(2);
			out.println("<html>"+"<body>"+"<h3>welcome"+" "+name+",</h3>"+"</body>"+"</html>");
		}
		else
		{
			RequestDispatcher f=req.getRequestDispatcher("invalid.html");
			f.include(req, resp);
		}
		
		
	} 
	 catch (Exception e) 
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
}
