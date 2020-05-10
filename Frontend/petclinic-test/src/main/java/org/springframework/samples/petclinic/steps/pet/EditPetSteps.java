package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.samples.petclinic.pages.EditPetPage;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;

import static org.junit.Assert.*;


public class EditPetSteps {

    private OwnerInformationPage ownerInformationPage = new OwnerInformationPage();
    private EditPetPage editPetPage;
    private String name = "Updated";
    private String birthDate = "2019/01/01";
    private int index = 1;

    @Given("I am on the edit-pet form")
    public void iAmOnTheEditPetForm() {
        ownerInformationPage.goToOwnerInformationPage();
        editPetPage = ownerInformationPage.editFirstPet();
        assertTrue(editPetPage.isCurrent());
    }


    @And("I update with valid pet data")
    public void iUpdateWithValidPetData() {
        editPetPage.fillInForm(name,birthDate,index);
        ownerInformationPage = editPetPage.submit();
    }


    @And("I update the birth date field with a non-date formatted value")
    public void iUpdateTheBirthDateFieldWithANonDateFormattedValue() {
        editPetPage.fillInForm(name,"abc",index);
        ownerInformationPage = editPetPage.submit();
    }

    @And("I update the name field with symbols and numbers rather than words")
    public void iUpdateTheNameFieldWithSymbolsAndNumbersRatherThanWords() {
        name = "%45$^";
        editPetPage.fillInForm(name,birthDate,index);
        ownerInformationPage = editPetPage.submit();
    }

    @Then("The pet information will be updated and displayed at the owner information page")
    public void thePetInformationWillBeUpdatedAndDisplayedAtTheOwnerInformationPage() {
        assertTrue(ownerInformationPage.petNames().contains(name));
    }

    @Then("I remain in the edit pet page")
    public void iRemainInTheEditPetPage() {
        assertTrue(editPetPage.isCurrent());
    }
}