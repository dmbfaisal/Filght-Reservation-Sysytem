package admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import support.MyConn;

public class EditFlight extends JPanel implements ActionListener
{
	private JTextField fno;
	private JTextField time;
	JComboBox src,dest,comp;
	JSpinner fare;
	JRadioButton mon,tue,wed,thur,fri,sat,sun,b,e;
	Connection c;
	String curF;
	JButton submit;

	public EditFlight(String fno1) 
	{
		curF=fno1;
		setLayout(null);
		setSize(1200, 600);
		
		JLabel lblFlightNo = new JLabel("Flight No");
		lblFlightNo.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblFlightNo.setBounds(433, 78, 83, 28);
		add(lblFlightNo);
		
		fno = new JTextField();
		fno.setBounds(572, 83, 128, 22);
		add(fno);
		fno.setColumns(10);
		
		JLabel label = new JLabel("Source");
		label.setFont(new Font("Lao UI", Font.PLAIN, 17));
		label.setBounds(277, 169, 83, 28);
		add(label);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblDestination.setBounds(728, 169, 113, 28);
		add(lblDestination);
		
		JLabel lblRunningDays = new JLabel("Running Days");
		lblRunningDays.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblRunningDays.setBounds(54, 241, 113, 28);
		add(lblRunningDays);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblClass.setBounds(277, 337, 83, 28);
		add(lblClass);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblCompany.setBounds(728, 337, 83, 28);
		add(lblCompany);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblTime.setBounds(277, 426, 83, 28);
		add(lblTime);
		
		JLabel lblFare = new JLabel("Fare");
		lblFare.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblFare.setBounds(728, 434, 83, 28);
		add(lblFare);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(491, 519, 131, 40);
		add(submit);
		
		src = new JComboBox();
		src.setModel(new DefaultComboBoxModel(new String[] {"Delhi", "Lucknow", "Mumbai"}));
		src.setBounds(372, 174, 128, 22);
		add(src);
		
		dest = new JComboBox();
		dest.setModel(new DefaultComboBoxModel(new String[] {"Delhi", "Lucknow", "Mumbai"}));
		dest.setBounds(871, 174, 128, 22);
		add(dest);
		
		comp = new JComboBox();
		comp.setModel(new DefaultComboBoxModel(new String[] {"Air India", "Indigo", "Kingfisher"}));
		comp.setBounds(871, 342, 128, 22);
		add(comp);
		
		time = new JTextField();
		time.setText("hr:min");
		time.setBounds(372, 431, 128, 22);
		add(time);
		time.setColumns(10);
		
		 fare = new JSpinner();
		fare.setBounds(871, 439, 100, 22);
		add(fare);
		
		
		mon = new JRadioButton("Monday");
		mon.setBounds(224, 245, 83, 25);
		add(mon);
		
		tue = new JRadioButton("Tuesday");
		tue.setBounds(333, 245, 83, 25);
		add(tue);
		
		wed = new JRadioButton("Wednesday");
		wed.setBounds(451, 245, 95, 25);
		add(wed);
		
		thur = new JRadioButton("Thursday");
		thur.setBounds(570, 245, 83, 25);
		add(thur);
		
		fri = new JRadioButton("Friday");
		fri.setBounds(699, 245, 83, 25);
		add(fri);
		
		sat = new JRadioButton("Saturday");
		sat.setBounds(818, 245, 83, 25);
		add(sat);
		
		sun = new JRadioButton("Sunday");
		sun.setBounds(939, 245, 83, 25);
		add(sun);
		
		b = new JRadioButton("Business");
		b.setBounds(333, 341, 83, 25);
		add(b);
		
		e = new JRadioButton("Economy");
		e.setBounds(433, 341, 83, 25);
		add(e);
		
		c=MyConn.connect();
		try {
			PreparedStatement ps= c.prepareStatement("select * from details where flightno=?");
			ps.setInt(1, Integer.parseInt(curF));
			ResultSet rs= ps.executeQuery();
			
			if(rs.next())
			{
				this.fno.setText(String.valueOf(rs.getInt(1)));
				src.setSelectedItem(rs.getString(2));
				dest.setSelectedItem(rs.getString(3));
				comp.setSelectedItem(rs.getString(4));
				if(rs.getInt(5)==1)
					b.setSelected(true);
				else
					b.setSelected(false);
				
				if(rs.getInt(6)==1)
					e.setSelected(true);
				else
					e.setSelected(false);
				
				time.setText(rs.getString(7));
				
				if(rs.getInt(8)==1)
					mon.setSelected(true);
				else
					mon.setSelected(false);
				
				if(rs.getInt(9)==1)
					tue.setSelected(true);
				else
					tue.setSelected(false);
				
				if(rs.getInt(10)==1)
					wed.setSelected(true);
				else
					wed.setSelected(false);
				
				if(rs.getInt(11)==1)
					thur.setSelected(true);
				else
					thur.setSelected(false);
				
				if(rs.getInt(12)==1)
					fri.setSelected(true);
				else
					fri.setSelected(false);
				
				if(rs.getInt(13)==1)
					sat.setSelected(true);
				else
					sat.setSelected(false);
				
				if(rs.getInt(14)==1)
					sun.setSelected(true);
				else
					sun.setSelected(false);
				
				fare.setValue(rs.getInt(15));
				fno.setEditable(false);
				submit.addActionListener(this);
			}
			else
			{
				submit.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Given Flight Number Does not Exist");
			}
			
		} 
		catch (NumberFormatException e1) 
		{
			submit.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Given Flight Number Does not Exist");
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		setVisible(true);
	}
	
  

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(!(src.getSelectedItem().toString().equals(dest.getSelectedItem().toString())))
		{
			Connection c= MyConn.connect();
		
		try 
		{
			
			PreparedStatement ps = c.prepareStatement("update  details set fare=?, source=?, destination=?, company=?, business=?, economy=?, time=?,monday=?,tuesday=?,wednesday=?,thursday=?,friday=?,saturday=?,sunday=? where flightno=?");
			ps.setInt(15, Integer.parseInt( curF));
			ps.setString(2, src.getSelectedItem().toString());
			ps.setString(3, dest.getSelectedItem().toString());
			ps.setString(4, comp.getSelectedItem().toString());
			
			if(b.isSelected())
				ps.setInt(5,1 );
			else
				ps.setInt(5,0 );
			
			if(e.isSelected())
				ps.setInt(6,1 );
			else
				ps.setInt(6,0 );
			
			if(mon.isSelected())
				ps.setInt(8,1 );
			else
				ps.setInt(8,0 );
			if(tue.isSelected())
				ps.setInt(9,1 );
			else
				ps.setInt(9,0 );
			
			if(wed.isSelected())
				ps.setInt(10,1 );
			else
				ps.setInt(10,0 );
			if(thur.isSelected())
				ps.setInt(11,1 );
			else
				ps.setInt(11,0 );
			if(fri.isSelected())
				ps.setInt(12,1 );
			else
				ps.setInt(12,0 );
			if(sat.isSelected())
				ps.setInt(13,1 );
			else
				ps.setInt(13,0 );
			if(sun.isSelected())
				ps.setInt(14,1 );
			else
				ps.setInt(14,0 );
			ps.setString(7,time.getText());
			ps.setInt(1,(Integer)fare.getValue() );
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Database Updated");
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(null, "Error in flight no input");
		}
	  }
		else
		{
			JOptionPane.showMessageDialog(null, "Source and Destination Cannot be same");
		}
		
	}
		
	}


