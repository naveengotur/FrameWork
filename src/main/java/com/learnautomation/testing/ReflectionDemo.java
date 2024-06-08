package com.learnautomation.testing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ReflectionDemo {
public static void main(String[]args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, Exception
{
	Student s1 = new Student();
	
   Class cls = s1.getClass();
   
   
   System.out.println(cls.getName());
   
   Constructor cons = cls.getConstructor();
   
   System.out.println(cons.getName());
	

   Method[] allMethods = cls.getMethods();
   
  for(Method m: allMethods)
  {
	  System.out.println(m.getName());
  }

  Field f = cls.getDeclaredField("univerName");
  
   System.out.println(f.getName());
   
   System.out.println(f.get(s1));
   
   Method m1= cls.getDeclaredMethod("breakTime");
   
   m1.setAccessible(true);
   
   m1.invoke(s1);
   
}


}