package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {
	private static String driverName = "com.mysql.jdbc.Driver";  
	private static String userName = "root";                      
	private static String userPwd = "12345678";                  
	private static String dbName = "students";                  
	  
	public static Connection getDBconnection(){
		String  url1="jdbc:mysql://localhost/"+dbName;
		String  url2 ="?user="+userName+"&password="+userPwd;
		String  url3="&useUnicode=true&characterEncoding=utf-8";
		String  url =url1+url2+url3;
		try{
		    Class.forName(driverName);		
		    Connection con=DriverManager.getConnection(url); 
		    return con;	   
	    }catch (Exception e) {			
			   e.printStackTrace();
		}
		return null;
    } 
	   
    public static void closeDB(Connection con,PreparedStatement  pstm, ResultSet rs){
 	   try{
 		   if(rs!=null) rs.close(); 
 		   if(pstm!=null) pstm.close();
		   if(con!=null) con.close();				 
	   }catch (SQLException e) {				
			e.printStackTrace();			
	   }
	}
}
