package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider(){
		
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getChromePath(){
		String cPath = pro.getProperty("chromePath");
		return cPath;
	}
	
	public String getIEPath(){
		String iePath = pro.getProperty("IEPath");
		return iePath;
	}
	
	public String getApplicatonUrl(){
		String url = pro.getProperty("url");
		return url;
	}

}
