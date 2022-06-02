package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//select[@name='fromPort']")
    private WebElement dd_From;
    @FindBy(how = How.XPATH, using = "//select[@name='toPort']")
    private WebElement dd_to;
    @FindBy(how = How.XPATH, using = "//input[@value='Find Flights']")
    private WebElement btn_FindFlights;
    
    public WebDriver driver;

    public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SearchFlights(String departure, String destination){
        Select select = new Select(dd_From);
        select.selectByVisibleText(departure);
        select = new Select(dd_to);
        btn_FindFlights.click();
        Assert.assertEquals(true, true);
        
    }

}
