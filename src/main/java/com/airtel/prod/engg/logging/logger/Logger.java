package com.airtel.prod.engg.logging.logger;

public interface Logger {
	
	public void off(Object logMessage);
	
	public void off(String logMessage, Object[] params);
	
	public boolean isOffAllowed();
	
	public void fatal(Object logMessage);
	
	public void fatal(String logMessage, Object[] params);
	
	public boolean isFatalAllowed();
	
	public void error(Object logMessage);
	
	public void error(String logMessage, Object[] params);
	
	public void error(String logMessage, Throwable t);
	
	public boolean isErrorAllowed();
	
	public void warn(Object logMessage);
	
	public void warn(String logMessage, Object[] params);
	
	public boolean isWarnAllowed();
	
	public void info(Object logMessage);
	
	public void info(String logMessage, Object[] params);
	
	public boolean isInfoAllowed();
	
	public void debug(Object logMessage);
	
	public void debug(String logMessage, Object[] params);
	
	public boolean isDebugAllowed();

	public void trace(Object logMessage);
	
	public void trace(String logMessage, Object[] params);
	
	public boolean isTraceAllowed();
	
	public void audit(Object logMessage);
	
	public void audit(String logMessage, Object[] params);
	
	public boolean isAuditAllowed();
}
