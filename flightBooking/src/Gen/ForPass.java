package Gen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import support.MyConn;
import javax.swing.DefaultComboBoxModel;

public class ForPass extends JDialog implements ActionListener
{
	private JTextField ans;
	String user;
	Connection c;
	
	public ForPass(String user)
	{
		getContentPane().setLayout(null);
		this.user=user;
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(42, 40, 363, -75);
		getContentPane().add(lblUsername);
		
		JLabel lblId = new JLabel("Question");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(42, 98, 101, 34);
		getContentPane().add(lblId);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAnswer.setBounds(42, 210, 101, 34);
		getContentPane().add(lblAnswer);
		
		JComboBox ques = new JComboBox();
		ques.setModel(new DefaultComboBoxModel(new String[] {"What is your pet's name?", "Where is your birthplace?"}));
		ques.setBounds(251, 106, 280, 22);
		getContentPane().add(ques);
		
		ans = new JTextField();
		ans.setBounds(251, 218, 280, 22);
		getContentPane().add(ans);
		ans.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(210, 312, 137, 46);
		getContentPane().add(submit);
		setSize(600,600);
		 c= MyConn.connect();
		try {
			PreparedStatement ps= c.prepareStatement("select ques from users where username=?");
			ps.setString(1,user);
			ResultSet rs=ps.executeQuery();
			int q;
			if(rs.next())
			{
				q=rs.getInt(1);
				ques.setSelectedIndex(q);
				ques.setEnabled(false);
				setVisible(true);
				
				
			}
			else
			{
				dispose();
				new Login();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		submit.addActionListener(this);
		
		
		
	}

	public static void main(String[] args)
	{
		

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(!(ans.getText().isEmpty()))
		{
			try {
				PreparedStatement ps= c.prepareStatement("select answer from users where username=?");
				ps.setString(1, user);
				ResultSet rs= ps.executeQuery();
				if(rs.next())
				{
					if(rs.getString(1).equals(ans.getText()))
					{
						String npass= JOptionPane.showInputDialog("Input new Password!!");
						String rnpass=JOptionPane.showInputDialog("Re enter password!");
						while(!(npass.equals(rnpass)))
						{
							JOptionPane.showMessageDialog(null, "Passwords do not match!");
							npass= JOptionPane.showInputDialog("Input new Password!!");
							rnpass=JOptionPane.showInputDialog("Re enter password!");
						}
						
						PreparedStatement ps1=c.prepareStatement("update users set password=? where username=?");
						ps1.setString(2, user);
						ps1.setString(1, npass);
						ps1.executeUpdate();
						dispose();
						new Login();
								
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Answer does not match!!");
					}
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
}
}
