package com.mts.system.helper;

import com.mts.system.data.Answer;

/**
 * Helper class for Answer processing. This class is created to support Internationalization on later in future
 * @author skrishan
 *
 */
public class AnswerHelper {

	public static void processAnswer(Answer output){

		if(output != null && !output.isAnswerEmpty())
			output.displayAnswer();
		
	};

}
