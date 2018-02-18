package com.airtel.prod.engg.logging.helper;

import com.airtel.prod.engg.logging.config.LogLevel;

public interface LoggerHelper {

	public boolean isLoggingAllowed(LogLevel level);
	
	public void log(LogLevel level, Object message);
	
	public void log(LogLevel level, String message, Object[] params);
	
	public void log(LogLevel level, String message, Throwable t);
}
