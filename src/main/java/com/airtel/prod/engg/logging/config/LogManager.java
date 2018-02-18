package com.airtel.prod.engg.logging.config;

import java.io.File;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;

import com.airtel.prod.engg.logging.helper.impl.LoggerHelperFtlImpl;
import com.airtel.prod.engg.logging.helper.impl.LoggerHelperLog4j2Impl;
import com.airtel.prod.engg.logging.logger.Logger;
import com.airtel.prod.engg.logging.logger.impl.LoggerImpl;

public class LogManager {

	public static String templateDir;
	
	public static String templateFile;
	
	private static Configuration configuration;
	
	private static LoggerContext loggerContext;
	
	public static Logger getLogger(Class<?> clazz){
		return new LoggerImpl(new LoggerHelperLog4j2Impl(clazz));
	}
	
	public static Logger getLogger(String className){
		return new LoggerImpl(new LoggerHelperLog4j2Impl(className));
	}
	
	public static Logger getLoggerWithTemplate(Class<?> clazz){
		return new LoggerImpl(new LoggerHelperFtlImpl(clazz));
	}
	
	public static Logger getLoggerWithTemplate(String className){
		return new LoggerImpl(new LoggerHelperFtlImpl(className));
	}
	
	public static Logger getLoggerWithTemplate(String templateDir, String templateFile, Class<?> clazz){	
		return new LoggerImpl(new LoggerHelperFtlImpl(clazz, templateDir, templateFile));
	}
	
	public static Logger getLoggerWithTemplate(String templateDir, String templateFile, String className){
		return new LoggerImpl(new LoggerHelperFtlImpl(className, templateDir, templateFile));
	}
	
	public static void addCustomLogLevels(){
		CustomLogLevel.addCustomLogLevels();
	}
	
	public static void setLoggerContext(File configFile){
		loggerContext = (LoggerContext)org.apache.logging.log4j.LogManager.getContext(false);
		loggerContext.setConfigLocation(configFile.toURI());
		configuration = loggerContext.getConfiguration();
	}
	
	public static Configuration getLoggerConfiguration(){
		return configuration;
	}
}
