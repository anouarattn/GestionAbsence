package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ITtest {

    @Test
    public void loadTestThisWebsite() {

	WebDriver driver = new HtmlUnitDriver();
	driver.get("http://www.google.com");
	System.out.println("Page Title is " + driver.getTitle());
	Assert.assertEquals("Google", driver.getTitle());
	driver.quit();

    }

}
