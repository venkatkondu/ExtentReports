package listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	// by using this class I want to load the properties file 
	// And get the properties file values from this file

	
	//How to do this 
	
	
	public static String getPropertyValue()
	{

		File file;
		FileInputStream fis;
		Properties properties=new Properties();
		
		try {
			fis=new FileInputStream("./Files/config.properties");
			properties.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("config.properties file is not loaded from the path check the path=./Files/config.properties");
		// Actually I want to through an exception How to do this 
			try {
			throw new Exception("config.properties file is not loaded from the path check the path=./Files/config.properties");
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}
			
			
			e.printStackTrace();
		} catch (IOException e) {

			System.out.println("Unable to load the properties file from the FileInputStream please check the code ");
				try
				{
					throw new Exception("Unable to load the properties file from the FileInputStream please check the code ");
				}catch(Exception ee)
				{
					ee.printStackTrace();
				}
				
			e.printStackTrace();
		}
		
		
		
		
		
		return "String";
		
	}
	
	
	
	
}
