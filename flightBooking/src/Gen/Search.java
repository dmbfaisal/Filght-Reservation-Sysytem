package Gen;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

import support.DValid;
import support.MyConn;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class Search extends JPanel implements ItemListener
{
	JComboBox src,dest,year,month,day,clss,comp;
	JButton submit;
	
	 JLabel lnores;
	 JSpinner nores;
	public Search() 
	{
		setLayout(null);
		setSize(1225, 337);
		
		JLabel lblFlightNo = new JLabel("Source");
		lblFlightNo.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblFlightNo.setBounds(39, 93, 83, 28);
		add(lblFlightNo);
		
		JLabel lblSearchForFlights = new JLabel("Search for Flights");
		lblSearchForFlights.setFont(new Font("Lucida Sans Typewriter", Font.ITALIC, 18));
		lblSearchForFlights.setBounds(481, 23, 216, 34);
		add(lblSearchForFlights);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblDestination.setBounds(363, 93, 101, 28);
		add(lblDestination);
		
		src = new JComboBox();
		src.setModel(new DefaultComboBoxModel(new String[] {"start","Delhi","Lucknow","Mumbai"}));
		src.setBounds(125, 98, 132, 22);
		add(src);
		
		dest = new JComboBox();
		dest.setModel(new DefaultComboBoxModel(new String[] {"end","Delhi","Lucknow","Mumbai"}));
		dest.setBounds(504, 98, 132, 22);
		add(dest);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblDate.setBounds(776, 93, 83, 28);
		add(lblDate);
		
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"Year","2016"}));
		year.setBounds(872, 98, 89, 22);
		add(year);
		
		month = new JComboBox();
		month.setBounds(986, 98, 89, 22);
		add(month);
		
		day = new JComboBox();
		day.setBounds(1107, 98, 52, 22);
		add(day);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblClass.setBounds(310, 167, 52, 28);
		add(lblClass);
		
		clss = new JComboBox();
		clss.setModel(new DefaultComboBoxModel(new String[] {"All","Economy","Business"}));
		clss.setBounds(395, 172, 106, 22);
		add(clss);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Lao UI", Font.PLAIN, 17));
		lblCompany.setBounds(627, 167, 83, 28);
		add(lblCompany);
		
		comp = new JComboBox();
		comp.setModel(new DefaultComboBoxModel(new String[] {"Air India","Indigo","Kingfisher"}));
		comp.setBounds(752, 172, 132, 22);
		add(comp);
		
		submit = new JButton("Get Results");
		submit.setBounds(492, 236, 131, 40);
		year.addItemListener(this);
		month.addItemListener(this);
		
		add(submit);
		
		
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}
	public void itemStateChanged(ItemEvent e) 
	{
		Object ob= e.getSource();
		if(ob==year)
		{if(year.getSelectedItem().toString().equals("Year"))
		{
		month.setModel(new DefaultComboBoxModel(new String[] {"Month"}));
		day.setModel(new DefaultComboBoxModel(new String[] {"Day"}));
		}
		else
		{
		
			month.setModel(new DefaultComboBoxModel(new String[] {"Month","January","February","March","April","May","June","July","August","September","October","November","December"}));
		}
		}
		else if(ob==month)
		{
			String[] t=DValid.genDate(year.getSelectedItem().toString(), month.getSelectedItem().toString());
			day.setModel(new DefaultComboBoxModel(t));
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
}
