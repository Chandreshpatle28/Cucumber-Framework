package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.utils.Helper;
import com.example.utils.LocatorUtil;

import java.time.Duration;
import java.util.Map;

public class LoginPage {
    WebDriver driver;
    Map<String, Map<String, String>> locators;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locators = LocatorUtil.loadLocators("locators/LoginPageLocators.yaml");
    }

    private WebElement element(String locatorName) {
        return driver.findElement(LocatorUtil.getLocator(locators, locatorName));
    }

    public void enterUsername(String username) {
        element("username_field").sendKeys(username);
    }

    public void enterPassword(String password) {
        element("password_field").sendKeys(password);
    }

    /**
     * to wait for element until it becomes clickable 
     */
    public void clickOnLoginButton() {
        WebElement loginButton = element("login_button");
        Helper.waitForElementToBeClickable(driver, loginButton, 10);
        loginButton.click();
    }

    /**
     * to explicitly wait for an element until it becomes visible
     * @return
     */
    public boolean homePageDisplayed() {
        WebElement homePageTitle = element("homePageTitle");
        Helper.waitForElementVisibility(driver, homePageTitle, 10);
        return homePageTitle.isDisplayed();
    }

    // Other methods to interact with the login page
    //error message displayed method on login page
    public boolean errorMessageDisplayed() {
        WebElement errorMessage = element("errorMessageLogin");
        Helper.waitForElementVisibility(driver, errorMessage, 10);
        return errorMessage.isDisplayed();
       // System.out.println(errorMessage);
    }

	public WebElement getLogoElement() {
		return driver.findElement(LocatorUtil.getLocator(locators, "applogo"));
	}

	public String getPageTitle() {
		
		return driver.getTitle();
	}

	public boolean isUsernameFieldClickable() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated constructor
		 WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id(locators.get("usernamefield").get("value"))));;
		 return usernameField.isDisplayed() && usernameField.isEnabled();
	}

    // Method to get the text of the username label
	public String getUsernameText() {
	    String locatorValue = locators.get("usernamelabel").get("value");
	    WebElement usernameField = driver.findElement(By.xpath(locatorValue));
	    return usernameField.getAttribute("placeholder"); // Fetch the placeholder value
	}

	public boolean isPasswordFieldClickable() {
		String locatorValue = locators.get("passwordfield").get("value");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	    return passwordField.isDisplayed() && passwordField.isEnabled();
	}

	public void enterTextInUsernameField(String username) {
		WebElement usernameField = driver.findElement(LocatorUtil.getLocator(locators, "usernamefield"));
        usernameField.clear();  // To Clear any existing text
        usernameField.sendKeys("testuser");
		
	}

	public String getUsernameFieldText() {
		WebElement usernameField = driver.findElement(LocatorUtil.getLocator(locators, "usernamefield"));
        return usernameField.getAttribute("value");
	}

	public void enterTextInPasswordField(String password) {
	    WebElement passwordField = driver.findElement(LocatorUtil.getLocator(locators, "passwordfield"));
	    passwordField.clear();  // Clear any existing text
	    passwordField.sendKeys(password);  // Enter the password passed as argument
	}

	public String getPasswordFieldText() {
	    WebElement passwordField = driver.findElement(LocatorUtil.getLocator(locators, "passwordfield"));
	    return passwordField.getAttribute("value");  // Fetch the entered password from the field
	}

	public boolean isLoginButtonVisible() {
		WebElement loginButton = element("login_button");
        return loginButton.isDisplayed();
	}
	
	// Method to check if the login button is clickable
    public boolean isLoginButtonClickable() {
        WebElement loginButton = element("login_button");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated constructor
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));  // Wait for the login button to be clickable
            return true;
        } catch (Exception e) {
            return false;  
        }
    }
}