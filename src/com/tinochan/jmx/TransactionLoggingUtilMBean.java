package com.tinochan.jmx;

public interface TransactionLoggingUtilMBean {
	
	public void setDoLog(boolean doLog);
	public boolean getDoLog();
	public int getMapSize();
	public void clearMap();
}
