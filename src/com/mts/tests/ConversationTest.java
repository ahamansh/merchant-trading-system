package com.mts.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.mts.entry.ConversationTester;
import com.mts.system.SystemFactory;

public class ConversationTest {

	ConversationTester converse = null;
	
	@Before
	public void setUp(){
		
		converse = (ConversationTester) SystemFactory.getSystemStarter();
				
	}
	
	@Test
	public void scannerNotNullTest(){		
		assertNotNull("Input Scanner not set properly", converse.getScanner());
	}
	
	

	

}
