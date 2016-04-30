package com.mts.system.constants;


/**
 * Constants used in the system. Single place value if needed can be changed later at one point
 * @author skrishan
 *
 */
public interface SystemConstants {

	public int UNIT_CONVERSION_FACTOR = 1;

	public String I_HAVE_NO_IDEA = "I have no idea what you are talking about.";



	public static enum LineType
	{
		ASSIGNMENT,
		CREDITSINFO,
		QUESTION_HOW_MANY,
		QUESTION_HOW_MUCH
	}

	public String regexAssignment = "^([a-z]+) is ([I|V|X|L|C|D|M])$";
	public String regexCreditsInfo = "((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$";
	public String regexHowMany= "^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$";
	public String regexHowMuch = "^how much is ((?:\\w+[^0-9] )+)\\?$";



	// ********* ERROR MESSAGES ********** to be added



}
