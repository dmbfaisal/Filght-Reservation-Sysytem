package Gen;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

import support.DValid;
import support.MyConn;

public class Registerations implements ActionListener,ItemListener,FocusListener
{
	JPanel container;
	JFrame frame;
	JComboBox ques;
	private JTextField user;
	private JTextField fname;
	private JTextField lname;
	private JTextField pno;
	private JTextField email;
	private JTextField mob;
	private JTextField aline1;
	private JTextField aline2;
	private JTextField zip;
	private JTextField cno;
	private JTextField cval;
	private JTextField ccode;
	private JPasswordField pass;
	private JPasswordField repass;
	JButton submit,cancel;
	JCheckBox pcheck;
	JRadioButton m,f,dcard,ccard;
	
	JComboBox year,month,date;
	private JTextField state;
	private JTextField city;
	int a[]= new int[6];
	private JTextField ans;
	
	public Registerations()
	{
		container = new JPanel();
		frame= new JFrame();
		container.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setPreferredSize(new Dimension(1920,1080));
		frame.setSize(frame.getMaximumSize());
		
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(41, 159, 98, 33);
		container.add(label);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(41, 213, 131, 33);
		container.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLastName.setBounds(475, 213, 131, 33);
		container.add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(41, 286, 131, 33);
		container.add(lblEmail);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMobile.setBounds(41, 349, 131, 33);
		container.add(lblMobile);
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAccountDetails.setBounds(12, 77, 179, 33);
		container.add(lblAccountDetails);
		
		JLabel lblRegisteration = new JLabel("REGISTERATION");
		lblRegisteration.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		lblRegisteration.setBounds(892, 13, 192, 33);
		container.add(lblRegisteration);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAddress.setBounds(12, 420, 179, 33);
		container.add(lblAddress);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(539, 466, -506, 145);
		container.add(separator_1);
		
		JLabel lblLine = new JLabel("Line1");
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLine.setBounds(41, 493, 131, 33);
		container.add(lblLine);
		
		JLabel lblLine_1 = new JLabel("Line2");
		lblLine_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLine_1.setBounds(585, 493, 131, 33);
		container.add(lblLine_1);
		

		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblState.setBounds(1091, 493, 53, 33);
		container.add(lblState);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCity.setBounds(1525, 500, 45, 33);
		container.add(lblCity);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblZipCode.setBounds(41, 578, 131, 33);
		container.add(lblZipCode);
		
		JLabel lblPaymentDetails = new JLabel("Payment Details");
		lblPaymentDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPaymentDetails.setBounds(12, 705, 147, 33);
		container.add(lblPaymentDetails);
		
		JLabel lblCardType = new JLabel("Card Type");
		lblCardType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCardType.setBounds(41, 824, 131, 33);
		container.add(lblCardType);
		
		dcard = new JRadioButton("Debit Card");
		dcard.setBounds(222, 830, 127, 25);
		container.add(dcard);
		
		ccard = new JRadioButton("Credit Card");
		ccard.setBounds(355, 830, 127, 25);
		container.add(ccard);
		
		JLabel lblCardNo = new JLabel("Card No.");
		lblCardNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCardNo.setBounds(41, 896, 98, 33);
		container.add(lblCardNo);
		
		JLabel lblValidityDate = new JLabel("Validity Date");
		lblValidityDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblValidityDate.setBounds(561, 896, 109, 33);
		container.add(lblValidityDate);
		
		JLabel lblCode = new JLabel("code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCode.setBounds(1091, 896, 66, 33);
		container.add(lblCode);
		
		JLabel lblNewLabel = new JLabel("(Optional)");
		lblNewLabel.setBounds(157, 710, 66, 26);
		container.add(lblNewLabel);
		
		pcheck = new JCheckBox("Fill Payment Details");
		pcheck.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pcheck.setBounds(46, 767, 200, 25);
		container.add(pcheck);
		pcheck.setSelected(true);
		
		
		
		JLabel lblPassportNo = new JLabel("Passport No.");
		lblPassportNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassportNo.setBounds(1091, 213, 131, 33);
		container.add(lblPassportNo);
		
		submit = new JButton("Submit");
		submit.setBounds(691, 994, 162, 38);
		container.add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(1018, 994, 162, 38);
		container.add(cancel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(475, 159, 131, 33);
		container.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblReenterPassword.setBounds(1091, 159, 153, 33);
		container.add(lblReenterPassword);
		
		user = new JTextField();
		user.setBounds(157, 166, 192, 22);
		container.add(user);
		user.setColumns(10);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(157, 220, 192, 22);
		container.add(fname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(618, 220, 171, 22);
		container.add(lname);
		
		pno = new JTextField();
		pno.setColumns(10);
		pno.setBounds(1296, 220, 179, 22);
		container.add(pno);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(157, 293, 207, 22);
		container.add(email);
		
		mob = new JTextField();
		mob.setColumns(10);
		mob.setBounds(157, 356, 192, 22);
		container.add(mob);
		
		aline1 = new JTextField();
		aline1.setColumns(10);
		aline1.setBounds(157, 500, 350, 22);
		container.add(aline1);
		
		aline2 = new JTextField();
		aline2.setColumns(10);
		aline2.setBounds(687, 500, 322, 22);
		container.add(aline2);
		
		zip = new JTextField();
		zip.setColumns(10);
		zip.setBounds(157, 589, 147, 22);
		container.add(zip);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGender.setBounds(475, 286, 131, 33);
		container.add(lblGender);
		
		m = new JRadioButton("Male");
		m.setBounds(627, 292, 60, 25);
		container.add(m);
		
		f = new JRadioButton("Female");
		f.setBounds(691, 292, 71, 25);
		container.add(f);
		
		cno = new JTextField();
		cno.setColumns(10);
		cno.setBounds(168, 903, 192, 22);
		container.add(cno);
		
		cval = new JTextField();
		cval.setColumns(10);
		cval.setBounds(705, 903, 192, 22);
		container.add(cval);
		
		ccode = new JTextField();
		ccode.setColumns(10);
		ccode.setBounds(1168, 903, 192, 22);
		container.add(ccode);
		
		pass = new JPasswordField();
		pass.setBounds(618, 166, 171, 22);
		container.add(pass);
		
		repass = new JPasswordField();
		repass.setBounds(1296, 170, 179, 22);
		container.add(repass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 152, 53, -27);
		container.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 123, 1902, 14);
		container.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 466, 1902, 14);
		container.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(12, 755, 1902, 14);
		container.add(separator_4);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateOfBirth.setBounds(1091, 286, 98, 33);
		container.add(lblDateOfBirth);
		
		
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"Year", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937"}));
		year.setBounds(1296, 293, 78, 22);
		container.add(year);
		
		month = new JComboBox();
		month.setBounds(1402, 293, 85, 22);
		container.add(month);
		
		date = new JComboBox();
		date.setBounds(1518, 293, 78, 22);
		container.add(date);
		
		state = new JTextField();
		state.setBounds(1168, 500, 192, 22);
		container.add(state);
		state.setColumns(10);
		
		city = new JTextField();
		city.setBounds(1602, 500, 179, 22);
		container.add(city);
		city.setColumns(10);
		ButtonGroup bg=new ButtonGroup();
		bg.add(m);
		bg.add(f);
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(dcard);
		bg1.add(ccard);
		
		container.setSize(container.getMaximumSize());
		submit.addActionListener(this);
		cancel.addActionListener(this);
		pcheck.addItemListener(this);
		year.addItemListener(this);
		month.addItemListener(this);
		user.addFocusListener(this);
		repass.addFocusListener(this);
		pass.addFocusListener(this);
		pno.addFocusListener(this);
		email.addFocusListener(this);
		mob.addFocusListener(this);
		cno.addFocusListener(this);
		submit.setEnabled(false);
		
		JScrollPane jsp= new JScrollPane(container,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSecurityQuestion.setBounds(475, 359, 131, 33);
		container.add(lblSecurityQuestion);
		
		ques = new JComboBox();
		ques.setModel(new DefaultComboBoxModel(new String[] {"What is your pet's name?", "Where is your birthplace?"}));
		ques.setBounds(642, 366, 331, 22);
		container.add(ques);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAnswer.setBounds(1091, 359, 98, 33);
		container.add(lblAnswer);
		
		ans = new JTextField();
		ans.setBounds(1296, 366, 192, 22);
		container.add(ans);
		ans.setColumns(10);
		frame.getContentPane().add(jsp);
		frame.setVisible(true);
		
	}
	public static void main(String[] ar)
	{
		new Registerations();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob= e.getSource();
		
		if(ob==submit)
		{
			
			
				if(user.getText().isEmpty()||fname.getText().isEmpty()||lname.getText().isEmpty()||pno.getText().isEmpty()||email.getText().isEmpty()||mob.getText().isEmpty()||aline1.getText().isEmpty()||aline2.getText().isEmpty()||zip.getText().isEmpty()||pass.getPassword().toString().isEmpty()||repass.getPassword().toString().isEmpty()||(m.isSelected()&&f.isSelected())||state.getText().isEmpty()||city.getText().isEmpty()||year.getSelectedItem().equals("Year")||month.getSelectedItem().equals("Month")||date.getSelectedItem().equals("Date")||ans.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please, Fill all the details!");
				}
				else
				{
					
					Connection c = MyConn.connect();
					try 
					{
						PreparedStatement ps=c.prepareStatement("insert into users (username, password, first, last, passport, email, gender, dob, mob,  line1, line2, state, city, zip, utype ,ques , answer ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					
						ps.setString(1,user.getText());
						ps.setString(2,new String(pass.getPassword()));
						ps.setString(3,fname.getText());
						ps.setString(4,lname.getText());
						ps.setString(5,pno.getText());
						ps.setString(6,email.getText());
						ps.setString(8,date.getSelectedItem().toString()+" "+month.getSelectedItem().toString()+" "+year.getSelectedItem().toString());
						ps.setString(9,mob.getText());
						ps.setString(10,aline1.getText());
						ps.setString(11,aline2.getText());
						ps.setString(12,state.getText());
						ps.setString(13,city.getText());
						ps.setString(14,zip.getText());
						ps.setInt(15, 0);
						if(m.isSelected())
							ps.setString(7,"Male");
						else
							ps.setString(7,"Female");
						
						ps.setInt(16,ques.getSelectedIndex());
						ps.setString(17,ans.getText());
						ps.executeUpdate();
						if(pcheck.isSelected())
						{
							if(!(dcard.isSelected()||ccard.isSelected())||cno.getText().isEmpty()||cval.getText().isEmpty()||ccode.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null,"Complete All Details!!");
							}
							else
							{
								try 
								{
									PreparedStatement ps1= c.prepareStatement("update users set ctype=? ,cno=? ,cval=? ,code=? where username=? ");
									ps1.setString(2,cno.getText());
									ps1.setString(3,cval.getText());
									ps1.setString(4, ccode.getText());
									ps1.setString(5, user.getText());
							
									if(dcard.isSelected())
									{
										ps1.setString(1,"D");
									}
									else
									{
										ps1.setString(1,"C");
									}
									ps1.executeUpdate();
							
							
								} 
								catch (SQLException e1)
								{
							// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}
					}
						//MyConn.createtable(user.getText());
						JOptionPane.showMessageDialog(null,"Registeration Complete!");
						frame.dispose();
						new Login();
					
						//System.out.println("table created");
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					
				}
			
				
			}
		}
		else if(ob==cancel)
		{
			int y=JOptionPane.showConfirmDialog(null, "Cancel Registeration?", "Exit??", JOptionPane.YES_NO_OPTION);
			if(y==0)
			{
				frame.dispose();
				//new Login();
			}
			
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		Object ob= e.getSource();
		if(ob==year)
		{
			if(year.getSelectedItem().toString().equals("Year"))
				{
				month.setModel(new DefaultComboBoxModel(new String[] {"Month"}));
				date.setModel(new DefaultComboBoxModel(new String[] {"Day"}));
				}
			else
			{
				
			month.setModel(new DefaultComboBoxModel(new String[] {"Month","January","February","March","April","May","June","July","August","September","October","November","December"}));
			}
		}
		else if(ob==month)
		{
			String[] t=DValid.genDate(year.getSelectedItem().toString(), month.getSelectedItem().toString());
			date.setModel(new DefaultComboBoxModel(t));
		}
		else if(ob==pcheck)
		{
			int check=0;
			
			if(pcheck.isSelected())
			{
				cno.setText(null);
				cval.setText(null);
				ccode.setText(null);
				ccard.setSelected(false);
				dcard.setSelected(false);
				
				cno.setEnabled(true);
				cval.setEnabled(true);
				ccode.setEnabled(true);
				ccard.setEnabled(true);
				dcard.setEnabled(true);
				
				for(int i=0;i<6;i++)
					check+=a[i];
				if(check!=6)
					submit.setEnabled(false);
				
			}
			else
			{
				
				cno.setEnabled(false);
				cval.setEnabled(false);
				ccode.setEnabled(false);
				ccard.setEnabled(false);
				dcard.setEnabled(false);
				a[5]=0;
				for(int i=0;i<5;i++)
					check+=a[i];
				if(check==5)
					submit.setEnabled(true);
				System.out.println("enabled");
			}
			frame.getContentPane().setVisible(false);
			frame.getContentPane().setVisible(true);
		}
		
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		
		Object ob= e.getSource();
		
		if(ob==user)
		{
			Connection c= MyConn.connect();
			try 
			{
				a[0]=1;
				String s=user.getText();
				PreparedStatement ps = c.prepareStatement("select * from users where username=?");
				ps.setString(1,user.getText());
			
				ResultSet rs=ps.executeQuery();
				while(rs.next())
					{
						JOptionPane.showMessageDialog(null,"Username Already Taken! Please Try another!");
						user.setText(null);
						user.setFocusable(true);
						a[0]=0;
					}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(a[0]);
		}
		else if(ob==repass)
		{
			a[1]=1;
			if(!(new String(pass.getPassword()).equals(new String(repass.getPassword()))))
			{
				JOptionPane.showMessageDialog(null, "Passwords do not match!");
				pass.setText(null);
				repass.setText(null);
				pass.setFocusable(true);
				a[1]=0;
			}
			System.out.println(a[1]);
			
		}
		else if(ob==pass&&!(new String(repass.getPassword()).isEmpty()))
		{
			a[1]=1;
			if(!(new String(pass.getPassword()).equals(new String(repass.getPassword()))))
			{
				JOptionPane.showMessageDialog(null, "Passwords do not match!");
				pass.setText(null);
				repass.setText(null);
				pass.setFocusable(true);
				a[1]=0;
			}
			System.out.println(a[1]);
		}
		else if(ob==pno)
		{
			a[2]=1;
			if(pno.getText().length()!=9)
			{
				JOptionPane.showMessageDialog(null, " Passport No. should contain contain 9 charcters");
				pno.setText(null);
				a[2]=0;
			}
			System.out.println(a[2]);
		}
		
		else if(ob==email)
		{	
			a[3]=1;
			if(email.getText().indexOf("@")==-1||email.getText().indexOf(".co")==-1||(email.getText().indexOf("@")>email.getText().indexOf(".co")))
					{
						JOptionPane.showMessageDialog(null, "Enter Valid Email address(it should contain @)");
					a[3]=0;
					}
			else
			{
				a[3]=1;
			}
			System.out.println(a[3]);
		}
		else if(ob==mob)
		{
			
			a[4]=1;
				try {
					//int t=Integer.parseInt(mob.getText());
					
					if(mob.getText().length()==10)
					{
						Long.parseLong(mob.getText());
						a[4]=1;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Mobile no. must contain 10 digits");
						a[4]=0;
					}
				}
				catch (NumberFormatException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Mobile no must only contain digits");
					a[4]=0;
					
				} 
				catch (HeadlessException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println(a[4]);
			
			
		}
		else if(ob==cno)
		{
			a[5]=1;
			if(cno.getText().length()!=16)
			{
				JOptionPane.showMessageDialog(null,"Card No. must contain 16 digits");
				a[5]=0;
			}
			System.out.println(a[5]);
		}
		for(int i=0;i<6;i++)
			System.out.println(i+"="+a[i]);
		int check=0;
		for(int i=0;i<6;i++)
			check+=a[i];
		if((check==6 && pcheck.isSelected())||(check==5 && !(pcheck.isSelected()) && a[5]==0))
		{
			submit.setEnabled(true);
			frame.getContentPane().setVisible(false);
			frame.getContentPane().setVisible(true);
		}
	}
}
