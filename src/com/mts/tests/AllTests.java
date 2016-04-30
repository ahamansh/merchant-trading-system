package com.mts.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AssignmentTest.class, ConversationTest.class,
		CreditsTest.class, LoggerTest.class, QuestionTest.class })
public class AllTests {

}
