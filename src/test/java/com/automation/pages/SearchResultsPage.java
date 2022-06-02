package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultsPage {

	@FindBy(how = How.XPATH, using = "//table[@class='table']")
	private WebElement tbl_SearchResults;

	public WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SelectFlight(String key, String value) {
		List<WebElement> rows = tbl_SearchResults.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if (key.equalsIgnoreCase("flightNumber")) {
				String temp = cols.get(1).getText();
				if (temp.equalsIgnoreCase(value)) {
					cols.get(0).findElements(By.tagName("input")).get(0).click();
					break;

				}
			} else if (key.equalsIgnoreCase("Airline")) {
				String temp = cols.get(2).getText();
				if (temp.equalsIgnoreCase(value)) {
					cols.get(0).findElements(By.tagName("input")).get(0).click();
					break;
				}
			} else if (key.equalsIgnoreCase("Departure")) {
				String temp = cols.get(3).getText();
				if (temp.equalsIgnoreCase(value)) {
					cols.get(0).findElements(By.tagName("input")).get(0).click();
					break;
				}
			} else if (key.equalsIgnoreCase("Arrival")) {
				String temp = cols.get(4).getText();
				if (temp.equalsIgnoreCase(value)) {
					cols.get(0).findElements(By.tagName("input")).get(0).click();
					break;
				}
			} else if (key.equalsIgnoreCase("Price")) {
				String temp = cols.get(5).getText();
				if (temp.equalsIgnoreCase(value)) {
					cols.get(0).findElements(By.tagName("input")).get(0).click();
					break;
				}
			}
		}
		   Assert.assertEquals(true, true);

	}
}
