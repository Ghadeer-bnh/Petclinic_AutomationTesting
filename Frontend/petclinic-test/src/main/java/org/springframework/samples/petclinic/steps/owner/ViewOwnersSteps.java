package org.springframework.samples.petclinic.steps.owner;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;


import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.*;

public class ViewOwnersSteps {


    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;

    @Given("I am on the home page for petclinic")
    public void iAmOnTheHomePage() {


        assertTrue(homePage.isCurrent());
    }

    @When("I click on ALL from the OWNERS tab")
    public void iClickOnOwnersTab() {
        allOwnersPage = homePage.goToOwnersList();

    }


    @Then("I will be directed to AllOwners page")
    public void iWillBeDirectedToAllOwnersPage() {

        assertTrue(allOwnersPage.isCurrent());
        allOwnersPage.closeBrowser();
    }


}
