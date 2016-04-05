package tpsmonitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ReadPropertiesFile {
	public static Properties read() {
		try {
			File file = new File( "sql.properties" );
			FileInputStream fi = new FileInputStream( file );
			Properties prop = new Properties();
			prop.load( fi );
			
			Enumeration<Object> enuKeys = prop.keys();
			while ( enuKeys.hasMoreElements() ) {
				String key = (String) enuKeys.nextElement();
				String value = prop.getProperty( key );
				System.out.println( key + ": " + value );
			}
			return prop;
		}
		catch ( FileNotFoundException e ) {
			e.printStackTrace();
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		return null;
	}
	public static Properties init() { // this is probably a horrible naming plan, but "init" is what im using as like a
										// "second main" method
		if ( WritePropertiesFile.checkExists() ) { return read(); }
		return null;
	}
}
