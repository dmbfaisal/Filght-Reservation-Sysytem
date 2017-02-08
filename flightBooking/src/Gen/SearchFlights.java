package Gen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import support.DValid;
import support.MyConn;

public class SearchFlights extends JPanel 
{
	Search search;
	Result result;
	String user;
	

	public SearchFlights(String u) 
	{
		user=u;
		setLayout(null);
		setPreferredSize(new Dimension(1800,900));
		
		create();
		
		
	}
	
	public void create()
	{
		try 
		{
			remove(search);
			search=null;
		} 
		catch (NullPointerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			remove(result);
			result=null;
		} 
		catch (NullPointerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//remove(Vdetails);
		search = new Search();
		search.setLocation(283, 39);
		
		
		search.setVisible(true);
		add(search);
		
		search.submit.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Object o= e.getSource();
				if(o==search.submit)
				{
					
					 result = new Result(283, 498, 1225, 427);
					add(result);
					
					Connection c=  MyConn.connect();
					PreparedStatement ps;
					ResultSet rs;
					String q;
					String s=search.src.getSelectedItem().toString();
					String de=search.dest.getSelectedItem().toString();
					String da=DValid.getWDay(search.day.getSelectedItem().toString(),search.month.getSelectedItem().toString(),search.year.getSelectedItem().toString());
					String co=search.comp.getSelectedItem().toString();
					String cl=search.clss.getSelectedItem().toString();
					
					
					try {
						if(co.equals("All")&& (!cl.equals("All")))
							
						{
							System.out.println("Condition 1");
							q="select * from details where source=? and destination=? and "+da+"='1' and "+cl.toLowerCase()+" >'0' ";
							ps=c.prepareStatement(q);
							ps.setString(1,s);
							ps.setString(2,de );
							
							rs=ps.executeQuery();
							
						}
						else if((!co.equals("All"))&& cl.equals("All"))
						{
							System.out.println("Condition 2");
							q="select * from details where source=? and destination=? and "+da+"='1' and company=? ";
							ps=c.prepareStatement(q);
							ps.setString(1,s);
							ps.setString(2,de );
							
							ps.setString(3,co);
							rs=ps.executeQuery();
						}
						else if(co.equals("All")&& cl.equals("All"))
						{
							System.out.println("Condition 3");
							q="select * from details where source=? and destination=? and "+da+"='1' ";
							ps=c.prepareStatement(q);
							ps.setString(1,s);
							ps.setString(2,de );
							
							rs=ps.executeQuery();
							
						}
						else
						{
							System.out.println("Condition 4");
							q="select * from details where source=? and destination=? and "+da+"='1' and "+cl.toLowerCase()+" >'0' and company=? ";
							ps=c.prepareStatement(q);
							ps.setString(1,s);
							ps.setString(2,de );
							ps.setString(3,co);
							rs=ps.executeQuery();
							
						}
						while(rs.next())
						{
							String temp;
				
							if(cl.equals("All"))
							{
							if(rs.getInt("economy")!=0 && rs.getInt("business")!=0)
								{
								temp="All";
								
								
								}
							else if(rs.getInt("economy")==0 && rs.getInt("business")!=0)
								{
								temp="Business";
								
								
								}
							else
								{
								temp="Economy";
								
								}
							}
							else if(cl.equals("Economy"))
							{
								temp="Economy";
								
								
							}
							else
							{
								temp="Business";
								
								
							}
								
							result.table.insertResult(new String[]{(String.valueOf(rs.getInt("flightno"))).toString(),s,de,rs.getString("time"),co,temp,rs.getString("fare")});
							
							result.updateUI();
							
							
							
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			}});
		
		JLabel WelLabel = new JLabel("Welcome "+user);
		WelLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 17));
		WelLabel.setBounds(1574, 47, 199, 40);
		add(WelLabel);
		
		
		setVisible(false);
		setVisible(true);
		
	}
}
