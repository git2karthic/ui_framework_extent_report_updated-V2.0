package com.automation.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PurchaseSummaryPage {

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
    private WebElement Id;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
    private WebElement Status;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[2]")
    private WebElement Amount;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")
    private WebElement CardNumber;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[5]/td[2]")
    private WebElement Expiration;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[6]/td[2]")
    private WebElement AuthCode;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[7]/td[2]")
    private WebElement Date;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/a[2]")
    private WebElement link_HomePage;
    
    public WebDriver driver;

    public PurchaseSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    public Map<String, String> GetPurchaseSummaryInformation(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", Id.getText().trim());
        map.put("status", Status.getText().trim());
        map.put("amount", Amount.getText().trim());
        map.put("cardNumber", CardNumber.getText().trim());
        map.put("expiration", Expiration.getText().trim());
        map.put("authcode", AuthCode.getText().trim());
        map.put("date", Date.getText());
        return map;
    }

    public void NavigateToHomePage(){
        link_HomePage.click();
        Assert.assertEquals(true, true);
    }
}
