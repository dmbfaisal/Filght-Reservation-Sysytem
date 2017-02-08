
package Gen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import support.MyConn;


public class AccDetails extends JDialog 
{
	RPanel details;

	public AccDetails(String u) 
	{
		setMaximumSize(new Dimension(1920,1080));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(1200,600);
		setModal(true);
		
		 details = new RPanel();
		 /*JPanel panelToScroleOver = new JPanel();
			panelToScroleOver.setLayout(new BorderLayout());
			panelToScroleOver.add(details);*/
		
		
		
		details.remove(details.submit);
		details.remove(details.cancel);
		details.remove(details.year);
		details.remove(details.month);
		details.remove(details.date);
		JTextField d= new JTextField();
		d.setColumns(10);
		d.setBounds(1168, 271, 192, 22);
		details.add(d);
		
		
		details.setPreferredSize(new Dimension(details.getWidth(), details.getHeight()));
		JScrollPane scroll = new JScrollPane(details, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		add(scroll);
		
		/*JPanel panelToScroleOver = new JPanel();
		panelToScroleOver.setLayout(new BorderLayout());
		panelToScroleOver.add(details);*/
		
		/*JTabbedPane documents = new JTabbedPane();
		details.setPreferredSize(new Dimension(details.getWidth(), details.getHeight()));*/
		//details.setPreferredSize(new Dimension(details.getWidth(), details.getHeight()));
		//JScrollPane editorScroll = new JScrollPane(details);
		//documents.add("doc1", editorScroll);
		
		//add(editorScroll);
		
		
		
	
		
		Connection c= MyConn.connect();
		try {
			PreparedStatement ps =c.prepareStatement("select * from users where username=?");
			ps.setString(1, u);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				details.user.setText(rs.getString("username"));
				details.fname.setText(rs.getString("first"));
				details.lname.setText(rs.getString("last"));
				details.pno.setText(rs.getString("passport"));
				details.email.setText(rs.getString("email"));
				d.setText(rs.getString("dob"));
				
				
				if(rs.getString("gender").equalsIgnoreCase("male"))
					details.m.setSelected(true);
				else
					details.f.setSelected(true);
				
				details.mob.setText(rs.getString("mob"));
				details.aline1.setText(rs.getString("line1"));
				details.aline2.setText(rs.getString("line2"));
				details.state.setText(rs.getString("state"));
				details.city.setText(rs.getString("city"));
				details.zip.setText(rs.getString("zip"));
				
				try {
					if(rs.getString("ctype").equalsIgnoreCase("c"))
						details.ccard.setSelected(true);
					else
						details.dcard.setSelected(true);
					details.cno.setText(rs.getString("cno"));
					details.cval.setText(rs.getString("cval"));
					details.ccode.setText(rs.getString("code"));
					details.pcheck.setSelected(true);
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.println("Payment Details yet not Defined");
					details.pcheck.setSelected(false);
				}
				
				details.pcheck.setEnabled(false);
				details.user.setEditable(false);
				details.fname.setEditable(false);
				details.lname.setEditable(false);
				details.pno.setEditable(false);
				details.email.setEditable(false);
				d.setEditable(false);
				
				
				
				details.m.setEnabled(false);
				details.f.setEnabled(false);;
				details.mob.setEditable(false);
				details.aline1.setEditable(false);
				details.aline2.setEditable(false);
				details.state.setEditable(false);
				details.city.setEditable(false);
				details.zip.setEditable(false);
				details.pass.setEditable(false);
				details.repass.setEditable(false);
				
				
					details.ccard.setEnabled(false);
				
					details.dcard.setEnabled(false);
				details.cno.setEditable(false);
				details.cval.setEditable(false);
				details.ccode.setEditable(false);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);
		
	}
	
	public static void main(String a[])
	{
		new AccDetails("faisal");
	}

}
