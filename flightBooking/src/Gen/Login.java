package Gen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import support.MyConn;
import admin.AdminHome;

public class Login extends JDialog implements ActionListener 
{
	private JTextField txtu;
	private JPasswordField psf;
	JButton lgn,fp,reg;

	public Login() 
	{
		setTitle("Employee Login");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel user = new JLabel("Username");
		user.setFont(new Font("Tahoma", Font.PLAIN, 18));
		user.setBounds(34, 55, 101, 36);
		getContentPane().add(user);
		
		txtu = new JTextField();
		txtu.setBounds(213, 55, 141, 31);
		getContentPane().add(txtu);
		txtu.setColumns(10);
		
		JLabel ps = new JLabel("Password");
		ps.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ps.setBounds(34, 159, 101, 31);
		getContentPane().add(ps);
		
		psf = new JPasswordField();
		psf.setBounds(213, 161, 141, 31);
		getContentPane().add(psf);
		
		lgn = new JButton("Login");
		lgn.setBounds(34, 268, 132, 31);
		getContentPane().add(lgn);
		
		fp = new JButton("Forgot Password ?");
		fp.setBounds(196, 268, 158, 31);
		getContentPane().add(fp);
		
	    reg = new JButton("Register");
		reg.setBounds(104, 357, 158, 36);
		getContentPane().add(reg);
		
		
		
		lgn.addActionListener(this);
		fp.addActionListener(this);
		reg.addActionListener(this);
		getRootPane().setDefaultButton(lgn);
		
		ImageIcon ii=new ImageIcon(getClass().getResource("images/f2.jpg"));
		JLabel img =new JLabel(ii);
		img.setBounds(0,0,400,500);
		getContentPane().add(img);
		
		setSize(400, 500);
		setVisible(true);
		
	}

	public static void main(String[] args) 
	{
		new Login();

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob ;
		ob= e.getSource();
		
		if(ob==lgn)
		{
			String user=txtu.getText();
			
			String pass=new String(psf.getPassword());
			System.out.println(pass);
			
			
			if((user.length()!=0 )&&(pass.length()!=0))
			{
				Connection c=MyConn.connect();
				try {
					
					String s="Select * from users where username=? and password=?";
					PreparedStatement ps = c.prepareStatement(s);
					ps.setString(1,user);
					ps.setString(2,pass);
					//ResultSet rs = MyConn.selectQuery(MyConn.connect(), "Select * from users where username='"+user+"' and password='"+pass+"' ");
					//System.out.println("Select * from login where username='"+user+"' and password='"+pass+"' ");
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						System.out.println(rs.getString("username"));
						System.out.println("found");
						if(rs.getInt(19)==0)
						new Homepage2(rs.getString(1));
						else
							new AdminHome();
						
						dispose();
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect username or password or both!!", "Error in Login", JOptionPane.ERROR_MESSAGE);
					}
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					try {
						c.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			else
			{		
				JOptionPane.showMessageDialog(null, "Please,Enter Complete Login Details!! ", "Error in Login", JOptionPane.ERROR_MESSAGE);
				
			}
		}
		else if(ob==fp)
		{
			
			new ForPass(JOptionPane.showInputDialog("Enter Username!!"));
			dispose();
		}
		else if(ob==reg)
		{
			dispose();
			new Registerations();
		}
		
		
	}
}
