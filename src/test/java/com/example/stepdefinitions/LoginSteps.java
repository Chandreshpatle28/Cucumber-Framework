package com.example.stepdefinitions;

import com.example.pages.LoginPage;
import com.example.utils.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() throws InterruptedException {
        loginPage.enterUsername("standard_user");
        Thread.sleep(3000);
        loginPage.enterPassword("secret_sauce");
        Thread.sleep(3000);
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_home_page() {
        assertTrue(loginPage.homePageDisplayed());
    }
    
    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials() throws InterruptedException {
        loginPage.enterUsername("standard_user002");
        Thread.sleep(3000);
        loginPage.enterPassword("secret_sauce002");
        Thread.sleep(3000);
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);
    }
    
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        assertTrue(loginPage.errorMessageDisplayed());
        System.out.println(loginPage.errorMessageDisplayed());
    }
    
    @Then("the logo should be displayed")
    public void the_logo_should_be_displayed() {
        WebElement logo = loginPage.getLogoElement();
        assertTrue("Logo is not displayed.", logo.isDisplayed());
    }
    
    /*@And("the logo dimensions and alt text should match the specification")
    public void the_logo_dimensions_and_alt_text_should_match_the_specification() {
        WebElement logo = loginPage.getLogoElement();

        // Validate alt text
        String altText = logo.getAttribute("alt");
        assertEquals("Logo alt text does not match.", "Swag Labs", altText);

        // Validate dimensions
        Dimension logoSize = logo.getSize();
        assertEquals("Logo width does not match.", 200, logoSize.getWidth()); // Replace with actual width
        assertEquals("Logo height does not match.", 50, logoSize.getHeight()); // Replace with actual height
    }*/

	@And("screenshot of the logo should be captured")
    public void screenshot_of_the_logo_should_be_captured() {
        
		try {
		WebElement logo = loginPage.getLogoElement();

        File screenshot = logo.getScreenshotAs(OutputType.FILE);
        File destination = new File("/Users/chandresh/Downloads/QA Classes Recording/ProjectSwagLabs/target/logo_screenshot.png");
        
        Files.copy(screenshot.toPath(), destination.toPath());
        System.out.println("Screenshot of the logo saved at: " + destination.getAbsolutePath());
        
        } catch (IOException e) {
            e.printStackTrace();
            throw new AssertionError("Failed to capture the logo screenshot.");
        }
    }
	
	@Then("To verify Login page title")
    public void to_verify_login_page_title() {
        String actualTitle = loginPage.getPageTitle();
        System.out.println("actualTitle: " + actualTitle);
        String expectedTitle = "Swag Labs"; 
        if (!actualTitle.equals(expectedTitle)) {
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
            throw new AssertionError("Login page title does not match!");
        }
        else {
        	System.out.println("Login page title match!");
        }
      }
	
	@Then("username text should be Username")
    public void username_text_should_be_Username() {
        String actualText = loginPage.getUsernameText();
        System.out.println("Actula Text on username fields: " +actualText);
        assertEquals("Username text does not match!", "Username", actualText);
    }
	
	@Then("the username text field should be clickable")
    public void the_username_text_field_should_be_clickable() {
        assertTrue("Username text field is not clickable!", loginPage.isUsernameFieldClickable());
    }
	
	@Then("password text field should be clickable")
	public void password_text_field_should_be_clickable() {
	    boolean isClickable = loginPage.isPasswordFieldClickable();
	    assertTrue("Password text field is not clickable!", isClickable);
	}
	
	@When("user enters text in the username field")
    public void user_enters_text_in_the_username_field() {
        String username = "testuser";  // Replace with your desired username for testing
        loginPage.enterTextInUsernameField(username);  // Enter the text into the username field
    }
	
	@Then("username field should accept the text")
    public void username_field_should_accept_the_text() {
        String expectedUsername = "testuser";  // Replace with the same text as entered in the username field
        String enteredText = loginPage.getUsernameFieldText();  // Get the text entered in the field
        assertEquals("Username text was not accepted", expectedUsername, enteredText);  // Assert that the entered text matches
    }

	@When("user enters text in the password field")
	public void user_enters_text_in_the_password_field() {
	    loginPage.enterTextInPasswordField("password123");  // Pass "password123" as the text to enter
	}

	@Then("password field should accept the text")
	public void password_field_should_accept_the_text() {
	    String enteredPassword = loginPage.getPasswordFieldText();
	    assertEquals("password123", enteredPassword);  // Assert that the entered password is "password123"
	}

	@When("user enters valid username and invalid password")
	public void user_enters_valid_username_and_invalid_password() throws InterruptedException {
		loginPage.enterUsername("standard_user");
        Thread.sleep(3000);
        loginPage.enterPassword("Invalidpassword");
        Thread.sleep(3000);
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);
       }
	
	@Then("login button should be visible")
	public void login_button_should_be_visible() {
	    LoginPage loginPage = new LoginPage(driver);  // Assuming you are using Page Object Model
	    boolean isLoginButtonVisible = loginPage.isLoginButtonVisible();
	    Assert.assertTrue("Login button is not visible", isLoginButtonVisible);
	}
	
	@Then("login button should be clickable")
	public void login_button_should_be_clickable() {
	    LoginPage loginPage = new LoginPage(driver);  // Assuming you are using Page Object Model
	    boolean isLoginButtonClickable = loginPage.isLoginButtonClickable();
	    Assert.assertTrue("Login button is not clickable", isLoginButtonClickable);
	}
	
}