package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditContactPage {

	private static final String EDIT_CONTACT_URL = "https://thinking-tester-contact-list.herokuapp.com/editContact";

	private static final By SUBMIT = By.id("submit");
	private static final By FIRST_NAME_ID = By.id("firstName");
	private static final By LAST_NAME_ID = By.id("lastName");
	private static final By BIRTH_DATE_ID = By.id("birthdate");
	private static final By EMAIL_ID = By.id("email");
	private static final By PHONE_ID = By.id("phone");
	private static final By ADDRESS_ID = By.id("street1");
	private static final By CITY_ID = By.id("city");
	private static final By PROVINCE_ID = By.id("stateProvince");
	private static final By ZIP_ID = By.id("postalCode");
	private static final By COUNTRY_ID = By.id("country");

	private ChromeDriver driver;
	private WebDriverWait wait;

	public EditContactPage(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public boolean isDisplay() {
		return wait.until(ExpectedConditions.urlContains(EDIT_CONTACT_URL));
	}

	public void changeExistContact(String name,String lastname,String birth,String email,String phone,String address,
			String city,String province, String zip, String country) { 
		
		wait.until(ExpectedConditions.elementToBeClickable(FIRST_NAME_ID));
		WebElement firstNameBox = driver.findElement(FIRST_NAME_ID);
		firstNameBox.clear();
		firstNameBox.sendKeys(name);
		
		wait.until(ExpectedConditions.elementToBeClickable(LAST_NAME_ID));
		WebElement lastNameBox = driver.findElement(LAST_NAME_ID);
		lastNameBox.clear();
		lastNameBox.sendKeys(lastname);
		
		wait.until(ExpectedConditions.elementToBeClickable(BIRTH_DATE_ID));
		WebElement birthDateBox = driver.findElement(BIRTH_DATE_ID);
		birthDateBox.clear();
		birthDateBox.sendKeys(birth);
		
		wait.until(ExpectedConditions.elementToBeClickable(EMAIL_ID));
		WebElement emailBox = driver.findElement(EMAIL_ID);
		emailBox.clear();
		emailBox.sendKeys(email);
		
		wait.until(ExpectedConditions.elementToBeClickable(PHONE_ID));
		WebElement phoneBox = driver.findElement(PHONE_ID);
		phoneBox.clear();
		phoneBox.sendKeys(phone);
		
		wait.until(ExpectedConditions.elementToBeClickable(ADDRESS_ID));
		WebElement addresBox = driver.findElement(ADDRESS_ID);
		addresBox.clear();
		addresBox.sendKeys(address);
		
		wait.until(ExpectedConditions.elementToBeClickable(CITY_ID));
		WebElement cityBox = driver.findElement(CITY_ID);
		cityBox.clear();
		cityBox.sendKeys(city);

		wait.until(ExpectedConditions.elementToBeClickable(PROVINCE_ID));
		WebElement provinceBox = driver.findElement(PROVINCE_ID);
		provinceBox.clear();
		provinceBox.sendKeys(province);
		
		wait.until(ExpectedConditions.elementToBeClickable(ZIP_ID));
		WebElement zipBox = driver.findElement(ZIP_ID);
		zipBox.clear();
		zipBox.sendKeys(zip);		
		
		wait.until(ExpectedConditions.elementToBeClickable(COUNTRY_ID));
		WebElement countryBox = driver.findElement(COUNTRY_ID);
		countryBox.clear();
		countryBox.sendKeys(country);
		
	}

	public void submitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(SUBMIT));
		WebElement submitButton = driver.findElement(SUBMIT);
		submitButton.click();
	}
	
	
}
