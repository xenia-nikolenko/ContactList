package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private static final By LOGIN_EMAIL = By.id("email");
	private static final By LOGIN_PASSWORD = By.id("password");
	private static final By LOGIN_SUBMIT = By.id("submit");
	private static final String LOGIN_URL = "https://thinking-tester-contact-list.herokuapp.com/";

	private ChromeDriver driver;
	private WebDriverWait wait;

	public LoginPage(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public boolean isDisplayed() {
		return wait.until(ExpectedConditions.urlContains(LOGIN_URL));
	}

	public void logIn(String username, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(LOGIN_EMAIL));
		WebElement emailBox = driver.findElement(LOGIN_EMAIL);
		emailBox.sendKeys(username);

		wait.until(ExpectedConditions.elementToBeClickable(LOGIN_PASSWORD));
		WebElement passwordBox = driver.findElement(LOGIN_PASSWORD);
		passwordBox.sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(LOGIN_SUBMIT));
		WebElement submit = driver.findElement(LOGIN_SUBMIT);
		submit.click();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void open() {
		driver.get(LOGIN_URL);
	}

}
