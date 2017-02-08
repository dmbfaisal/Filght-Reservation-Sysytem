package Gen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
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
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import support.DValid;
import support.MyConn;

public class ReservationFlight extends JPanel
{
	Search search;
	Result result;
	String user;
	
	String det[][];
	int no;

	public ReservationFlight(String u)
	{
		user=u;
		setLayout(null);
		setPreferredSize(new Dimension(1800,1000));
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
		search.submit.setBounds(481, 284, 131, 40);
		search.setVisible(true);
		search.submit.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Object o= e.getSource();
				if(o==search.submit && DValid.getDateValidity(search.day.getSelectedItem().toString(),search.month.getSelectedItem().toString(),search.year.getSelectedItem().toString()))
				{
					
					System.out.println("step");
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
					int m=(Integer)search.nores.getValue();
					det=new String[m][13];
					no=m;
					
					System.out.println("Row Index of table"+m);
					
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
						
						int check;
						while(rs.next())
						{
							check=0;
							System.out.println("step");
							String temp;
							
							if(cl.equals("All"))
							{System.out.println("step1");
							if(rs.getInt("economy")!=0 && rs.getInt("business")!=0)
								{
								temp=null;
								check=1;
								
								
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
							{System.out.println("step2");
								temp="Economy";
								
								
							}
							else
							{
								temp="Business";
								
								
							}
							
							
							if(check==0)
							{
								
							result.table.insertResult(new String[]{(String.valueOf(rs.getInt("flightno"))).toString(),s,de,rs.getString("time"),co,temp,rs.getString("fare")});
							}
							
							else
							{
								result.table.insertResult(new String[]{(String.valueOf(rs.getInt("flightno"))).toString(),s,de,rs.getString("time"),co,"Economy",rs.getString("fare")});
								result.table.insertResult(new String[]{(String.valueOf(rs.getInt("flightno"))).toString(),s,de,rs.getString("time"),co,"Business",rs.getString("fare")});
							}
							//repaint();
							System.out.println(result.table.getModel().getValueAt(0,4));
							result.add(result.b);
							(result.b).addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) 
								{
									String talti=result.table.getValueAt(result.table.getSelectedRow(), 3).toString();
									if((DValid.getDaysDifference(search.day.getSelectedItem().toString(), search.month.getSelectedItem().toString(), search.year.getSelectedItem().toString())==0 && DValid.getHoursValidity(talti.substring(0,talti.indexOf(":")),talti.substring(talti.indexOf(":")+1,talti.length()))||DValid.getDaysDifference(search.day.getSelectedItem().toString(), search.month.getSelectedItem().toString(), search.year.getSelectedItem().toString())>0))
									{
										System.out.println("xhch");
									
									int row=result.table.getSelectedRow();
									System.out.println(row+"got selected row");
									if(row!=-1)
									{
										String name=null, passport=null, card=null;
										TableModel d =result.table.getModel();
										Connection c=MyConn.connect();
										System.out.println("connected to select card no");
										try {
											PreparedStatement ps= c.prepareStatement("select cno, first , last, passport from users where username=?");
											ps.setString(1,user);
											ResultSet rs= ps.executeQuery();
											if(rs.next())
											{
												if(rs.getString(1)==null)
												{
													card=JOptionPane.showInputDialog("Enter card no for payment!");
													while(card.length()!=16)
													{
														
														
															card=JOptionPane.showInputDialog("Enter card no for payment!");//do check for no.
															
															
														
													}
												}
												else
												{
													int y= JOptionPane.showConfirmDialog(null, "Use Default Card??", "Card No.", JOptionPane.YES_NO_CANCEL_OPTION);
													if(y==0)
													{
														card=rs.getString(1);
													}
													else
													{
														card=JOptionPane.showInputDialog("Enter card no for payment!");
														while(card.length()!=16)
														{
															
															
																card=JOptionPane.showInputDialog("Enter card no for payment!");//do check for no.
																
																
															
														}
														
													}
												}
												int j=JOptionPane.showConfirmDialog(null, "Are you one of the passengers?","Passenger Enquiry",JOptionPane.YES_NO_OPTION);
														System.out.println("out put for passenger question"+j);
												if(j==0)
												{
													name=rs.getString(2)+" "+rs.getString(3);
													passport=rs.getString(4);
													System.out.println(name+"  "+passport);
													
												}
												else
												{
													name="";
													passport="";
												}
												
												
												
											}
										} catch (HeadlessException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
										System.out.println("No of Passangers="+no);
										 int id=Result.genID();
										for(int i=0;i<no;i++)
										{
											det[i][0]= String.valueOf(d.getValueAt(row,0));
											det[i][4]=String.valueOf(d.getValueAt(row,1));
											det[i][5]=String.valueOf(d.getValueAt(row,2));
											det[i][6]=d.getValueAt(row,3).toString();
											det[i][7]=String.valueOf(d.getValueAt(row,4));
											det[i][8]=String.valueOf(d.getValueAt(row,5));
											det[i][9]=user;
											det[i][10]=String.valueOf(id++);
											det[i][11]=card;
											det[i][12]=String.valueOf(Integer.parseInt(d.getValueAt(row, 6).toString())*1);
											det[i][3]=search.day.getSelectedItem().toString()+" "+search.month.getSelectedItem().toString()+" "+search.year.getSelectedItem().toString();
											
											
											
											
											
											
											
										}
										
										new ResDetails(name, passport, no);	
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please! Select a Flight !");
									}
							
									
								}
									else
									{
										JOptionPane.showMessageDialog(null, "There Should be a minimum time gap of 12 hours between the current time and the flight to be booked!!");
									}
								}
								
							}
							);
							System.out.println("added");
							result.updateUI();
							
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				
				
			}
				else
				{
					JOptionPane.showMessageDialog(null, "Please choose a future or present date!!");
				}
		}});
		
		search.lnores = new JLabel("No. Of Reservations");
		search.lnores.setFont(new Font("Lao UI", Font.PLAIN, 17));
		search.lnores.setBounds(423, 234, 156, 28);
		search.add(search.lnores);
		
		search.nores = new JSpinner();
		search.nores.setBounds(591, 239, 30, 22);
		search.add(search.nores);
		add(search);
		
		
		setVisible(false);
		setVisible(true);

		
		

		}
	
	
	
	public class ResDetails extends JDialog implements ActionListener
	{
		JButton enter,cancel;
		JLabel per ,pas;
		JTextField perName, passno;
		
		int t;
		
		

		public ResDetails(String ad, String adpass, int p) 
		{
			setModal(true);
			getContentPane().setLayout(null);
			setSize(400, 400);
			setTitle("Enter Passenger Details");
			
			
			
			
			per = new JLabel("Passenger's Name");
			per.setFont(new Font("Tahoma", Font.PLAIN, 14));
			per.setBounds(22, 51, 110, 23);
			getContentPane().add(per);
			
			pas = new JLabel("Passport No.");
			pas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			pas.setBounds(22, 141, 110, 23);
			getContentPane().add(pas);
			
			perName = new JTextField();
			perName.setBounds(173, 52, 165, 22);
			getContentPane().add(perName);
			perName.setColumns(10);
			
			passno = new JTextField();
			passno.setColumns(10);
			passno.setBounds(173, 142, 165, 22);
			getContentPane().add(passno);
			
			enter = new JButton("Enter");
			enter.setBounds(122, 220, 110, 35);
			getContentPane().add(enter);
			
			cancel = new JButton("Cancel");
			cancel.setBounds(122, 284, 110, 35);
			getContentPane().add(cancel);
			t=p;
			
			
			 
			if(ad.length()!=0&&adpass.length()!=0)
			{
				 
				det[0][1]=ad;
				det[0][2]=adpass;
				t--;
				System.out.println("self Details");
			}
			enter.addActionListener(this);
			cancel.addActionListener(this);
			
			
			
			setVisible(true);
			
		}
		
		


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Object ob=e.getSource();
			if(ob==enter)
			{
				
				String pe=perName.getText();
				String pa=passno.getText();
				if(!(pe.isEmpty()||pa.isEmpty())&& pa.length()==9 )
				{
					if(t>0)
					{
						System.out.println(no-t);
						det[no- t][1]=pe;
						det[no-t][2]=pa;
						System.out.println(det[no- t][1]);
						System.out.println(det[no- t][2]);
						t--;
						perName.setText(null);
						passno.setText(null);
					}
					if(t==0)
					{
						dispose();
						JOptionPane.showMessageDialog(null,"Flight booked for "+no+" passengers! Please Note the Transaction ID for future Reference! Thank You!");
						new FinalRes(det,no);
						
					}
					
						
					
					
			
				}
				else
				{
					if(passno.getText().length()!=9)
						JOptionPane.showMessageDialog(null, "Enter Valid Passport No.!!");
					else
					JOptionPane.showMessageDialog(null, "Fill Both the Details!!");
				}
					
			}
			if(ob==cancel)
			{
				dispose();
				
			}
		
			
		}
		
		
		


		
		



		
	}
	}




