package com.airtel.prod.engg.logging.config;

import org.apache.logging.log4j.Level;

public enum LogLevel {

	/*
	 *  Standard Level	intLevel
			OFF				0
			FATAL			100
			ERROR			200
			WARN			300
			INFO			400
			DEBUG			500
			TRACE			600
			ALL				Integer.MAX_VALUE
	 * */
	
	OFF(Level.OFF),
	
	FATAL(Level.FATAL),
	
	ERROR(Level.ERROR),
	
	WARN(Level.WARN),
	
	INFO(Level.INFO),
	
	DEBUG(Level.DEBUG),
	
	TRACE(Level.TRACE),
	
	ALL(Level.ALL),
	
	//Adding the custom ones here
	AUDIT(CustomLogLevel.AUDIT_LEVEL);
	
	private final Level level;
	
	private LogLevel(Level level){
		this.level = level;
	}
	
	public Level getLevel(){
		return this.level;
	}
	
}
