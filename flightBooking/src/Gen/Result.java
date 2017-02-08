package Gen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import support.MyConn;
import support.ResTable;

public class Result extends JPanel implements ActionListener
{
	ResTable table;
	JScrollPane scroll ;
	String n[],p[];
	JButton b;
	

	public Result(int x, int y ,int width , int height) 
	{
		setLayout(null);
		setBounds(x, y, width, height);
		setSize(width,height);
		
		
		
		scroll = new JScrollPane();
		scroll.setSize(getWidth(),(int)( 0.8*getHeight()));
		
		//scroll.setSize((int)0.8*getWidth(), (int)0.8*getHeight());
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		 table= new ResTable();
		table.createTable();
		/*table.setCellSelectionEnabled(false);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);*/
		scroll.setViewportView(table);
		
		b= new JButton("Book");
		b.setBounds((getWidth()/2)-100,(int)((getHeight()*0.9)-45),100,50);
		b.addActionListener(this);
		
	}
	
	public static void main(String a[])
	{
	genID();
		
	}
	public static int genID()
	{
		int id=0;
		Connection c= MyConn.connect();
		try {
			PreparedStatement ps= c.prepareStatement("select max(transactionid) from reservations");
			ResultSet rs= ps.executeQuery();
			rs.next();
			id=Integer.parseInt(rs.getString(1));
			System.out.println("max id got="+id);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		id++;
		System.out.println("generating id");
		System.out.println(id);
		return id;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		
	}
	
	
	
	
	
}
