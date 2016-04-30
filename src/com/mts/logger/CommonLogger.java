package com.mts.logger;

import org.apache.log4j.Logger;


/**
 * This is a common class to help with the logging functionality for the system. 
 * This is to demonstrate that we can have independent logging implementation and do not depend on 3rd Party Apis.
 * By using this way we can ensure minimum code breakage when moving from log4j to any other framwork.
 * @author skrishan
 *
 */
public class CommonLogger extends AbstractLogger {

	public CommonLogger(Class<?> className) {
		super();
		this.logger = Logger.getLogger(className);
	}



}
