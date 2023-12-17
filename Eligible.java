
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
@WebServlet("/Eligible")
public class Eligible extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String ss=req.getParameter("sid");
	String pp=req.getParameter("password");
	Connection con=null;
	PreparedStatement pre=null;
	ResultSet re=null;
	String query="SELECT * FROM MARKS WHERE ss=? pp=?";
	int p1=Integer.parseInt(ss);
	int p2=Integer.parseInt(pp);
	PrintWriter out= resp.getWriter();
	 try {
		 con=Connector.requestConnection();
		pre=con.prepareStatement(query);
		pre.setInt(1, p1);
		pre.setInt(2,p2);
		re=pre.executeQuery();
		if (re.next()) {
			
			String name=re.getString(p2);
			out.println("<html>"+"<body>"+"<h3>welcome"+" "+name+",</h3>"+"<body>"+"</html>");
		}
		else {
			RequestDispatcher f=req.getRequestDispatcher("Eligible");
			f.include(req, resp);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassCastException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
