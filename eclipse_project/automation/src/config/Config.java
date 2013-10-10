package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	protected final static String settingsFileName = "settings";
	
	private static Config INSTANCE = null;
	
	protected Properties properties;
	
	private Config() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(settingsFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No existe el archivo de configuracion: " + settingsFileName);
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede leer el archivo de configuracion: " + settingsFileName);
			e.printStackTrace();
			System.exit(0);
		}
	}
	
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Config();
        }
    }
 
    public static Config getInstance() {
        createInstance();
        return INSTANCE;
    }
    
    public String getProperty(String key) {
    	String value = this.properties.getProperty(key);
    	System.out.println("leyendo configuracion " + key + " = `" + value + "`");
    	return value;
    }
}
