package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage {

	private static final By NEW_CONTACT_BUTTON = By.id("add-contact");
	private static final String CONTACTS_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com/contactList";
	private static final By CONTACT_TABLE_ROWS_CLASS = By.className("contactTableBodyRow");
	private static final By CONTACT_TABLE_HEAD_CLASS = By.className("contactTableHead");

	private static final By TEXTLINE = By.xpath("//tr[@class='contactTableBodyRow'][1]");
	private static final By ERROR_LABEL_ID = By.id("error");
	private static final By LOG_OUT_ID = By.id("logout");

	private static final By FULL_NAME_CELL_XPATH = By.xpath("//tr[@class='contactTableBodyRow'][1]/td[2]");
	private static final By BIRTH_CELL_XPATH = By.xpath("//tr[@class='contactTableBodyRow'][1]/td[3]");
	private static final By EMAIL_CELL_XPATH = By.xpath("//tr[@class='contactTableBodyRow'][1]/td[4]");
	private static final By PHONE_CELL_XPATH = By.xpath("//tr[@class='contactTableBodyRow'][1]/td[5]");
	private static final By ADDRESS_CELL_XPATH = By.xpath("//tr[@class='contactTableBodyRow'][1]/td[6]");
	private static final By ADDRESS_DETAILS_CELL_XPATH = By.xpath("//tr[@class='contactTableBodyRow'][1]/td[7]");
	private static final By COUNTRY_CELL_XPATH = By.xpath("//tr[@class='contactTableBodyRow'][1]/td[8]");

	private ChromeDriver driver;
	private WebDriverWait wait;

	public ContactsPage(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public boolean isDisplayed() {
		return wait.until(ExpectedConditions.urlContains(CONTACTS_PAGE_URL));
	}

	public void goToAddNewContactPage() {
		wait.until(ExpectedConditions.elementToBeClickable(NEW_CONTACT_BUTTON));
		WebElement addContactButton = driver.findElement(NEW_CONTACT_BUTTON);
		addContactButton.click();
	}

	public int getCountOfContacts() {

		wait.until(ExpectedConditions.elementToBeClickable(CONTACT_TABLE_HEAD_CLASS));
		List<WebElement> contactList = driver.findElements(CONTACT_TABLE_ROWS_CLASS);
		return contactList.size();
	}

	public String getFirstRowData() {
		wait.until(ExpectedConditions.elementToBeClickable(TEXTLINE));
		WebElement row = driver.findElement(TEXTLINE);
		return row.getText();
	}

	public String getErrorMessage() {
		wait.until(ExpectedConditions.elementToBeClickable(ERROR_LABEL_ID));
		WebElement errorLabel = driver.findElement(ERROR_LABEL_ID);
		return errorLabel.getText();
	}

	public void goToContactDetailsPage() {
		wait.until(ExpectedConditions.elementToBeClickable(CONTACT_TABLE_ROWS_CLASS));
		WebElement contactRow = driver.findElement(CONTACT_TABLE_ROWS_CLASS);
		contactRow.click();
	}

	public void logOut() {
		wait.until(ExpectedConditions.elementToBeClickable(LOG_OUT_ID));
		WebElement logOutButton = driver.findElement(LOG_OUT_ID);
		logOutButton.click();
	}

	public ContactInfo getPersonalInfo() {

		String addressDetails = getAddressDetails();
		String[] details = addressDetails.split(" ");
		String city = details[0];
		String province = details[1];
		String postalCode = details[2];

		String name = getFullName();
		String[] names = name.split(" ");
		String firstName = names[0];
		String lastName = names[1];

		ContactInfo contactInfo = new ContactInfo(firstName, lastName, getBirth(), getEmail(), getPhone(), getAddress(),
				city, province, postalCode, getCountry());

		return contactInfo;
	}

	public String getFullName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FULL_NAME_CELL_XPATH));
		WebElement element = driver.findElement(FULL_NAME_CELL_XPATH);
		return element.getText();
	}

	public String getBirth() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BIRTH_CELL_XPATH));
		WebElement element = driver.findElement(BIRTH_CELL_XPATH);
		return element.getText();
	}

	public String getEmail() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_CELL_XPATH));
		WebElement element = driver.findElement(EMAIL_CELL_XPATH);
		return element.getText();
	}

	public String getPhone() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_CELL_XPATH));
		WebElement element = driver.findElement(PHONE_CELL_XPATH);
		return element.getText();
	}

	public String getAddress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_CELL_XPATH));
		WebElement element = driver.findElement(ADDRESS_CELL_XPATH);
		return element.getText();
	}

	public String getAddressDetails() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_DETAILS_CELL_XPATH));
		WebElement element = driver.findElement(ADDRESS_DETAILS_CELL_XPATH);
		return element.getText();
	}

	public String getCountry() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(COUNTRY_CELL_XPATH));
		WebElement element = driver.findElement(COUNTRY_CELL_XPATH);
		return element.getText();
	}

}
