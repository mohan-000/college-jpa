package com.ps.validation;

import java.sql.*;
import java.util.*;
public class Login {
public static void main(String[] args) throws SQLException {
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ft=null;
	String query="SELECT * FROM STUDENT WHERE NAME=? AND PASSWORD=?";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/COLLEGE?"+"user=root&password=simmy");
		 ft= con.prepareStatement(query);
		 System.out.println("login portal");
		 System.out.println("enter the student id");
Scanner scan=new Scanner(System.in);
String id=scan.next();
ft.setString(1,id);
System.out.println("enter the password");
String password=scan.next();
ft.setString(2, password);
 rs=ft.executeQuery();
if(rs.next()) {
	String name=rs.getString(1);
	long phonenumber=rs.getLong(2);
	String emailid=rs.getString(3);
	String location=rs.getString(4);
	String branch=rs.getString(5);
	System.out.println("welcome"+name+",");
	System.out.println("your phone number"+phonenumber+',');
    System.out.println("your emaidid"+emailid+',');
    System.out.println("your location"+location+',');
    System.out.println("your branch"+branch+',');

}
else {
	System.out.println("incorrect id password");
	
}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			if(rs!=null)rs.close();
			if(ft!=null)ft.close();
			if(con!=null)con.close();

		}
		catch(Exception e) {
			e.printStackTrace();

		}
	}
}
}
