package com.mts.system.core;



import java.util.regex.Pattern;

import com.mts.system.constants.SystemConstants;

/**
 * Constants
 * @author skrishan
 *
 */
public enum LineRegEx {
	Assignment(SystemConstants.regexAssignment, SystemConstants.LineType.ASSIGNMENT),
	CreditsInfo(SystemConstants.regexCreditsInfo, SystemConstants.LineType.CREDITSINFO),
	Question_HOW_MANY(SystemConstants.regexHowMany, SystemConstants.LineType.QUESTION_HOW_MANY),
	Question_HOW_MUCH(SystemConstants.regexHowMuch, SystemConstants.LineType.QUESTION_HOW_MUCH);

	private final Pattern linePattern;
	private final SystemConstants.LineType type;

	LineRegEx(String linePattern, SystemConstants.LineType type)
	{
		this.linePattern=Pattern.compile(linePattern);
		this.type = type;
	}

	public Pattern getPattern()
	{
		return linePattern;
	}

	public SystemConstants.LineType getType()
	{
		return type;
	}
}
