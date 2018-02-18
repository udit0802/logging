package com.airtel.prod.engg.logging.helper.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.airtel.prod.engg.logging.config.LogLevel;
import com.airtel.prod.engg.logging.helper.LoggerHelper;

public abstract class LoggerHelperImpl implements LoggerHelper {
	
	protected Logger logger;
	
	public LoggerHelperImpl(Class<?> clazz) {
		logger = LogManager.getLogger(clazz);
	}
	
	public LoggerHelperImpl(String className) {
		logger = LogManager.getLogger(className);
	}

	@Override
	public boolean isLoggingAllowed(LogLevel level) {
		if(logger.getLevel().intLevel() >= level.getLevel().intLevel()) {
			return true;
		}
		return false;
	}
	
	@Override
	public void log(LogLevel level, Object message) {
		logger.log(level.getLevel(), message);

	}

	@Override
	public void log(LogLevel level, String message, Object[] params) {
		logger.log(level.getLevel(), message, params);
	}

	@Override
	public void log(LogLevel level, String message, Throwable t) {
		logger.log(level.getLevel(), message, t);
	}

}
