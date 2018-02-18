package com.airtel.prod.engg.logging.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoggerContext {

	@Value("${log4j2.conf.file.path}")
	private String log4j2ConfigFilePath;
	
	@Value("${ftl.template.dir:N/A}")
	private String templateDir;
	
	@Value("${ftl.template.file:N/A}")
	private String templateFile;

	public String getLog4j2ConfigFilePath() {
		return log4j2ConfigFilePath;
	}

	public String getTemplateDir() {
		return templateDir;
	}

	public String getTemplateFile() {
		return templateFile;
	}
}
