package com.airtel.prod.engg.logging.utils;

import org.apache.logging.log4j.LogManager;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Template;

public class LoggerUtils {
	
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(LoggerUtils.class);

	public static Template template;
	
	public static String processTemplateIntoString(Object message) {
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
}
