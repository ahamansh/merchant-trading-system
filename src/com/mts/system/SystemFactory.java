/**
 * 
 */
package com.mts.system;

import java.util.Scanner;

import com.mts.entry.Conversation;
import com.mts.entry.SystemStarter;
import com.mts.logger.CommonLogger;
import com.mts.logger.LogHandler;
import com.mts.system.comodity.Metal;
import com.mts.system.controller.AssignementHandler;
import com.mts.system.controller.AssignmentService;
import com.mts.system.controller.CreditsHandler;
import com.mts.system.controller.CreditsService;
import com.mts.system.controller.QuestionHandler;
import com.mts.system.controller.QuestionService;
import com.mts.system.controller.RomanNumberHandler;
import com.mts.system.controller.RomanNumberService;
import com.mts.system.data.Vendor;
import com.mts.system.validators.SystemValidator;
import com.mts.system.validators.TradeValidator;

/**
 * Common Factory to create data object instance
 * @author skrishan
 *
 */
public class SystemFactory {	

	private static TradeValidator validator = new SystemValidator();
	private static RomanNumberHandler romanNumberService = new RomanNumberService();
	private static AssignementHandler inputService = new AssignmentService();	
	private static CreditsHandler creditsService = new CreditsService();
	private static QuestionHandler questionService = new QuestionService();

	public static SystemStarter getSystemStarter(){return new Conversation(new Scanner(System.in));}
	public static Vendor getSellerInstance(){ return new Vendor(); }

	public static AssignementHandler getAssignmentHandlerInstance(){ return new AssignmentService();}

	public static Metal getMetalInstance(String metalName,int unitRate){ return new Metal(metalName, unitRate);}
	public static Metal getMetalInstance(String metalName,double credit,int convFactr){ return new Metal(metalName, credit,convFactr);}

	public static AssignementHandler getInputService() {
		return inputService;
	}

	public static RomanNumberHandler getRomanNumberService() {
		return romanNumberService;
	}

	public static TradeValidator getTradeValidator() {
		return validator;
	}

	public static QuestionHandler getQuestionHandlerInstance() {
		return questionService;
	}

	public static CreditsHandler getCreditsHandlerInstance() {

		return creditsService;
	}

	public static LogHandler getLogger(Class<?> className){

		return new CommonLogger(className);
	}

}
