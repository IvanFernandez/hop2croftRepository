package com.hopcroft.selenium;


import junit.framework.TestCase;

import org.junit.Ignore;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
@Ignore
public class AccederAdictosDesdeGoogleTest extends TestCase {

    private final String URL          = "http://www.google.com";
    private final String BROWSER_TYPE = "*firefox";
    
    private Selenium browser;
    @Ignore

    public void setUp() {
        browser = new DefaultSelenium("localhost",4444,BROWSER_TYPE,URL);
        browser.start();
    }
    @Ignore

    public void testAccederAdictosDesdeGoogle() throws InterruptedException {
    
        browser.open("http://www.google.es/");
		    assertEquals("Google", browser.getTitle());
		    browser.type("q", "Adictos al trabajo");
		    browser.click("btnG");
		    browser.waitForPageToLoad("50000");
		    assertEquals("Adictos al trabajo - Buscar con Google", browser.getTitle());
		    browser.click("link=Adictos al Trabajo. Formaci—n y desarrollo | JAVA, JEE, UML, XML ...");
		    browser.waitForPageToLoad("50000");
		    assertEquals("Adictos al Trabajo. Formaci—n y desarrollo | JAVA, JEE, UML, XML |. Tutoriales sobre nuevas tecnolog’as.", browser.getTitle());
    }
    @Ignore

    public void tearDown() {
        browser.stop();
    }
}
