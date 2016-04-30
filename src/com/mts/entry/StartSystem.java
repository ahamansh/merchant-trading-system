package com.mts.entry;

import com.mts.system.SystemFactory;

/*
 * System Entry point
 */
public class StartSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//SystemStarter trade = new Conversation(new Scanner(System.in));
		SystemStarter trade = SystemFactory.getSystemStarter();
		trade.start();

	}

}
