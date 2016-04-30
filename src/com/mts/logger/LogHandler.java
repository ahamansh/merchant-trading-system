package com.mts.logger;


/**
 * Logging Interface for the System. An interface is provided so as to keep the system independent of 3rd Party Lib
 * There is an implementing abstract class for the interface which has the implementation needed for the system
 * 
 * @author skrishan
 *
 */
public interface LogHandler {

	public void logDebug(Object toLog);

	public void logInfo(Object toLog);

	public void logWarning(Object toLog);

	public void logError(Object toLog);

	public void logException(Exception e);

}
