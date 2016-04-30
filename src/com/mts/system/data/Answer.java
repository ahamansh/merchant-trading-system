package com.mts.system.data;

import com.mts.display.UserDisplay;
import com.mts.utils.CommonUtil;

/**
 * Answer is an entity to encapsulate answer data for the user.
 * @author skrishan
 *
 */
public class Answer {

	String answer = CommonUtil.EMPTY_STRING;
	boolean isEmpty = true;

	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public Answer(String answer) {
		super();
		this.answer = answer;
		this.isEmpty = false;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answerstr) {
		if(!CommonUtil.isNullString(answerstr)){
			this.answer = answerstr;isEmpty = false;}
	}

	public boolean isAnswerEmpty(){
		return isEmpty;
	}

	public void displayAnswer() {
		// TODO Auto-generated method stub
		UserDisplay.promptUser(answer);

	}

}
