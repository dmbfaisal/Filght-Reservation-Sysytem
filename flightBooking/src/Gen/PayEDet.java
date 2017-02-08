package Gen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import support.MyConn;

public class PayEDet extends JDialog implements ActionListener 
{
	private JTextField cno;
	private JTextField val;
	private JTextField ccode;
	JButton submit;
	JRadioButton dcard,ccard;
	String u;

	public PayEDet(String u) 
	{
		getContentPane().setLayout(null);
		this.u=u;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JLabel label_1 = new JLabel("Card Type");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(52, 56, 87, 33);
		getContentPane().add(label_1);
		
		dcard = new JRadioButton("Debit Card");
		dcard.setBounds(226, 62, 100, 25);
		getContentPane().add(dcard);
		
		ccard = new JRadioButton("Credit Card");
		ccard.setBounds(335, 62, 127, 25);
		getContentPane().add(ccard);
		
		JLabel label = new JLabel("Card No.");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(52, 123, 98, 33);
		getContentPane().add(label);
		
		cno = new JTextField();
		cno.setColumns(10);
		cno.setBounds(226, 130, 192, 22);
		getContentPane().add(cno);
		
		JLabel label_2 = new JLabel("Validity Date");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(52, 177, 109, 33);
		getContentPane().add(label_2);
		
		val = new JTextField();
		val.setColumns(10);
		val.setBounds(226, 188, 192, 22);
		getContentPane().add(val);
		
		JLabel label_3 = new JLabel("code");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(52, 244, 66, 33);
		getContentPane().add(label_3);
		
		ccode = new JTextField();
		ccode.setColumns(10);
		ccode.setBounds(226, 251, 192, 22);
		getContentPane().add(ccode);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(dcard);
		bg.add(ccard);
		
		submit = new JButton("Submit");
		submit.setBounds(146, 315, 162, 38);
		getContentPane().add(submit);
		setSize(488,446);
		submit.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(!(dcard.isSelected()||ccard.isSelected())||cno.getText().isEmpty()||val.getText().isEmpty()||ccode.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Complete All Details!!");
		}
		else
		{
			Connection c= MyConn.connect();
			try {
				PreparedStatement ps= c.prepareStatement("update users set ctype=? ,cno=? ,cval=? ,code=? where username=?");
				ps.setString(2,cno.getText());
				ps.setString(3,val.getText());
				ps.setString(4, ccode.getText());
				ps.setString(5, u);
				if(dcard.isSelected())
				{
					ps.setString(1,"D");
				}
				else
				{
					ps.setString(1,"C");
				}
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Updated!");
				dispose();
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	public static void main(String a[])
	{
		new PayEDet("faisal");
	}
}
