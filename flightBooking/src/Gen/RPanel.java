package Gen;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class RPanel extends JPanel
{
	 JTextField user;
	 JTextField fname;
	 JTextField lname;
	 JTextField pno;
	 JTextField email;
	 JTextField mob;
	 JTextField aline1;
	 JTextField aline2;
	 JTextField zip;
	 JTextField cno;
	 JTextField cval;
	 JTextField ccode;
	 JPasswordField pass;
	 JPasswordField repass;
	JButton submit,cancel;
	JCheckBox pcheck;
	JRadioButton m,f,dcard,ccard;
	
	JComboBox year,month,date;
	 JTextField state;
	 JTextField city;
	

	public RPanel() 
	{
		
		setSize(1597,953);
		setLayout(null);
		
		
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(41, 159, 98, 33);
		add(label);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(41, 213, 131, 33);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLastName.setBounds(475, 213, 131, 33);
		add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(41, 264, 131, 33);
		add(lblEmail);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMobile.setBounds(41, 310, 131, 33);
		add(lblMobile);
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAccountDetails.setBounds(12, 77, 179, 33);
		add(lblAccountDetails);
		
		JLabel lblRegisteration = new JLabel("REGISTERATION");
		lblRegisteration.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		lblRegisteration.setBounds(644, 13, 192, 33);
		add(lblRegisteration);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAddress.setBounds(12, 369, 179, 33);
		add(lblAddress);
		
		JLabel lblLine = new JLabel("Line1");
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLine.setBounds(41, 441, 131, 33);
		add(lblLine);
		
		JLabel lblLine_1 = new JLabel("Line2");
		lblLine_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLine_1.setBounds(585, 441, 131, 33);
		add(lblLine_1);
		

		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblState.setBounds(1091, 441, 53, 33);
		add(lblState);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCity.setBounds(41, 499, 45, 33);
		add(lblCity);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblZipCode.setBounds(585, 499, 71, 33);
		add(lblZipCode);
		
		JLabel lblPaymentDetails = new JLabel("Payment Details");
		lblPaymentDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPaymentDetails.setBounds(12, 576, 147, 33);
		add(lblPaymentDetails);
		
		JLabel lblCardType = new JLabel("Card Type");
		lblCardType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCardType.setBounds(41, 690, 131, 33);
		add(lblCardType);
		
		dcard = new JRadioButton("Debit Card");
		dcard.setBounds(171, 696, 127, 25);
		add(dcard);
		
		ccard = new JRadioButton("Credit Card");
		ccard.setBounds(277, 696, 127, 25);
		add(ccard);
		
		JLabel lblCardNo = new JLabel("Card No.");
		lblCardNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCardNo.setBounds(41, 745, 131, 33);
		add(lblCardNo);
		
		JLabel lblValidityDate = new JLabel("Validity Date");
		lblValidityDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblValidityDate.setBounds(561, 745, 131, 33);
		add(lblValidityDate);
		
		JLabel lblCode = new JLabel("code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCode.setBounds(1091, 745, 131, 33);
		add(lblCode);
		
		JLabel lblNewLabel = new JLabel("(Optional)");
		lblNewLabel.setBounds(171, 583, 66, 26);
		add(lblNewLabel);
		
		pcheck = new JCheckBox("Fill Payment Details");
		pcheck.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pcheck.setBounds(25, 645, 200, 25);
		add(pcheck);
		pcheck.setSelected(true);
		
		
		
		JLabel lblPassportNo = new JLabel("Passport No.");
		lblPassportNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassportNo.setBounds(947, 213, 131, 33);
		add(lblPassportNo);
		
		submit = new JButton("Submit");
		submit.setBounds(585, 860, 162, 38);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(878, 860, 162, 38);
		add(cancel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(475, 159, 131, 33);
		add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblReenterPassword.setBounds(947, 159, 153, 33);
		add(lblReenterPassword);
		
		user = new JTextField();
		user.setBounds(157, 166, 192, 22);
		add(user);
		user.setColumns(10);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(157, 220, 192, 22);
		add(fname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(618, 220, 171, 22);
		add(lname);
		
		pno = new JTextField();
		pno.setColumns(10);
		pno.setBounds(1168, 220, 179, 22);
		add(pno);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(157, 271, 207, 22);
		add(email);
		
		mob = new JTextField();
		mob.setColumns(10);
		mob.setBounds(157, 317, 192, 22);
		add(mob);
		
		aline1 = new JTextField();
		aline1.setColumns(10);
		aline1.setBounds(157, 448, 350, 22);
		add(aline1);
		
		aline2 = new JTextField();
		aline2.setColumns(10);
		aline2.setBounds(691, 448, 322, 22);
		add(aline2);
		
		zip = new JTextField();
		zip.setColumns(10);
		zip.setBounds(691, 506, 147, 22);
		add(zip);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGender.setBounds(485, 264, 131, 33);
		add(lblGender);
		
		m = new JRadioButton("Male");
		m.setBounds(632, 270, 60, 25);
		add(m);
		
		f = new JRadioButton("Female");
		f.setBounds(691, 270, 71, 25);
		add(f);
		
		cno = new JTextField();
		cno.setColumns(10);
		cno.setBounds(157, 753, 192, 22);
		add(cno);
		
		cval = new JTextField();
		cval.setColumns(10);
		cval.setBounds(691, 753, 192, 22);
		add(cval);
		
		ccode = new JTextField();
		ccode.setColumns(10);
		ccode.setBounds(1168, 753, 192, 22);
		add(ccode);
		
		pass = new JPasswordField();
		pass.setBounds(618, 166, 171, 22);
		add(pass);
		
		repass = new JPasswordField();
		repass.setBounds(1166, 166, 179, 22);
		add(repass);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 123, 1902, 14);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 417, 1902, 14);
		add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 622, 1902, 14);
		add(separator_4);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateOfBirth.setBounds(942, 264, 98, 33);
		add(lblDateOfBirth);
		
		
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"Year", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937"}));
		year.setBounds(1168, 271, 78, 22);
		add(year);
		
		month = new JComboBox();
		month.setBounds(1262, 271, 85, 22);
		add(month);
		
		date = new JComboBox();
		date.setBounds(1359, 271, 78, 22);
		add(date);
		
		state = new JTextField();
		state.setBounds(1168, 448, 192, 22);
		add(state);
		state.setColumns(10);
		
		city = new JTextField();
		city.setBounds(157, 506, 179, 22);
		add(city);
		city.setColumns(10);
		ButtonGroup bg=new ButtonGroup();
		bg.add(m);
		bg.add(f);
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(dcard);
		bg1.add(ccard);
		


	}

}
