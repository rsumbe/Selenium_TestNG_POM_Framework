package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ReadConfigProperty {
	protected InputStream input = null;
	protected Properties prop;

	public ReadConfigProperty() {

		try {

//		  String filepath =   ReadConfigProperty.class.getClassLoader().getResource("\\config.properties").getPath();
//		  System.out.println(filepath);
//		  input =  ReadConfigProperty.class.getClassLoader().getResourceAsStream("\\config.properties");
//		 C:\\Users\\P10500071\\eclipse-workspace
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\P10500071\\git\\Selenium_TestNG_POM_Framework\\MyTestNG-POM_Framework\\src\\test\\resources\\config.properties");
		
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getUrl() {
		if (prop.getProperty("url") == null) {
			return "";
		} else
			return prop.getProperty("url");
	}

	public String getBrowser() {
		if (prop.getProperty("browser") == null) {
			return "";
		} else
			return prop.getProperty("browser");
	}

	public String getValue(String key) {
		if (prop.getProperty(key) == null) {
			return "";
		} else
			return prop.getProperty(key);
	}

}
