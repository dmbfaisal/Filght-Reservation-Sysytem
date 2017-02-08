package Gen;



import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import support.MyConn;

public class BProcedure 
{
	

	public BProcedure(String a[], String b[]) 
	{
		Connection c= MyConn.connect();
		String card=JOptionPane.showInputDialog("Enter Card No. for Payment");
		System.out.println(card);
		//PreparedStatement ps= c.prepareStatement("insert into bookdata (name,flight,date,transid,cardno,passport) values (?,?,?,?,?,?) ");
				
		
	}

	public static void main(String[] args) 
	{
		new BProcedure(new String[]{"daad"}, new String[]{"daad"});

	}

}
