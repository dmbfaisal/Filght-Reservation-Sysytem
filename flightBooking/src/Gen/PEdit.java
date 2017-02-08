package Gen;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;

import support.MyConn;

public class PEdit extends JDialog implements ActionListener , FocusListener
{
	private JPasswordField pass;
	private JPasswordField repass;
	private JTextField user;
	private JTextField first;
	private JTextField last;
	private JTextField passno;
	private JTextField email;
	private JTextField dob;
	private JTextField gender;
	private JTextField mob;
	JButton update;
	Connection c;
	int a[] = new int[3];

	public PEdit(String u) 
	{
		getContentPane().setLayout(null);
		setTitle("Update Primary Details!!");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(203, 32, 98, 33);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(26, 100, 131, 33);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Re-enter Password");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(396, 100, 153, 33);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("First Name");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(26, 165, 131, 33);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Last Name");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_4.setBounds(397, 165, 131, 33);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Passport No.");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(26, 245, 131, 33);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("E-Mail");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(26, 324, 131, 33);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Gender");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_7.setBounds(397, 324, 131, 33);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Date Of Birth");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_8.setBounds(26, 415, 98, 33);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Mobile");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_9.setBounds(396, 415, 131, 33);
		getContentPane().add(label_9);
		
		update = new JButton("Update");
		update.setBounds(321, 500, 131, 33);
		getContentPane().add(update);
		
		pass = new JPasswordField();
		pass.setBounds(149, 107, 171, 22);
		getContentPane().add(pass);
		
		repass = new JPasswordField();
		repass.setBounds(587, 107, 171, 22);
		getContentPane().add(repass);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBounds(344, 39, 171, 22);
		getContentPane().add(user);
		user.setText(u);
		user.setEditable(false);
		
		first = new JTextField();
		first.setColumns(10);
		first.setBounds(149, 172, 171, 22);
		getContentPane().add(first);
		
		last = new JTextField();
		last.setColumns(10);
		last.setBounds(587, 172, 171, 22);
		getContentPane().add(last);
		
		passno = new JTextField();
		passno.setColumns(10);
		passno.setBounds(149, 252, 171, 22);
		getContentPane().add(passno);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(149, 331, 171, 22);
		getContentPane().add(email);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(149, 422, 171, 22);
		getContentPane().add(dob);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(587, 331, 171, 22);
		getContentPane().add(gender);
		
		mob = new JTextField();
		mob.setColumns(10);
		mob.setBounds(587, 422, 171, 22);
		getContentPane().add(mob);
		setSize(800,600);
		
		
		update.addActionListener(this);
		pass.addFocusListener(this);
		repass.addFocusListener(this);
		email.addFocusListener(this);
		mob.addFocusListener(this);
		//setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//setModal(true);
		
		
		
		c=MyConn.connect();
		try {
			PreparedStatement ps= c.prepareStatement("select * from users where username=?");
			ps.setString(1, u);
			ResultSet rs= ps.executeQuery();//(first ,last,email,gender,mob,passport,dob)
			if(rs.next())
			{
				System.out.println("putting values");
				first.setText(rs.getString("first"));
				last.setText(rs.getString("last"));
				email.setText(rs.getString("email"));
				gender.setText(rs.getString("gender"));
				mob.setText(rs.getString("mob"));
				passno.setText(rs.getString("passport"));
				dob.setText(rs.getString("dob"));
				first.setEditable(false);
				last.setEditable(false);
				gender.setEditable(false);
				passno.setEditable(false);
				dob.setEditable(false);
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int check=0;
		for(int i=0;i<3;i++)
			check+=a[i];
		if(check==3)
		{	
		String u=user.getText();
		String em=email.getText();
		String p= new String(pass.getPassword());
		String m=mob.getText();
		if(u.length()!=0 && em.length()!=0 && p.length()!=0 && m.length()!=0)
		{
			try 
			{
		
			PreparedStatement ps= c.prepareStatement("update users set email=? , password=? , mob=? where username=?");
			ps.setString(4,u);
			ps.setString(1,em);
			ps.setString(2,p);
			ps.setString(3,m);
			ps.executeUpdate();
			}
			catch (SQLException e1) 
			{
			// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Updated!!");
		}
		else
			JOptionPane.showMessageDialog(null, "Please, fill all details!");
		}
	}

	@Override
	public void focusGained(FocusEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) 
	{
		Object ob = e.getSource();
		 if(ob==repass)
		{
			if(!(new String(pass.getPassword()).equals(new String(repass.getPassword()))))
			{
				JOptionPane.showMessageDialog(null, "Passwords do not match!");
				pass.setText(null);
				repass.setText(null);
				pass.setFocusable(true);
				a[1]=0;
			}
			else
			{
				a[0]=1;
				a[1]=1;
				a[2]=1;
			}
				
			
			
		}
		else if(ob==pass&&!(new String(repass.getPassword()).isEmpty()))
		{
			if(!(new String(pass.getPassword()).equals(new String(repass.getPassword()))))
			{
				JOptionPane.showMessageDialog(null, "Passwords do not match!");
				pass.setText(null);
				repass.setText(null);
				pass.setFocusable(true);
				a[0]=0;
			}
			else
			{
				a[0]=1;
				a[1]=1;
				a[2]=1;
			}
		}
		else if(ob==email)
		{
			if(email.getText().indexOf("@")==-1||email.getText().indexOf(".co")==-1||(email.getText().indexOf("@")>email.getText().indexOf(".co")))
					{
						JOptionPane.showMessageDialog(null, "Enter Valid Email address(it should contain @)");
						a[0]=1;
						a[1]=1;
						a[2]=1;
					}
			else
			{
				a[1]=0;
			}
		}
		else if(ob==mob)
		{
			
			
				try {
					//int t=Integer.parseInt(mob.getText());
					Long.parseLong(mob.getText());
					if(mob.getText().length()==10)
					{
						a[2]=1;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Mobile no. must contain 10 digits");
						a[2]=0;
					}
				}
				catch (NumberFormatException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Mobile no must only contain digits");
					a[2]=0;
				} 
				catch (HeadlessException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			
			
		}
	}
	public static void main(String a[])
	{
		new PEdit("faisal");
	}
	
}
