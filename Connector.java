package com.pentagon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
static Connection requestConnection()throws ClassCastException,SQLException, ClassNotFoundException{
Connection con=null;
String url="jdbc:mysql://localhost:3306/college";
String user="root";       
String pass="simmy";
Class.forName("com.mysql.cj.jdbc.Driver");
 con =DriverManager.getConnection(url,user,pass);
return con;
}
}
