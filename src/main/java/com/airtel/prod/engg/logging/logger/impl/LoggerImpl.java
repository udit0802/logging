package com.airtel.prod.engg.logging.logger.impl;

import com.airtel.prod.engg.logging.config.LogLevel;
import com.airtel.prod.engg.logging.helper.LoggerHelper;
import com.airtel.prod.engg.logging.logger.Logger;

public class LoggerImpl implements Logger {
	
	protected LoggerHelper loggerHelper;
	
	public LoggerImpl(LoggerHelper loggerHelper){
		this.loggerHelper = loggerHelper;
	}

	@Override
	public void off(Object logMessage) {
		loggerHelper.log(LogLevel.OFF, logMessage);
	}

	@Override
	public void off(String logMessage, Object[] params) {
		loggerHelper.log(LogLevel.OFF, logMessage, params);
	}

	@Override
	public boolean isOffAllowed() {
		return loggerHelper.isLoggingAllowed(LogLevel.OFF);
	}

	@Override
	public void fatal(Object logMessage) {
		loggerHelper.log(LogLevel.FATAL, logMessage);
	}

	@Override
	public void fatal(String logMessage, Object[] params) {
		loggerHelper.log(LogLevel.FATAL, logMessage, params);
	}

	@Override
	public boolean isFatalAllowed() {
		return loggerHelper.isLoggingAllowed(LogLevel.FATAL);
	}

	@Override
	public void error(Object logMessage) {
		loggerHelper.log(LogLevel.ERROR, logMessage);
	}

	@Override
	public void error(String logMessage, Object[] params) {
		loggerHelper.log(LogLevel.ERROR, logMessage, params);
	}

	@Override
	public void error(String logMessage, Throwable t) {
		loggerHelper.log(LogLevel.ERROR, logMessage, t);
	}

	@Override
	public boolean isErrorAllowed() {
		return loggerHelper.isLoggingAllowed(LogLevel.ERROR);
	}

	@Override
	public void warn(Object logMessage) {
		loggerHelper.log(LogLevel.WARN, logMessage);
	}

	@Override
	public void warn(String logMessage, Object[] params) {
		loggerHelper.log(LogLevel.WARN, logMessage, params);
	}

	@Override
	public boolean isWarnAllowed() {
		return loggerHelper.isLoggingAllowed(LogLevel.WARN);
	}

	@Override
	public void info(Object logMessage) {
		loggerHelper.log(LogLevel.INFO, logMessage);
	}

	@Override
	public void info(String logMessage, Object[] params) {
		loggerHelper.log(LogLevel.INFO, logMessage, params);
	}

	@Override
	public boolean isInfoAllowed() {
		return loggerHelper.isLoggingAllowed(LogLevel.INFO);
	}

	@Override
	public void debug(Object logMessage) {
		loggerHelper.log(LogLevel.DEBUG, logMessage);
	}

	@Override
	public void debug(String logMessage, Object[] params) {
		loggerHelper.log(LogLevel.DEBUG, logMessage, params);
	}

	@Override
	public boolean isDebugAllowed() {
		return loggerHelper.isLoggingAllowed(LogLevel.DEBUG);
	}

	@Override
	public void trace(Object logMessage) {
		loggerHelper.log(LogLevel.TRACE, logMessage);
	}

	@Override
	public void trace(String logMessage, Object[] params) {
		loggerHelper.log(LogLevel.TRACE, logMessage, params);
	}

	@Override
	public boolean isTraceAllowed() {
		return loggerHelper.isLoggingAllowed(LogLevel.TRACE);
	}

	@Override
	public void audit(Object logMessage) {
		loggerHelper.log(LogLevel.AUDIT, logMessage);
	}

	@Override
	public void audit(String logMessage, Object[] params) {
		loggerHelper.log(LogLevel.AUDIT, logMessage, params);
	}

	@Override
	public boolean isAuditAllowed() {
		return loggerHelper.isLoggingAllowed(LogLevel.AUDIT);
	}

}
