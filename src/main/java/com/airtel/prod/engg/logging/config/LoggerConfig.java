package com.airtel.prod.engg.logging.config;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.airtel.prod.engg.logging.context.LoggerContext;
import com.airtel.prod.engg.logging.utils.LoggerUtils;

import freemarker.log.Logger;
import freemarker.template.Template;

@Configuration
public class LoggerConfig {

	@Autowired
	private LoggerContext loggerContext;
	
	private static freemarker.template.Configuration cfg;
	private Template template;
	
	@PostConstruct
	public void init(){
		
		File configFile = new File(loggerContext.getLog4j2ConfigFilePath());
		if (!configFile.exists()) {
			throw new IllegalArgumentException(configFile.getAbsolutePath() + " file does not exist");
		}
		
		if (!"N/A".equals(loggerContext.getTemplateDir()) && !"N/A".equals(loggerContext.getTemplateFile())) {
			File templateFile = new File(loggerContext.getTemplateDir() + "/" + loggerContext.getTemplateFile());
			if (!templateFile.exists()) {
				throw new IllegalArgumentException("Ftl template file does not exist at:" + templateFile.getAbsolutePath());
			}
			config(loggerContext.getTemplateDir(), loggerContext.getTemplateFile());
		}
		
		LogManager.templateDir = loggerContext.getTemplateDir();
		LogManager.templateFile = loggerContext.getTemplateFile();
		
		LogManager.addCustomLogLevels();
 		
 		//set logger context via configuration file.
 		LogManager.setLoggerContext(configFile);
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
