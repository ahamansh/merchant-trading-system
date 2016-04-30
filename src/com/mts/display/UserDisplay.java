package com.mts.display;

import com.mts.logger.AbstractLogger;
import com.mts.logger.LogHandler;
import com.mts.system.SystemFactory;
import com.mts.system.constants.SystemConstants;

/**
 * Class mainly responsible for the communication for the use and the system via console.
 * This class is enhanced using Logger, yet not removed the sysout as this is an interactive system and need to display the output on the console.
 * @author skrishan
 *
 */
public class UserDisplay extends AbstractLogger{

	static LogHandler logger = SystemFactory.getLogger(UserDisplay.class);


	public static void display(String text)
	{			
		System.out.println(text);
		logger.logDebug(text);
	}

	public static void promptUser(String text)
	{
		display(text);
		logger.logDebug(text);
	}

	public static void displayNoIdea()
	{
		display(SystemConstants.I_HAVE_NO_IDEA);
		logger.logDebug(SystemConstants.I_HAVE_NO_IDEA);
	}

}
