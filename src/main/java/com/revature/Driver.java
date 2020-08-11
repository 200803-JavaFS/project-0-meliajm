package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	
	private static final Logger Log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
		Log.info("The application has started");
		
		try {
			recur();
		} catch(Error e) {
			Log.error("Oh no we encountered an error");
		}
		Log.info("the end of app");
		
	}
//	public Driver() {		                                   
//	}
	
	public static void recur() {
		recur();
	}
	

}
