package org.springframework.samples.petclinic;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "summary"},
        strict = true,
        snippets = CAMELCASE,
        tags = "not @wip",
        features = "src/test/resources")
public class PetClinicSeleniumTestRunner {

    static {
        System.setProperty("webdriver.chrome.driver", System.getenv("driverPath"));
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(SEVERE);



    }


}

