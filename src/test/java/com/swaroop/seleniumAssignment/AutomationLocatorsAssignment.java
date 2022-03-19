package com.swaroop.seleniumAssignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationLocatorsAssignment {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\QA Testing\\Lib\\ChromeDriver99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		wd.manage().window().maximize();
	}

	@Test
	public void verifySignUpFunctionality() {
		WebElement emailInput = wd.findElement(By.cssSelector("#email_create"));
		emailInput.sendKeys(generateRandomChars("abcdefghijklmnopqrstuvwxyz", 8)+"@emal.com");
		//System.out.println(generateRandomChars("abcdefghijklmnopqrstuvwxyz", 8)+"@emal.com");
		WebElement clickCreateAccount = wd.findElement(By.cssSelector("#SubmitCreate"));
		clickCreateAccount.click();
		WebElement genderID = wd.findElement(By.cssSelector("#id_gender1"));
		WebElement firstNameInput = wd.findElement(By.cssSelector("#customer_firstname"));
		WebElement lastNameInput = wd.findElement(By.cssSelector("#customer_lastname"));
		WebElement passwordInput = wd.findElement(By.cssSelector("#passwd"));
		WebElement dobDate = wd.findElement(By.cssSelector("#days"));
		WebElement dobMonth = wd.findElement(By.cssSelector("#months"));
		WebElement dobYear = wd.findElement(By.cssSelector("#years"));
		WebElement newsLetterCheck = wd.findElement(By.cssSelector("#newsletter"));
		WebElement specialOfferCheck = wd.findElement(By.cssSelector("#optin"));
		WebElement firstNameAddress = wd.findElement(By.cssSelector("input[name = 'firstname']"));
		WebElement lastNameAddress = wd.findElement(By.cssSelector("input[name = 'lastname']"));
		WebElement companyInput = wd.findElement(By.cssSelector("#company"));
		WebElement addressLine1 = wd.findElement(By.cssSelector("#address1"));
		WebElement addressLine2 = wd.findElement(By.cssSelector("#address2"));
		WebElement cityInput = wd.findElement(By.cssSelector("#city"));
		WebElement selectState = wd.findElement(By.cssSelector("#id_state"));
		WebElement postalCodeInput = wd.findElement(By.cssSelector("input[ name = 'postcode']"));
		WebElement countrySelect = wd.findElement(By.cssSelector("#id_country"));
		WebElement additionalInput = wd.findElement(By.cssSelector("#other"));
		WebElement homePhoneInput = wd.findElement(By.cssSelector("#phone"));
		WebElement mobilePhoneInput = wd.findElement(By.cssSelector("#phone_mobile"));
		WebElement addressAlias = wd.findElement(By.cssSelector("#alias"));
		WebElement submitButton = wd.findElement(By.cssSelector(".submit.clearfix .icon-chevron-right.right"));
		genderID.click();
		firstNameInput.sendKeys("Peter");
		lastNameInput.sendKeys("Parker");
		passwordInput.sendKeys("Peter123");
		Select select = new Select(dobDate);
		select.selectByValue("1");
		select = new Select(dobMonth);
		select.selectByValue("6");
		select = new Select(dobYear);
		select.selectByValue("1987");
		newsLetterCheck.click();
		specialOfferCheck.click();
		firstNameAddress.clear();
		firstNameAddress.sendKeys("Peter");
		lastNameAddress.clear();
		lastNameAddress.sendKeys("Parker");
		companyInput.sendKeys("Marvel");
		addressLine1.sendKeys("123 85th St");
		addressLine2.sendKeys("Avengers Ave");
		cityInput.sendKeys("Boston");
		select = new Select(selectState);
		select.selectByValue("32");
		postalCodeInput.sendKeys("45678");
		select = new Select(countrySelect);
		select.selectByValue("21");
		additionalInput.sendKeys("Hello");
		homePhoneInput.sendKeys("4567890123");
		mobilePhoneInput.sendKeys("7890123456");
		addressAlias.clear();
		addressAlias.sendKeys("Office");
		submitButton.click();
		WebElement submissionCheck = wd.findElement(By.cssSelector(".account"));
		Assert.assertEquals(submissionCheck.getText(), "Peter Parker", "Submission Error");

	}

//	@AfterMethod
//	public void tearDown() {
//		wd.quit();
//	}

	public String generateRandomChars(String candidateChars, int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}

		return sb.toString();
	}

}
