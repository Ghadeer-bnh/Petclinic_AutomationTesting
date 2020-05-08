package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.samples.petclinic.pages.AddPetPage;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;

import static org.junit.Assert.*;


public class AddPetSteps {

    private AddPetPage addPetPage = new AddPetPage();
    private OwnerInformationPage ownerInformationPage;
    private String name = "pet1";
    private String birthDate = "2020/05/13";
    private int index = 2;


    @Given("I am on the add-pet form")
    public void iAmOnTheAddPetForm() {
        assertTrue(addPetPage.isCurrent());
    }

    @And("I enter valid pet data")
    public void iEnterValidPetData() {
        ownerInformationPage = addPetPage.fillInForm(name,birthDate, index);
    }

    @Then("The new pet will be displayed at the owner information page")
    public void theNewPetWillBeDisplayedAtTheOwnerInformationPage() {
        assertTrue(name.equals(ownerInformationPage.lastAddedPetName()));
    }

    @And("I leave all the fields empty")
    public void iLeaveAllTheFieldsEmpty() {
        ownerInformationPage = addPetPage.fillInForm("","", 1);
    }

    @And("I enter a non-date formatted value into the birth date field")
    public void iEnterANonDateFormattedValueIntoTheBirthDateField() {
        ownerInformationPage = addPetPage.fillInForm(name,"abc", index);
    }

    @Then("I remain in the same page")
    public void iRemainInTheSamePage() {
        assertTrue(addPetPage.isCurrent());
    }


}
