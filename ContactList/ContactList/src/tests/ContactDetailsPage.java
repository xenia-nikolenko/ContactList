package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactDetailsPage {

	private static final String CONTACT_DETAILS_URL = "https://thinking-tester-contact-list.herokuapp.com/contactDetails";
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

	private static final By EDIT_CONTACT_ID = By.id("edit-contact");
	private static final By DELETE_BUTTON_ID = By.id("delete");

	ChromeDriver driver;
	WebDriverWait wait;

	public ContactDetailsPage(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public boolean isDisplayed() {
		return wait.until(ExpectedConditions.urlContains(CONTACT_DETAILS_URL));
	}

	public void editContact() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_CONTACT_ID));
		WebElement editContact = driver.findElement(EDIT_CONTACT_ID);
		editContact.click();
	}

	public String getFirstName() {
		WebElement firstName = driver.findElement(FIRST_NAME_ID);
		return firstName.getText();
	}

	public String getLastName() {
		WebElement lastName = driver.findElement(LAST_NAME_ID);
		return lastName.getText();
	}

	public String getBirth() {
		WebElement birth = driver.findElement(BIRTH_DATE_ID);
		return birth.getText();
	}

	public String getEmail() {
		WebElement email = driver.findElement(EMAIL_ID);
		return email.getText();
	}

	public String getPhone() {
		WebElement phone = driver.findElement(PHONE_ID);
		return phone.getText();
	}

	public String getAddress() {
		WebElement address = driver.findElement(ADDRESS_ID);
		return address.getText();
	}

	public String getCity() {
		WebElement city = driver.findElement(CITY_ID);
		return city.getText();
	}

	public String getProvince() {
		WebElement province = driver.findElement(PROVINCE_ID);
		return province.getText();
	}

	public String getZip() {
		WebElement zip = driver.findElement(ZIP_ID);
		return zip.getText();
	}

	public String getCountry() {
		WebElement country = driver.findElement(COUNTRY_ID);
		return country.getText();
	}

	public void deleteContact() {
		WebElement deleteButton = driver.findElement(DELETE_BUTTON_ID);
		deleteButton.click();
		driver.switchTo().alert().accept();
	}

	public ContactInfo getPersonalInfo() {
		 return new ContactInfo(getFirstName(), getLastName(), getBirth(), getEmail(), getPhone(), getAddress(), getCity(), getProvince(), getZip(), getCountry());
		 }
	
	

}