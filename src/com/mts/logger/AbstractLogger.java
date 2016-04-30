package com.mts.logger;

import org.apache.log4j.Logger;

/**
 * Abstract class to provide logging to the MTS. This class is made abstract so that all the
 * implementing class can use the common methods, 
 * however they are free to apply their own customization where needed and add a method in the system factory.
 * @author skrishan
 *
 */

public abstract class AbstractLogger implements LogHandler {

	Logger logger;

	public void logDebug(Object toLog){	logger.debug(toLog);}

	public void logInfo(Object toLog){	logger.info(toLog);}

	public void logWarning(Object toLog){ logger.warn(toLog);}

	public void logError(Object toLog){	logger.error(toLog);}

	public void logException(Exception e){	logger.fatal(e);}


}
