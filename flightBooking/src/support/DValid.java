package support;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;

import sun.util.resources.LocaleData;



public class DValid {

	public DValid() 
	{
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public static String[] genDate(String y,String m)
	{
		int ye=Integer.parseInt(y);
		
		String[] d1={"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, d2={"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"},d3={"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"},d4={"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
		if(m.equals("January")||m.equals("March")||m.equals("May")||m.equals("July")||m.equals("August")||m.equals("October")||m.equals("December"))
			return d1;
		else if(m.equals("April")||m.equals("June")||m.equals("September")||m.equals("November"))
			return d2;
		else if(m.equals("February")&& checkleap(ye))
			return d3;
		else
			return d4;
	}
	
	
	
	public static boolean checkleap(int y)
	{
		if(y%400==0)
		{
			
			return true;
		}
		else if(y%100==0)
		{
			
			return false;
		}
		else if(y%4==0)
			{
				
				return true;
			}
		else
			{
				
				return false;
			}
	}
	
	public static String getDate(String d, String m, String y)
	{
		String m1[]=new String[] {"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
		int i=1;
		while(!(m1[i].equals(m)))
		{
			
			i++;
		}
		
		
		return (d+"/0"+i+"/"+y);
	}
	
	
	public static String getWDay(String d, String m, String y)
	{
		String finalDay="";
		String input_date=getDate(d,m,y);
		try {
			
			  SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
			  Date dt1=format1.parse(input_date);
			  DateFormat format2=new SimpleDateFormat("EEEE"); 
			   finalDay=format2.format(dt1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalDay;
	}
	public static int getMonthNo(String month)
	{
		String m1[]=new String[] {"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
		int i=1;
		while(!(m1[i].equals(month)))
		{
			
			i++;
		}
		return i;
		
	}
	public static boolean getDateValidity(String d, String m, String y)
	{
		LocalDate t= LocalDate.now();
		LocalDate date=LocalDate.of(Integer.parseInt(y), getMonthNo(m), Integer.parseInt(d));
		long l= ChronoUnit.DAYS.between(t, date);
		if(l>=0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean getHoursValidity(String h, String m)
	{
		
		LocalTime t = LocalTime.now();
		LocalTime time=LocalTime.of(Integer.parseInt(h),Integer.parseInt(m));
		
				
		long l= ChronoUnit.HOURS.between(t,time);
		if(l>7)
		{
			return true;
					
		}
		else
		{
			return false;
		}
	}
	
	public static long getDaysDifference(String d, String m , String y)
	{
		LocalDate t= LocalDate.now();
		LocalDate date=LocalDate.of(Integer.parseInt(y), getMonthNo(m), Integer.parseInt(d));
		long l= ChronoUnit.DAYS.between(t, date);
		return l;
	}
	
	/*public static boolean getCancellationValidity(String d, String m,String y)
	{
		
	}*/
	
	
		

}
