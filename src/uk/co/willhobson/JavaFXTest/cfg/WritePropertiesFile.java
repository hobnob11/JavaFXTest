package uk.co.willhobson.JavaFXTest.cfg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesFile {
	public static void write()
	{
		try{
			Properties properties = new Properties();
			properties.setProperty("server_address", "tmp.willhobson.co.uk");
			properties.setProperty("database", "db");
			properties.setProperty("table", "data_table");
			properties.setProperty("user", "guest");
			properties.setProperty("password", "password");
			
			File file = new File("sql.properties");
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, "SQL Config");
			fileOut.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public static boolean checkExists(){
		File f = new File("sql.properties");
		if(f.exists() && !f.isDirectory()){
			return true;
		}
		return false;
	}
	public static boolean init(){
		if(!checkExists()){
			write();
			return true;
		}
		return false;
	}
}
