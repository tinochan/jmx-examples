package com.tinochan.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class Main {

	public static void main(String[] args){
		
		int id = 0;
		
		//Get the MBean server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        TransactionLoggingUtil mbean = new TransactionLoggingUtil();
        try {
			ObjectName name = new ObjectName("com.tinochan.jmx:type=TransactionLoggingUtil");
			mbs.registerMBean(mbean, name);
		} catch (MalformedObjectNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstanceAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MBeanRegistrationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotCompliantMBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		
		while(true){
			TransactionLoggingUtil.startLog(String.valueOf(id));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//TransactionLoggingUtil.endLog(String.valueOf(id));
			
			id++;
		}
		
	}
}
