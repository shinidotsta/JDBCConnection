package jdbc;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Statement;

import java.sql.Connection;

public class ConnectionManager {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub

		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");  
		
		if (con != null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("not Connected");
		}
		
	}
	
	

}
