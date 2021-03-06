package com.solvd.utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.services.*;

/**
 * Class for reading from properties
 * 
 * @author Iryna Iemelianova
 */
public class PropertyReader {

	private static String separator = File.separator;
	private static String PATH = "src" + separator + "main" + separator + "resources" + separator
			+ "constants.properties";

	private final static Logger LOGGER = LogManager.getLogger(PropertyReader.class);

	private static DataATM dataATM = new DataATM();
	
	
	/**
	   * Getting value from properties by the key
	   * 
	   * @param PATH to the file
	   * @param key to the value
	   * @return value of the key
	   * @throws IOException if file does not exist
	   * @see {@link FileInputStream}
	   * @see {@link Properties#getProperty}
	   */
	public static String getValueFromProperties(String key) {
		Properties properties = new Properties();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(PATH);
			properties.load(inputStream);
			inputStream.close();
			String prop = properties.getProperty(String.valueOf(key));
			if(prop == null) {
				LOGGER.info ("Missing value for key " + key);
				dataATM.exit();
		}
			return prop;
			
		} catch (IOException e) {
			LOGGER.info("File does not exist");
					
			return "default";
		}
		

	}
}
