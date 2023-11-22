package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddContactPage {

	private static final String ADD_CONTACT_URL = "https://thinking-tester-contact-list.herokuapp.com/addContact";

	private ChromeDriver driver;
	private WebDriverWait wait;

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

	public AddContactPage(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public boolean isDisplayed() {
		return wait.until(ExpectedConditions.urlContains(ADD_CONTACT_URL));
	}
	
	
	public void fillNewContact(ContactInfo contact) {

		typeValueInTextBox(FIRST_NAME_ID, contact.getFirstName());
		typeValueInTextBox(LAST_NAME_ID, contact.getLastName());
		typeValueInTextBox(BIRTH_DATE_ID, contact.getBirth());
		typeValueInTextBox(EMAIL_ID, contact.getEmail());
		typeValueInTextBox(PHONE_ID, contact.getPhone());
		typeValueInTextBox(ADDRESS_ID, contact.getAddress());
		typeValueInTextBox(CITY_ID, contact.getCity());
		typeValueInTextBox(PROVINCE_ID, contact.getPrivince());
		typeValueInTextBox(ZIP_ID, contact.getZip());
		typeValueInTextBox(COUNTRY_ID, contact.getCountry());

		submitNewContact();
	}
	
	

//	public void fillNewContact(String name, String lastname, String birth, String email, String phone, String address,
//			String city, String province, String zip, String country) {
//
//		typeValueInTextBox(FIRST_NAME_ID, name);
//		typeValueInTextBox(LAST_NAME_ID, lastname);
//		typeValueInTextBox(BIRTH_DATE_ID, birth);
//		typeValueInTextBox(EMAIL_ID, email);
//		typeValueInTextBox(PHONE_ID, phone);
//		typeValueInTextBox(ADDRESS_ID, address);
//		typeValueInTextBox(CITY_ID, city);
//		typeValueInTextBox(PROVINCE_ID, province);
//		typeValueInTextBox(ZIP_ID, zip);
//		typeValueInTextBox(COUNTRY_ID, country);
//
//		submitNewContact();
//	}

	public void typeValueInTextBox(By id, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(id));
		WebElement textBox = driver.findElement(id);
		textBox.sendKeys(value);
	}

	public void submitNewContact() {
		wait.until(ExpectedConditions.elementToBeClickable(SUBMIT));
		WebElement submitButton = driver.findElement(SUBMIT);
		submitButton.click();
	}
		
	
	
}
