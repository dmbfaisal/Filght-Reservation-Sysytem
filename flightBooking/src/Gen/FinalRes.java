package Gen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import support.MyConn;

public class FinalRes extends JDialog
{
	private JTable table;
	public FinalRes(String a[][],int p)
	{
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		String columns[]= new String[]{"Flight No.","Name","Passport No.","Date","Source","Destination","Time","Company","Class","Account","Transaction ID","Card no.","Fare"};
		table = new JTable(a,columns);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane scroll =  new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		add(scroll);
		
		getContentPane().add(scroll);
		setSize(1200,600);
		
		Connection c= MyConn.connect();
		try {
			PreparedStatement ps= c.prepareStatement("insert into reservations values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for (int i = 0; i < p; i++)
			{
				ps.setInt( 1,Integer.parseInt(a[i][0]));
				ps.setString(2,a[i][1]);
				ps.setString(3,a[i][2]);
				ps.setString(4,a[i][3]);
				ps.setString(5,a[i][4]);
				ps.setString(6,a[i][5]);
				ps.setString(7,a[i][6]);
				ps.setString(8,a[i][7]);
				ps.setString(9,a[i][8]);
				ps.setString(10,a[i][9]);
				ps.setInt(11,Integer.parseInt(a[i][10]));
				ps.setString(12,a[i][11]);
				ps.setString(13,a[i][12]);
				ps.setString(14, "Booked");
				ps.executeUpdate();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		
		setVisible(true);
		
		
	}
	
	
}
