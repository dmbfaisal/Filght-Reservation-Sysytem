package Gen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import support.MyConn;

import javax.swing.table.DefaultTableModel;

public class ReservationHistory extends JDialog implements MouseListener
{
	JTable table;
	String user;

	public ReservationHistory(String user) 
	{
		setSize(1000,600);
		setTitle("Click the row to view complete details");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		this.user=user;
		
		
		String[] columns={"Flight No","Name","Passport No.","Date","Source","Destination","Time","Company","Class","Transaction ID","Card No.","Fare","Status"};
		int cnt=0,r=0,c=0;
		Connection con=MyConn.connect();
		String s="select * from reservations where account=?";
		try {
			
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1, user);
			ResultSet rs= ps.executeQuery();
			rs.last();//points to last row
			cnt=rs.getRow();//returns row no. at which pointer is(here it is at last row)
			rs.beforeFirst();//points to before first row
			String[][] data=new String[cnt][13];
			while(rs.next())
			{
				System.out.println("found reservation");
				data[r][c++]=rs.getString(1);
				data[r][c++]=rs.getString(2); 
				data[r][c++]=rs.getString(3); 
				data[r][c++]=rs.getString(4); 
				data[r][c++]=rs.getString(5); 
				data[r][c++]=rs.getString(6); 
				data[r][c++]=rs.getString(7);
				data[r][c++]=rs.getString(8);
				data[r][c++]=rs.getString(10);
				data[r][c++]=rs.getString(11);
				data[r][c++]=rs.getString(12);
				data[r][c++]=rs.getString(13);
				data[r][c++]=rs.getString(14);
				
				++r;
				c=0;
				
				
			}
			table=new JTable(data,columns);
			
			
			/*table.getColumnModel().getColumn(0).setMinWidth(100); 
			table.getColumnModel().getColumn(1).setMinWidth(100);
			table.getColumnModel().getColumn(2).setMinWidth(100);
			table.getColumnModel().getColumn(3).setMinWidth(100);
			table.getColumnModel().getColumn(4).setMinWidth(100);
			table.getColumnModel().getColumn(5).setMinWidth(100);
			table.getColumnModel().getColumn(6).setMinWidth(100);
			table.getColumnModel().getColumn(7).setMinWidth(100);
			table.getColumnModel().getColumn(8).setMinWidth(100);
			table.getColumnModel().getColumn(9).setMinWidth(100);
			table.getColumnModel().getColumn(10).setMinWidth(100);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			table.getColumnModel().getColumn(8).setPreferredWidth(100);
			table.getColumnModel().getColumn(9).setPreferredWidth(100);
			table.getColumnModel().getColumn(10).setPreferredWidth(100);*/
			
			
			
			JScrollPane jsp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setBounds(0,0,900,500);
			table.addMouseListener(this);
			getContentPane().add(jsp);
	}
		catch(Exception e)
		{
			
		}
		setVisible(true);

}
	public static void main(String a[])
	{
		new ReservationHistory("faisal");
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(table.getSelectedRow()>=0)
		{
			System.out.println(table.getSelectedRow());
			System.out.println(table.getModel().getValueAt(table.getSelectedRow(), 8).toString());
			new BookedFlight(table.getModel().getValueAt(table.getSelectedRow(), 9).toString(),user);
			dispose();
		}
			
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
