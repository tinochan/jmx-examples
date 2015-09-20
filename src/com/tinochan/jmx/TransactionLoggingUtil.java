package com.tinochan.jmx;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TransactionLoggingUtil implements TransactionLoggingUtilMBean{
	
	private static boolean doLog = true;
	private static Map<String, Long> idMap = new ConcurrentHashMap<>();
	
	public static void startLog(String id){
		if(doLog){
			idMap.put(id, System.nanoTime());
			System.out.println("Start Logging id="+id);
		}
		
	}
	
	public static void endLog(String id){
		
		if(idMap.containsKey(id) && doLog){
			Long startTme = idMap.remove(id);
			if(startTme!=null){
				Long elapsedTime = System.nanoTime() - startTme;
				System.out.println("End Logging id="+id+" time used:"+elapsedTime);
			}
		}
	}

	@Override
	public void setDoLog(boolean doLog) {
		// TODO Auto-generated method stub
		this.doLog = doLog;
	}

	@Override
	public boolean getDoLog() {
		// TODO Auto-generated method stub
		return this.doLog;
	}

	@Override
	public int getMapSize() {
		// TODO Auto-generated method stub
		return this.idMap.size();
	}

	@Override
	public void clearMap() {
		// TODO Auto-generated method stub
		idMap.clear();
	}

}
