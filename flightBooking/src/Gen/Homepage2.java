package Gen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import support.MyConn;

public class Homepage2 implements ActionListener 
{
	JFrame frame;
	String CurUser;
	JPanel SearOrRes;
	JScrollPane scroll ;
	
	JMenuItem ItemRes,ItemSear,ItemHist,ItemFDet,ItemADet,ItemEPDet,ItemEADet,ItemEPayDet,ItemDel,ItemExit,ItemSOut,ItemBFDet;

	/**
	 * @wbp.parser.entryPoint
	 */
	public Homepage2(String u) 
	{
		CurUser=u;
		frame=new JFrame("HomePage");
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1914, 26);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("Flights");
		menuBar.add(mnFile);
		
		ItemRes = new JMenuItem("New Reservation");
		mnFile.add(ItemRes);
		
		ItemSear = new JMenuItem("Search");
		mnFile.add(ItemSear);
		
		/*mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnFile.add(mntmNewMenuItem_2);*/
		
		JMenu mnStock = new JMenu("View");
		menuBar.add(mnStock);
		
		ItemHist = new JMenuItem("Reservation history\r\n");
		mnStock.add(ItemHist);
		
		ItemFDet = new JMenuItem("Flight Detail");
		mnStock.add(ItemFDet);
		
		 ItemBFDet = new JMenuItem("View Booked Flight/Cancel Flight");
		mnStock.add(ItemBFDet);
		
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		
		ItemADet = new JMenuItem("View Details");
		mnAccount.add(ItemADet);
		
		JMenu mnEditDetails = new JMenu("Edit Details");
		mnAccount.add(mnEditDetails);
		
		ItemEPDet = new JMenuItem("Primary Details");
		mnEditDetails.add(ItemEPDet);
		
		ItemEADet = new JMenuItem("Address");
		mnEditDetails.add(ItemEADet);
		
		ItemEPayDet = new JMenuItem("Payment Details");
		mnEditDetails.add(ItemEPayDet);
		
		ItemDel = new JMenuItem("Delete");
		mnAccount.add(ItemDel);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		ItemExit = new JMenuItem("Exit Program");
		mnExit.add(ItemExit);
		
		ItemSOut = new JMenuItem("Sign Out");
		mnExit.add(ItemSOut);
		
		/*JLabel lblNewLabel = new JLabel("Welcome "+par);
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 17));
		lblNewLabel.setBounds(1687, 79, 199, 40);
		*/
	    
		/*ImageIcon  ii=new ImageIcon(getClass().getResource("images/f3.jpg"));
		img =new JLabel(ii);
		
		img.setBounds(0,0,1900,1000);
		frame.add(img);
*/		
		//frame.getContentPane().add(lblNewLabel);
		SearOrRes=new SearchFlights(CurUser);
		frame.getContentPane().add(SearOrRes);
		scroll = new JScrollPane(SearOrRes,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scroll);
		
		
		
		
		
		
		
		
		
		

		
		frame.setSize(frame.getMaximumSize());
		frame.setVisible(true);
		ItemRes.addActionListener(this);
		ItemSear.addActionListener(this);
		ItemEADet.addActionListener(this);

		ItemDel.addActionListener(this);
		ItemEPDet.addActionListener(this);
		ItemEPayDet.addActionListener(this);
		ItemExit.addActionListener(this);
		ItemADet.addActionListener(this);
		ItemSOut.addActionListener(this);
		ItemFDet.addActionListener(this);
		ItemHist.addActionListener(this);
		ItemBFDet.addActionListener(this);
	}
	
	
	public static void main(String[] arg)
	{
		new Homepage2("damn");
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob= e.getSource();
		if(ob==ItemRes)
		{
			try 
			{
				frame.remove(SearOrRes);
				SearOrRes=null;
			}
			catch (NullPointerException e1) 
			{
				// TODO Auto-generated catch block
				
			}
			
			SearOrRes= new ReservationFlight(CurUser);
			scroll.setViewportView(SearOrRes);
			SearOrRes.updateUI();
		
		}
		else if(ob==ItemSear)
		{
			
				try 
				{
					frame.remove(SearOrRes);
					SearOrRes=null;
				}
				catch (NullPointerException e1) 
				{
					// TODO Auto-generated catch block
					
				}
				SearOrRes= new SearchFlights(CurUser);
				scroll.setViewportView(SearOrRes);
				SearOrRes.updateUI();
				
				
			
			
		}
		else if(ob==ItemEPDet)
		{
			new PEdit(CurUser);
		}
		else if(ob==ItemADet)
		{
			new AccDetails(CurUser);
		}
		else if(ob==ItemDel)
		{
			int y =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account??", "Delete Account", JOptionPane.YES_NO_CANCEL_OPTION);
			if(y==1)
			{	
				Connection c=  MyConn.connect();
				try {
					PreparedStatement ps=c.prepareStatement("delete from users where username=?");
					ps.setString(1,CurUser);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Account deleted successfully!");
					frame.dispose();
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(ob==ItemExit)
		{
			frame.dispose();
		}
		else if(ob==ItemSOut)
		{
			frame.dispose();
			new Login();
		}
		else if(ob==ItemEADet)
		{
			new AEdit(CurUser);
			
		}
		else if(ob==ItemHist)
		{
			new ReservationHistory(CurUser);
			
		}
		else if(ob==ItemFDet)
		{
			
			new FlightDetail(Integer.parseInt(JOptionPane.showInputDialog("Enter Flight Number")));
		}
		else if(ob==ItemEPayDet)
		{
			new PayEDet(CurUser);
		}
		else if(ob==ItemBFDet)
		{
			new BookedFlight(JOptionPane.showInputDialog("Enter Transaction ID"));
		}
		
		
	}

}
