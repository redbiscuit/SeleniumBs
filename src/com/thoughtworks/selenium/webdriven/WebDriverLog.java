package com.thoughtworks.selenium.webdriven;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class WebDriverLog {

	private static WebDriverFileUtil fileUtil = null;
	final static String prop_path = "lib//log4j.properties";
	static String prjectPath = System.getProperty("user.dir")+"/";
	
	static Logger logger = Logger.getRootLogger();
	
	public static void logInfo(String s){
		PropertyConfigurator.configure(prop_path);
		logger.info(s);
	}
	
	public void info(String s){
		PropertyConfigurator.configure(prop_path);
		logger.info(s);
	}
	
	public static void logInfo(int i){
		PropertyConfigurator.configure(prop_path);
		logger.info(String.valueOf(i));
	}
	
	public static void logInfo(Double d){
		PropertyConfigurator.configure(prop_path);
		logger.info(String.valueOf(d));
	}
	
	
	public static void logDebug(String s){
		PropertyConfigurator.configure(prop_path);
		logger.debug(s);
	}
	
	public static void logDebug(Double d){
		PropertyConfigurator.configure(prop_path);
		logger.debug(String.valueOf(d));
	}
	
	public static void logDebug(int i){
		PropertyConfigurator.configure(prop_path);
		logger.debug(String.valueOf(i));
	}
	
	public static void logError(String s){
		PropertyConfigurator.configure(prop_path);
		logger.error(s);
	}
	
	public static void logError(Double d){
		PropertyConfigurator.configure(prop_path);
		logger.error(String.valueOf(d));
	}
	
	public static void logError(int i){
		PropertyConfigurator.configure(prop_path);
		logger.error(String.valueOf(i));
	}
	
}
