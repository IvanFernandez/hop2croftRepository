package com.hopcroft.selenium;

import org.junit.Test;

import junit.framework.TestCase;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleniumException;

public class SeleniumHelloWorldExampleTest extends TestCase {
	private DefaultSelenium selenium;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		selenium = createSeleniumClient("http://localhost:9080/");
		selenium.start();
		selenium.windowMaximize();
		selenium.setSpeed("1000");
	}

	@Override
	public void tearDown() throws Exception {
		selenium.stop();
		super.tearDown();
	}

	protected DefaultSelenium createSeleniumClient(String url) throws Exception {
		return new DefaultSelenium("localhost", 4444, "*chrome", url);
	}
//	@Test
//	public void testHelloWorld() throws Exception {
//		try {
//			selenium.open("http://www.google.es/");
//			assertEquals("Google", selenium.getText("//h1"));
//		} catch (SeleniumException ex) {
//			fail(ex.getMessage());
//			throw ex;
//		}
//	}

	@Test
	public void testCarFormSelenium() throws Exception {
		selenium.open("/spring-mvc/carForm.html");
		selenium.type("id=brand", "Renault");
		selenium.type("id=name", "Laguna");
		selenium.type("id=price", "18500");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		assertEquals(selenium.getTitle(),"Car insert sucess");
	}
}
