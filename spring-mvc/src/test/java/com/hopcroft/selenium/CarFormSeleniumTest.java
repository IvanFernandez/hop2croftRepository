package com.hopcroft.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;
@Ignore
public class CarFormSeleniumTest extends SeleneseTestCase {
	@Ignore
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://localhost:9080/spring-mvc/carForm.html";
		Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
		selenium.start();
	}

	@Test
	public void testCarFormSelenium() throws Exception {
		selenium.open("/spring-mvc/carForm.html");
		selenium.type("id=brand", "Renault");
		selenium.type("id=name", "Laguna");
		selenium.type("id=price", "18500");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
