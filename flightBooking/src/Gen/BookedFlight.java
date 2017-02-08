package Gen;

import javax.swing.JDialog;

import support.DValid;
import support.MyConn;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookedFlight extends JDialog implements ActionListener
{
	private JTextField fno;
	private JTextField src;
	private JTextField dest;
	private JTextField comp;
	private JTextField clss;
	private JTextField date;
	private JTextField tranid;
	private JTextField fare;
	JButton cancel;
	private JTextField name;
	private JTextField Pno;
	private JTextField time;
	int transactionid;
	private String user;

	public BookedFlight(String transaction) 
	{
		getContentPane().setLayout(null);
		setTitle("Booking Details of Transaction ID: "+transaction);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		transactionid=Integer.parseInt(transaction);
		
		JLabel label = new JLabel("Flight Number");
		label.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label.setBounds(76, 63, 106, 39);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Source");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_1.setBounds(76, 219, 106, 39);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Destination");
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_2.setBounds(76, 271, 106, 39);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Company");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_3.setBounds(76, 323, 106, 39);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Class");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_4.setBounds(76, 375, 106, 39);
		getContentPane().add(label_4);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDate.setBounds(76, 422, 106, 39);
		getContentPane().add(lblDate);
		
		JLabel label_5 = new JLabel("Fare");
		label_5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_5.setBounds(76, 572, 106, 39);
		getContentPane().add(label_5);
		
		JLabel lblTransactionId = new JLabel("Transaction ID");
		lblTransactionId.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTransactionId.setBounds(76, 520, 106, 39);
		getContentPane().add(lblTransactionId);
		
		cancel = new JButton("Cancel Ticket");
		cancel.setBounds(281, 632, 129, 39);
		getContentPane().add(cancel);
		
		fno = new JTextField();
		fno.setBounds(378, 72, 159, 22);
		getContentPane().add(fno);
		fno.setColumns(10);
		
		src = new JTextField();
		src.setColumns(10);
		src.setBounds(378, 228, 159, 22);
		getContentPane().add(src);
		
		dest = new JTextField();
		dest.setColumns(10);
		dest.setBounds(378, 280, 159, 22);
		getContentPane().add(dest);
		
		comp = new JTextField();
		comp.setColumns(10);
		comp.setBounds(378, 332, 159, 22);
		getContentPane().add(comp);
		
		clss = new JTextField();
		clss.setColumns(10);
		clss.setBounds(378, 384, 159, 22);
		getContentPane().add(clss);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(378, 431, 159, 22);
		getContentPane().add(date);
		
		tranid = new JTextField();
		tranid.setColumns(10);
		tranid.setBounds(378, 529, 159, 22);
		getContentPane().add(tranid);
		
		fare = new JTextField();
		fare.setColumns(10);
		fare.setBounds(378, 581, 159, 22);
		getContentPane().add(fare);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblName.setBounds(76, 115, 106, 39);
		getContentPane().add(lblName);
		
		JLabel lblPassportNo = new JLabel("Passport No.");
		lblPassportNo.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPassportNo.setBounds(76, 167, 106, 39);
		getContentPane().add(lblPassportNo);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(378, 124, 159, 22);
		getContentPane().add(name);
		
		Pno = new JTextField();
		Pno.setColumns(10);
		Pno.setBounds(378, 176, 159, 22);
		getContentPane().add(Pno);
		
		time = new JTextField();
		time.setEditable(false);
		time.setColumns(10);
		time.setBounds(378, 477, 159, 22);
		getContentPane().add(time);
		
		setSize(800, 742);
		int f=0;
		Connection c= MyConn.connect();
		try {
			PreparedStatement ps= c.prepareStatement("select * from reservations where transactionid=?");
			ps.setString(1,transaction);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				f=1;
				fno.setText(rs.getString(1));
				name.setText(rs.getString(2));
				Pno.setText(rs.getString(3));
				date.setText(rs.getString(4));

				src.setText(rs.getString(5));
				dest.setText(rs.getString(6));
				time.setText(rs.getString(7));
				comp.setText(rs.getString(8));
				clss.setText(rs.getString(9));
				tranid.setText(rs.getString(11));
				fare.setText(rs.getString(13));
				cancel.addActionListener(this);
				if(rs.getString("status").equals("Cancelled"))
				{
					cancel.setEnabled(false);
				}
				
				String date=rs.getString("date");
				String time=rs.getString("time");
				
				int p=date.indexOf(" ");
				String d=date.substring(0,p);
				date=date.substring(p+1);
				p=date.indexOf(" ");
				String m=d=date.substring(0,p);
				date=date.substring(p+1);
				
				String y=date.substring(0);
				
				p=time.indexOf(":");
				String h=time.substring(0,p);
				String mm=time.substring(p+1);
				System.out.println(d+" "+m+" "+y+" "+h+" "+mm+" ");
				System.out.println(DValid.getDateValidity(d,m,y));
				System.out.println(DValid.getHoursValidity(h, mm));

				if(!((DValid.getDaysDifference(d, m, y)>0)||( DValid.getDaysDifference(d, m, y)==0 && DValid.getHoursValidity(h, mm))))
				{
					cancel.setEnabled(false);
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		fno.setEditable(false);
		name.setEditable(false);
		Pno.setEditable(false);
		date.setEditable(false);
		src.setEditable(false);
		dest.setEditable(false);
		comp.setEditable(false);
		clss.setEditable(false);
		tranid.setEditable(false);
		fare.setEditable(false);
		time.setEditable(false);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTime.setBounds(76, 468, 106, 39);
		getContentPane().add(lblTime);
		
		
		
		if(f==1)
		{
			setVisible(true);
		}
		else
		{
			dispose();
		}
			
		
		
	}
	
	public BookedFlight(String transaction ,String user) 
	{
		getContentPane().setLayout(null);
		setTitle("Booking Details of Transaction ID: "+transaction);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		transactionid=Integer.parseInt(transaction);
		this.user=user;
		
		
		JLabel label = new JLabel("Flight Number");
		label.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label.setBounds(76, 63, 106, 39);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Source");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_1.setBounds(76, 219, 106, 39);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Destination");
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_2.setBounds(76, 271, 106, 39);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Company");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_3.setBounds(76, 323, 106, 39);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Class");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_4.setBounds(76, 375, 106, 39);
		getContentPane().add(label_4);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDate.setBounds(76, 422, 106, 39);
		getContentPane().add(lblDate);
		
		JLabel label_5 = new JLabel("Fare");
		label_5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_5.setBounds(76, 572, 106, 39);
		getContentPane().add(label_5);
		
		JLabel lblTransactionId = new JLabel("Transaction ID");
		lblTransactionId.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTransactionId.setBounds(76, 520, 106, 39);
		getContentPane().add(lblTransactionId);
		
		cancel = new JButton("Cancel Ticket");
		cancel.setBounds(281, 632, 129, 39);
		getContentPane().add(cancel);
		
		fno = new JTextField();
		fno.setBounds(378, 72, 159, 22);
		getContentPane().add(fno);
		fno.setColumns(10);
		
		src = new JTextField();
		src.setColumns(10);
		src.setBounds(378, 228, 159, 22);
		getContentPane().add(src);
		
		dest = new JTextField();
		dest.setColumns(10);
		dest.setBounds(378, 280, 159, 22);
		getContentPane().add(dest);
		
		comp = new JTextField();
		comp.setColumns(10);
		comp.setBounds(378, 332, 159, 22);
		getContentPane().add(comp);
		
		clss = new JTextField();
		clss.setColumns(10);
		clss.setBounds(378, 384, 159, 22);
		getContentPane().add(clss);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(378, 431, 159, 22);
		getContentPane().add(date);
		
		tranid = new JTextField();
		tranid.setColumns(10);
		tranid.setBounds(378, 529, 159, 22);
		getContentPane().add(tranid);
		
		fare = new JTextField();
		fare.setColumns(10);
		fare.setBounds(378, 581, 159, 22);
		getContentPane().add(fare);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblName.setBounds(76, 115, 106, 39);
		getContentPane().add(lblName);
		
		JLabel lblPassportNo = new JLabel("Passport No.");
		lblPassportNo.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPassportNo.setBounds(76, 167, 106, 39);
		getContentPane().add(lblPassportNo);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(378, 124, 159, 22);
		getContentPane().add(name);
		
		Pno = new JTextField();
		Pno.setColumns(10);
		Pno.setBounds(378, 176, 159, 22);
		getContentPane().add(Pno);
		
		time = new JTextField();
		time.setEditable(false);
		time.setColumns(10);
		time.setBounds(378, 477, 159, 22);
		getContentPane().add(time);
		
		setSize(800, 742);
		int f=0;
		Connection c= MyConn.connect();
		try {
			PreparedStatement ps= c.prepareStatement("select * from reservations where transactionid=?");
			ps.setString(1,transaction);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				f=1;
				fno.setText(rs.getString(1));
				name.setText(rs.getString(2));
				Pno.setText(rs.getString(3));
				date.setText(rs.getString(4));

				src.setText(rs.getString(5));
				dest.setText(rs.getString(6));
				time.setText(rs.getString(7));
				comp.setText(rs.getString(8));
				clss.setText(rs.getString(9));
				tranid.setText(rs.getString(11));
				fare.setText(rs.getString(13));
				cancel.addActionListener(this);
				if(rs.getString("status").equals("Cancelled"))
				{
					cancel.setEnabled(false);
				}
				
				String date=rs.getString("date");
				String time=rs.getString("time");
				System.out.println(date);
				System.out.println(time);
				
				int p=date.indexOf(" ");
				String d=date.substring(0,p);
				
				date=date.substring(p+1);
				p=date.indexOf(" ");
				String m=date.substring(0,p);
				date=date.substring(p+1);
				
				String y=date.substring(0);
				
				p=time.indexOf(":");
				String h=time.substring(0,p);
				String mm=time.substring(p+1);
				System.out.println(d+" "+m+" "+y+" "+h+" "+mm+" ");
				System.out.println(DValid.getDateValidity(d,m,y));
				System.out.println(DValid.getHoursValidity(h, mm));

				if(!((DValid.getDaysDifference(d, m, y)>0)||( DValid.getDaysDifference(d, m, y)==0 && DValid.getHoursValidity(h, mm))))
				{
					cancel.setEnabled(false);
				}
					
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		fno.setEditable(false);
		name.setEditable(false);
		Pno.setEditable(false);
		date.setEditable(false);
		src.setEditable(false);
		dest.setEditable(false);
		comp.setEditable(false);
		clss.setEditable(false);
		tranid.setEditable(false);
		fare.setEditable(false);
		time.setEditable(false);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTime.setBounds(76, 468, 106, 39);
		getContentPane().add(lblTime);
		
		
		
		if(f==1)
		{
			setVisible(true);
		}
		else
		{
			dispose();
		}
			
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		Connection c=MyConn.connect();
		try 
		{
			
			
			PreparedStatement ps1= c.prepareStatement("update reservations set status='Cancelled' where transactionid=?  ");
			ps1.setInt(1,transactionid );
			ps1.executeUpdate();
			} 
			catch (SQLException e1) {
	
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Ticket Cancelled");
				dispose();
				new ReservationHistory(user);
		
	}
	public static void main(String a[])
	{
		new BookedFlight("4");
	}
}
