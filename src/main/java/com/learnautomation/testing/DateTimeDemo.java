package com.learnautomation.testing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeDemo {

	public static void main(String[]args)
	{
		
		Date d = new Date();
		
		System.out.println(d);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd_mm_yyyy_HH:mm:ss");
		
		System.out.println(dateformat.format(d));
 		
	}
}
