/**
 * 
 */
package com.mts.utils;

/**
 * Common utils for the system.
 * @author skrishan
 *
 */
public class CommonUtil {


	public static final String EMPTY_STRING = "";


	public static boolean isNullString(String s)
	{
		return ((s == null) || (s.length() == 0) || "null".equals(s));
	}


}
