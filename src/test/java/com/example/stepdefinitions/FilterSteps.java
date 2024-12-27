package com.example.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.pages.FilterPage;
import com.example.utils.DriverFactory;

import io.cucumber.java.en.*;

public class FilterSteps {

	private WebDriver driver;
	private FilterPage filterPage;

	public FilterSteps() {
		this.driver = DriverFactory.getDriver();
		this.filterPage = new FilterPage(driver);
	}
	
	
	@And("Filter section should be displayed on the dashboard")
    public void Filter_section_should_be_displayed_on_the_dashboard() {
    	WebElement filterSection = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
    	if (filterSection.isDisplayed()) {
            System.out.println("Filter section is displayed on the dashboard.");
        } else {
            throw new AssertionError("Filter section is not displayed on the dashboard.");
        }	
    	
	}
	
	@Then("default option in the Filter dropdown should be visible")
	public void default_option_in_the_filter_dropdown_should_be_visible() {
	    
	    WebElement filterDropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

	    if (!filterDropdown.isDisplayed()) {
	        throw new AssertionError("Filter dropdown is not visible on the dashboard.");
	    }

	    Select dropdown = new Select(filterDropdown);
	    WebElement selectedOption = dropdown.getFirstSelectedOption();

	    if (selectedOption.isDisplayed()) {
	        System.out.println("Default option in the Filter dropdown is visible: " + selectedOption.getText());
	    } else {
	        throw new AssertionError("Default option in the Filter dropdown is not visible.");
	    }
	}

	
	@Then("Filter dropdown should be visible")
	public void filter_dropdown_should_be_visible() {
	    
	}

	@When("user clicks on the Filter dropdown")
	public void user_clicks_on_the_filter_dropdown() {
	   
	}

	@Then("dropdown should display a list of options")
	public void dropdown_should_display_a_list_of_options() {
	    
	}

	@Then("user selects the first option from the dropdown")
	public void user_selects_the_first_option_from_the_dropdown() {
	    
	}


}
