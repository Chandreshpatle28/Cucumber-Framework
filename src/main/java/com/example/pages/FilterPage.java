package com.example.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.utils.Helper;
import com.example.utils.LocatorUtil;
import com.example.utils.TestDataHandler;

public class FilterPage{
	WebDriver driver;
    Map<String, Map<String, String>> locators;

    public FilterPage(WebDriver driver) {
	        this.driver = driver;
	        this.locators = LocatorUtil.loadLocators("locators/FilterLocators.yaml");
	    }
	    
	    public WebElement element(String locatorName) {
			return driver.findElement(LocatorUtil.getLocator(locators, locatorName));
	    }

	}
