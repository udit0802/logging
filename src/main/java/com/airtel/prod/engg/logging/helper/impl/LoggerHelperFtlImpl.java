package com.airtel.prod.engg.logging.helper.impl;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.airtel.prod.engg.logging.config.LogLevel;
import com.airtel.prod.engg.logging.utils.LoggerUtils;

import freemarker.log.Logger;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class LoggerHelperFtlImpl extends LoggerHelperImpl {
	
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(LoggerHelperFtlImpl.class);
	
	private Configuration cfg;
	private Template template;
	
	public LoggerHelperFtlImpl(Class<?> clazz) {
		super(clazz);
	}
	
	public LoggerHelperFtlImpl(String className) {
		super(className);
	}

	public LoggerHelperFtlImpl(Class<?> clazz, String templateDir, String templateFile) {
		super(clazz);
		config(templateDir, templateFile);
	}
	
	public LoggerHelperFtlImpl(String className, String templateDir, String templateFile) {
		super(className);
		config(templateDir, templateFile);
	}

	@Override
	public void log(LogLevel level, Object message) {
		if(template == null)
			super.log(level, LoggerUtils.processTemplateIntoString(message));
		else
			super.log(level, processTemplateIntoString(message));
	}
	
	private String processTemplateIntoString(Object message) {
		String processedTemplateString = null;
		try{
			processedTemplateString = FreeMarkerTemplateUtils
	                .processTemplateIntoString(template, message);
		
		} catch(Exception ex){
			log.error("Unable to format incoming message to ftl template. Using plain message for logging.", ex);
			processedTemplateString = (String)message;
		}
		
		return processedTemplateString;
	}
	
	@SuppressWarnings("deprecation")
	private void config(String templateDir, String templateFile) {
		try {
			//to disable freemarker logging.
			freemarker.log.Logger.selectLoggerLibrary(Logger.LIBRARY_NONE);
			
			cfg = new freemarker.template.Configuration();
			cfg.setDirectoryForTemplateLoading(new File(templateDir));
			template = cfg.getTemplate(templateFile);
			LoggerUtils.template = template;
		} catch (Exception e) {
			String message = "Unable to make configuration for Logger of templateDir:" + templateDir + ", templateFile:" + templateFile;
			throw new IllegalStateException(message, e);
		}
	}
}
