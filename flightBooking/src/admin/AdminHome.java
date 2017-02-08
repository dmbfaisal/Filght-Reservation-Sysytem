package admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminHome implements ActionListener
{
	JFrame frame;
	JButton adF,edF;
	JPanel container;
	AddFlight af;
	EditFlight ef;
	public AdminHome() 
	{
		frame= new JFrame();
		frame.setSize(frame.getMaximumSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = new JPanel();
		//container.setSize(frame.getSize());
		container.setPreferredSize(new Dimension(1770,800));
		container.setLayout(null);
		
		JScrollPane jsp = new JScrollPane(container,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JLabel lblWelcomeAdministrator = new JLabel("Welcome Administrator!");
		lblWelcomeAdministrator.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblWelcomeAdministrator.setBounds(884, 63, 214, 40);
		container.add(lblWelcomeAdministrator);
		
		adF = new JButton("Add Flight");
		adF.setBounds(82, 327, 176, 56);
		container.add(adF);
		
		edF = new JButton("Edit Flight");
		edF.setBounds(82, 455, 176, 56);
		container.add(edF);
		
		af = new AddFlight();
		af.setBounds(405, 142, 1144, 569);
		container.add(af);
		frame.getContentPane().add(jsp);
		
		adF.addActionListener(this);
		edF.addActionListener(this);
		
		
		
		frame.setVisible(true);
	}
	
	public static void main(String a[])
	{
		new AdminHome();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Object ob = arg0.getSource();
		if(ob==adF)
		{
			try
			{
				container.remove(ef);
								
			}
			catch(NullPointerException e)
			{
				
			}
			try
			{
				container.remove(af);
								
			}
			catch(NullPointerException e)
			{
				
			}
			af = new AddFlight();
			af.setBounds(405, 142, 1144, 569);
			container.add(af);
			container.updateUI();
			
		}
		else if(ob==edF)
		{
			try
			{
				container.remove(ef);
								
			}
			catch(NullPointerException e)
			{
				
			}
			try
			{
				container.remove(af);
								
			}
			catch(NullPointerException e)
			{
				
			}
			ef = new EditFlight(JOptionPane.showInputDialog(null, "Enter Flight no to Edit"));
			ef.setBounds(405, 142, 1144, 569);
			container.add(ef);
			container.updateUI();
			
		}
		
	}
}
