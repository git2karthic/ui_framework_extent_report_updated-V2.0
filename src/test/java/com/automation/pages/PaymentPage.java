package com.automation.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/p[1]")
    private WebElement txt_Airline;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/p[2]")
    private WebElement txt_FlightNumber;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/p[3]")
    private WebElement txt_Price;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/p[4]")
    private WebElement txt_ArbitraryFeesAndTaxes;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/p[5]/em[1]")
    private WebElement txt_TotalCost;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
    private WebElement edit_Name;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[2]/div[1]/input[1]")
    private WebElement edit_Address;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/input[1]")
    private WebElement edit_City;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[4]/div[1]/input[1]")
    private WebElement edit_State;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[5]/div[1]/input[1]")
    private WebElement edit_ZipCode;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[6]/div[1]/select[1]")
    private WebElement dd_CardType;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[7]/div[1]/input[1]")
    private WebElement edit_CreditCardNumber;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[8]/div[1]/input[1]")
    private WebElement edit_Month;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[9]/div[1]/input[1]")
    private WebElement edit_Year;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/form[1]/div[10]/div[1]/input[1]")
    private WebElement edit_NameOnCard;
	    
	    

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/form/div[11]/div/input")
    private WebElement btn_PurchaseFlight;
    
    public WebDriver driver;

    public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    public Map<String, String> GetTicketInformation(){
    	Map<String, String> map = new HashMap<String, String>();
        map.put("airline", txt_Airline.getText().trim());
        map.put("flightNumber", txt_FlightNumber.getText().trim());
        map.put("price", txt_Price.getText().trim());
        map.put("arbitraryFeesAndTaxes", txt_ArbitraryFeesAndTaxes.getText().trim());
        map.put("totalCost", txt_TotalCost.getText().trim());
        return map;
    	
    }

    public void PurchaseFlight(String Name, String Address, String City, String State,
            String ZipCode, String CardType, String CreditCardNumber,
            String Month, String Year, String NameOnCard){
		edit_Name.sendKeys(Name);
		edit_Address.sendKeys(Address);
		edit_City.sendKeys(City);
		edit_State.sendKeys(State);
		edit_ZipCode.sendKeys(ZipCode);
		Select select = new Select(dd_CardType);
		select.selectByVisibleText(CardType);
		edit_CreditCardNumber.sendKeys(CreditCardNumber);
		edit_Month.sendKeys(Month);
		edit_Year.sendKeys(Year);
		edit_NameOnCard.sendKeys(NameOnCard);
        btn_PurchaseFlight.click();
    }


}
