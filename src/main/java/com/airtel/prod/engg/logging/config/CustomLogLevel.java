package com.airtel.prod.engg.logging.config;

import org.apache.logging.log4j.Level;

public class CustomLogLevel {

	private CustomLogLevel(){}
	
	static final String AUDIT = "AUDIT";
	
	static final Level AUDIT_LEVEL = Level.forName(AUDIT, 450);
	
	public static void addCustomLogLevels(){
		Level.toLevel(AUDIT, CustomLogLevel.AUDIT_LEVEL);
	}
}
