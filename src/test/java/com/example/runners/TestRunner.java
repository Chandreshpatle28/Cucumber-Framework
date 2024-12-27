package com.example.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.example.stepdefinitions", "com.example.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true,
    //tags = "@smoketest"
    tags = "@logintag13"
)
public class TestRunner {
}