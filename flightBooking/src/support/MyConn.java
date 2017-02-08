package support;

import java.sql.*;

public class MyConn 
{
	static Connection c;
	static ResultSet rs;
	

	public MyConn() 
	{

	}
	public static Connection connect()
	{
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","12345");
			System.out.println("Connected");
			
		} catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	
	/*public static ResultSet UpdateQuery(Connection c, String query)
	{
		try {
			PreparedStatement ps =c.prepareStatement(query);
		    ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}*/

	
	public static void createtable(String t)
	{
		try {
			
			Connection c1=MyConn.connect();
			
			String user= t;
			PreparedStatement ps1= c1.prepareStatement("create table "+user+" (fno integer not null , cardno varchar(25) not null , trano varchar(20) not null , date varchar(20) not null , status integer not null , primary key(trano)) ");
			ps1.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
