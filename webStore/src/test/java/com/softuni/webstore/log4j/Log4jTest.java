package com.softuni.webstore.log4j;

import org.junit.Test;
import org.slf4j.Logger;

public class Log4jTest {
	Logger userlog = LoggerManager.getUserLogger();
	Logger systemlog = LoggerManager.getSystemLogger();
	
	
	@Test
	public void testLog4jUserLog() {
		userlog.debug("What's up debug");
	}
	
	@Test
	public void testLog4jSystemLog() {
		systemlog.error("What's up error");
	}
}
