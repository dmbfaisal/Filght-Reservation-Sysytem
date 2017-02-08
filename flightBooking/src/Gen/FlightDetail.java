package Gen;

import javax.management.loading.DefaultLoaderRepository;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ListModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JList;

import support.MyConn;
import javax.swing.JTextArea;

public class FlightDetail extends JDialog
{
	private JTextField flightn;
	private JTextField src;
	private JTextField dest;
	private JTextField comp;
	private JTextField fare;
	JTextArea fDays,clss;
	private JLabel lblTime;
	private JTextField time;

	public FlightDetail(int flightno) 
	{
		getContentPane().setLayout(null);
		setTitle("Flight Details: "+flightno);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JLabel lblFlightNumber = new JLabel("Flight Number");
		lblFlightNumber.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFlightNumber.setBounds(63, 47, 106, 39);
		getContentPane().add(lblFlightNumber);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblSource.setBounds(63, 117, 106, 39);
		getContentPane().add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDestination.setBounds(63, 188, 106, 39);
		getContentPane().add(lblDestination);
		
		JLabel lblClass = new JLabel("Company");
		lblClass.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblClass.setBounds(63, 261, 106, 39);
		getContentPane().add(lblClass);
		
		JLabel lblClass_1 = new JLabel("Class");
		lblClass_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblClass_1.setBounds(63, 328, 106, 39);
		getContentPane().add(lblClass_1);
		
		JLabel lblFlightdays = new JLabel("FlightDays");
		lblFlightdays.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFlightdays.setBounds(63, 415, 106, 39);
		getContentPane().add(lblFlightdays);
		
		JLabel lblFare = new JLabel("Fare");
		lblFare.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFare.setBounds(63, 655, 106, 39);
		getContentPane().add(lblFare);
		
		flightn = new JTextField();
		flightn.setBounds(308, 56, 164, 22);
		getContentPane().add(flightn);
		flightn.setColumns(10);
		
		src = new JTextField();
		src.setColumns(10);
		src.setBounds(308, 126, 164, 22);
		getContentPane().add(src);
		
		dest = new JTextField();
		dest.setColumns(10);
		dest.setBounds(308, 197, 164, 22);
		getContentPane().add(dest);
		
		comp = new JTextField();
		comp.setColumns(10);
		comp.setBounds(308, 270, 164, 22);
		getContentPane().add(comp);
		
		fare = new JTextField();
		fare.setColumns(10);
		fare.setBounds(308, 664, 164, 22);
		getContentPane().add(fare);
		
		fDays = new JTextArea();
		fDays.setBounds(308, 437, 181, 114);
		getContentPane().add(fDays);
		
		clss = new JTextArea();
		clss.setBounds(308, 337, 164, 56);
		getContentPane().add(clss);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTime.setBounds(63, 603, 106, 39);
		getContentPane().add(lblTime);
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(308, 612, 164, 22);
		getContentPane().add(time);
		setSize(800, 800);
		
		Connection c= MyConn.connect();
		try {
			PreparedStatement ps=c.prepareStatement("select * from details where flightno=?");
			ps.setInt(1, flightno);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Onside Table");
				flightn.setText(String.valueOf(rs.getInt("flightno")));
				src.setText(rs.getString(2));
				dest.setText(rs.getString(3));
				comp.setText(rs.getString(4));
				time.setText(rs.getString(7));

				String s="";
				if(!(rs.getInt("business")==0))
					s=s+"Business"+"\n";
				if(!(rs.getInt("economy")==0))
					s=s+"Economy"+"\n";
						clss.setText(s);
					s="";
				
				
					if(rs.getString(8).equals("1"))
						s=s+"Monday"+"\n";
					if(rs.getString(9).equals("1"))
						s=s+"Tuesday"+"\n";
					if(rs.getString(10).equals("1"))
						s=s+"Wednesday"+"\n";
					if(rs.getString(11).equals("1"))
						s=s+"Thursday"+"\n";
					if(rs.getString(12).equals("1"))
						s=s+"Friday"+"\n";
					if(rs.getString(13).equals("1"))
						s=s+"Saturday"+"\n";
					if(rs.getString(14).equals("1"))
						s=s+"Sunday"+"\n";
				
				fDays.setText(s);
				fare.setText(rs.getString("fare"));
				
				flightn.setEditable(false);
				src.setEditable(false);
				dest.setEditable(false);
				comp.setEditable(false);
				fDays.setEditable(false);
				clss.setEditable(false);
				fare.setEditable(false);
				time.setEditable(false);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new FlightDetail(1234);

	}
}
