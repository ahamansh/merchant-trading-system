package com.mts.logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;


/**
 * Logger class to load and configure log4j in the system. On starting the system the log4j will be initialized and will be ready to start logging.
 * the static factory is moved to SystemFactory so as to match the design of the system. We can still have a separate factory for the logger if 
 * we have more than one class extending AbstractLogger.
 * @author skrishan
 *
 */
public class MtsLogger {

	static
	{
		Properties log4jProperties = new Properties();
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		InputStream  in = loader.getResourceAsStream("log4j.properties");
		try {
			log4jProperties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PropertyConfigurator.configure(log4jProperties);
	}

}
