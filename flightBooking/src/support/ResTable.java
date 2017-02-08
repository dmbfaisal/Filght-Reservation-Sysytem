package support;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ResTable extends JTable
{
	private DefaultTableModel fs;

	public ResTable() 
	{
		
		
	}
	public void createTable()
	{
		
	    fs= new DefaultTableModel();
	    
		fs.addColumn("Flight No.");
		fs.addColumn("Source");
		fs.addColumn("Destination");
		fs.addColumn("Time");
		fs.addColumn("Company");
		fs.addColumn("Class");
		fs.addColumn("Fare");
		
		
		
		setModel(fs);
		getColumnModel().getColumn(1).setPreferredWidth(106);
		getColumnModel().getColumn(2).setPreferredWidth(106);
		getColumnModel().getColumn(3).setPreferredWidth(106);
		getColumnModel().getColumn(4).setPreferredWidth(110);
		
	
	}
	public void insertResult(String contents[])
	{
		fs.addRow(contents);
	}
	public void insertCol(String colname)
	{
		fs.addColumn(colname);
	}

}
