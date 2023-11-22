package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import static tests.TestData.*;

public class ContactTest {

	private ChromeDriver driver;

	@BeforeMethod

	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}


	@Test(priority = 1)
	public void sign_Up_Out_Test() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		AssertJUnit.assertTrue(loginPage.isDisplayed());

		loginPage.logIn(USERNAME, PASSWORD);

		ContactsPage contactsPage = new ContactsPage(driver);
		AssertJUnit.assertTrue(contactsPage.isDisplayed());

		contactsPage.logOut();
		AssertJUnit.assertTrue(loginPage.isDisplayed());

	}

	@Test(priority = 2)
	public void create_Contact_Test() {

		ContactInfo contact = new ContactInfo(NAME, LASTNAME, BIRTH, EMAIL, PHONE, ADDRESS, CITY, PROVINCE, ZIP,
				COUNTRY);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		AssertJUnit.assertTrue(loginPage.isDisplayed());

		loginPage.logIn(USERNAME, PASSWORD);

		ContactsPage contactsPage = new ContactsPage(driver);
		AssertJUnit.assertTrue(contactsPage.isDisplayed());
		int countRows = contactsPage.getCountOfContacts();

		contactsPage.goToAddNewContactPage();

		AddContactPage addContactPage = new AddContactPage(driver);
		AssertJUnit.assertTrue(addContactPage.isDisplayed());

		addContactPage.fillNewContact(contact);
		AssertJUnit.assertTrue(contactsPage.isDisplayed());

		AssertJUnit.assertEquals(contactsPage.getCountOfContacts(), countRows + 1);
		
		AssertJUnit.assertEquals(contact, contactsPage.getPersonalInfo());

	}

	
	@Test(priority = 3)
	public void can_Not_Create_Without_Mandatory_Fields_Test() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		AssertJUnit.assertTrue(loginPage.isDisplayed());

		loginPage.logIn(USERNAME, PASSWORD);
		ContactsPage contactsPage = new ContactsPage(driver);
		AssertJUnit.assertTrue(contactsPage.isDisplayed());

		contactsPage.goToAddNewContactPage();

		AddContactPage addContactPage = new AddContactPage(driver);
		AssertJUnit.assertTrue(addContactPage.isDisplayed());
		addContactPage.submitNewContact();
		;
		AssertJUnit.assertEquals(contactsPage.getErrorMessage(), TestData.ERROR_MESSAGE);
	}

	@Test(priority = 4)
	public void edit_Exist_Contact_Test() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		AssertJUnit.assertTrue(loginPage.isDisplayed());

		loginPage.logIn(USERNAME, PASSWORD);
		ContactsPage contactsPage = new ContactsPage(driver);
		AssertJUnit.assertTrue(contactsPage.isDisplayed());

		contactsPage.goToContactDetailsPage();

		ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
		AssertJUnit.assertTrue(contactDetailsPage.isDisplayed());

		contactDetailsPage.editContact();

		EditContactPage editContactPage = new EditContactPage(driver);
		AssertJUnit.assertTrue(editContactPage.isDisplay());

		editContactPage.changeExistContact(NEW_NAME, NEW_LASTNAME, NEW_BIRTH, NEW_EMAIL, NEW_PHONE, NEW_ADDRESS,
				NEW_CITY, NEW_PROVINCE, NEW_ZIP, NEW_COUNTRY);
		editContactPage.submitButton();

		AssertJUnit.assertTrue(contactDetailsPage.isDisplayed());

		ContactInfo contact = new ContactInfo(NEW_NAME, NEW_LASTNAME, NEW_BIRTH, NEW_EMAIL, NEW_PHONE, NEW_ADDRESS,
				NEW_CITY, NEW_PROVINCE, NEW_ZIP, NEW_COUNTRY);
		AssertJUnit.assertEquals(contactDetailsPage.getPersonalInfo(), contact);

	}

	
	@Test(priority = 5)
	public void delete_Contact_Test() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		AssertJUnit.assertTrue(loginPage.isDisplayed());

		loginPage.logIn(USERNAME, PASSWORD);
		ContactsPage contactsPage = new ContactsPage(driver);
		AssertJUnit.assertTrue(contactsPage.isDisplayed());
		int countRows = contactsPage.getCountOfContacts();

		contactsPage.goToContactDetailsPage();

		ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
		AssertJUnit.assertTrue(contactDetailsPage.isDisplayed());
		contactDetailsPage.deleteContact();

		AssertJUnit.assertTrue(contactsPage.isDisplayed());

		AssertJUnit.assertEquals(countRows - 1, contactsPage.getCountOfContacts());

	}

}
