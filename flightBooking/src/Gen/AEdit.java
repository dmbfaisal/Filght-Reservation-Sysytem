package Gen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import support.MyConn;

public class AEdit extends JDialog implements ActionListener 
{
	private JTextField line1;
	private JTextField line2;
	private JTextField state;
	private JTextField city;
	private JTextField zip;
	JButton update;
	String user;
	Connection c;

	public AEdit(String u) 
	{
		user=u;
		getContentPane().setLayout(null);
		setTitle("Update Address!");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JLabel label = new JLabel("Line1");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(33, 48, 88, 33);
		getContentPane().add(label);
		
		JLabel lblLine = new JLabel("Line2");
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLine.setBounds(33, 110, 94, 33);
		getContentPane().add(lblLine);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblState.setBounds(33, 171, 88, 33);
		getContentPane().add(lblState);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCity.setBounds(33, 235, 88, 33);
		getContentPane().add(lblCity);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblZipCode.setBounds(33, 307, 88, 33);
		getContentPane().add(lblZipCode);
		
		line1 = new JTextField();
		line1.setColumns(10);
		line1.setBounds(133, 55, 339, 22);
		getContentPane().add(line1);
		
		line2 = new JTextField();
		line2.setColumns(10);
		line2.setBounds(133, 117, 339, 22);
		getContentPane().add(line2);
		
		state = new JTextField();
		state.setColumns(10);
		state.setBounds(133, 178, 188, 22);
		getContentPane().add(state);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(133, 235, 188, 22);
		getContentPane().add(city);
		
		zip = new JTextField();
		zip.setColumns(10);
		zip.setBounds(133, 314, 188, 22);
		getContentPane().add(zip);
		
		update = new JButton("Update");
		update.setBounds(159, 381, 126, 40);
		getContentPane().add(update);
		update.addActionListener(this);
		
		c=MyConn.connect();
		try {
			PreparedStatement ps = c.prepareStatement("select line1 , line2 , state , city , zip from users where username=? ");
			ps.setString(1, user);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				line1.setText(rs.getString(1));
				line2.setText(rs.getString(2));
				state.setText(rs.getString(3));
				city.setText(rs.getString(4));
				zip.setText(rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		
		
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new AEdit("faisal");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String l1=line1.getText();
		String l2=line2.getText();
		String s= state.getText();
		String ci=city.getText();
		String z=zip.getText();
		if(l1.length()!=0 && l2.length()!=0 && s.length()!=0 && ci.length()!=0 && z.length()!=0)
		{
			try 
			{
		
			PreparedStatement ps = c.prepareStatement("update users set line1=? , line2=? , state=? , city=? , zip=?  where username=?");
			ps.setString(6,user);
			ps.setString(1,l1);
			ps.setString(2,l2);
			ps.setString(3,s);
			ps.setString(4,ci);
			ps.setString(5,z);
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Updated!!");
			}
			catch (SQLException e1) 
			{
			// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}
		else
			JOptionPane.showMessageDialog(null, "Please, fill all details!");
		
		
	}

}
