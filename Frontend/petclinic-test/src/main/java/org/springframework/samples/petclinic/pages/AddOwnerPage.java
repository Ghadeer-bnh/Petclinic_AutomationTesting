package org.springframework.samples.petclinic.pages;
import com.google.common.hash.HashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Random;

public class AddOwnerPage extends Page {
    //  body > app-root > app-owner-add > div > div > h2
    ///html/body/app-root/app-vet-list/div/div/table/tbody/tr/td[1]
    public static final String FIRST_NAME= "first name tester";
    //+ new Random();
    public static final String LAST_NAME = "lastName tester";
    //+ new Random();
    public static final String ADDRESS="address";
    //+new Random();
    public static final String CITY="city";
    //+new Random();
    public static final String TELEPHONE="1123";
    public static final String FIRST_NAME_SELECTOR="firstName";
    public static final String LAST_NAME_SELECTOR="lastName";
    public static final String ADDRESS_SELECTOR="address";
    public static final String CITY_SELECTOR="city";
    public static final String TELEPHONE_SELECTOR="telephone";
    public final String ONE_CHAR_VARIABLE="A";
    public final String SYMBOLS_AND_CHARACTERS ="1223##$";
    public static final String CLICK_BUTTON="body > app-root > app-owner-add > div > div > form > div:nth-child(7) > div > button:nth-child(2)";

    public static final String TICK_CLASSNAME="glyphicon form-control-feedback glyphicon-ok";
    public static final String URL="http://localhost:8081/petclinic/owners/add";

    public AddOwnerPage(WebDriver driver) {
        super(driver,"New Owner");

    }

    public void enterValidData(){
        fill(FIRST_NAME_SELECTOR,FIRST_NAME);

        fill(LAST_NAME_SELECTOR,LAST_NAME);
        fill(ADDRESS_SELECTOR,ADDRESS);
        fill(CITY_SELECTOR,CITY);
        fill(TELEPHONE_SELECTOR,TELEPHONE);

    }
    public void enterInvalidData(){
        fill(FIRST_NAME_SELECTOR,ONE_CHAR_VARIABLE);

        fill(LAST_NAME_SELECTOR,ONE_CHAR_VARIABLE);
        fill(ADDRESS_SELECTOR,ONE_CHAR_VARIABLE);
        fill(CITY_SELECTOR,ONE_CHAR_VARIABLE);
        fill(TELEPHONE_SELECTOR,ONE_CHAR_VARIABLE);
    }
    public void enterSymbolsAndNumbers(){
        fill(FIRST_NAME_SELECTOR,SYMBOLS_AND_CHARACTERS);

        fill(LAST_NAME_SELECTOR,SYMBOLS_AND_CHARACTERS);
        fill(ADDRESS_SELECTOR,SYMBOLS_AND_CHARACTERS);
        fill(CITY_SELECTOR,SYMBOLS_AND_CHARACTERS);
        fill(TELEPHONE_SELECTOR,TELEPHONE);
    }
    public boolean checkTick(){
//        String selector,String tickPath
        boolean firstNameTick= checkTick(FIRST_NAME_SELECTOR,TICK_CLASSNAME);
        boolean lastNameTick=  checkTick(LAST_NAME_SELECTOR,TICK_CLASSNAME);
        boolean addressTick=  checkTick(ADDRESS_SELECTOR,TICK_CLASSNAME);
        boolean cityTick= checkTick(CITY_SELECTOR,TICK_CLASSNAME);
        boolean telephoneTick= checkTick(TELEPHONE_SELECTOR,TICK_CLASSNAME);
     //   super.checkTick(selector,tickPath);
        return (firstNameTick&lastNameTick&addressTick&cityTick&telephoneTick);
    }
    public boolean checkButtonDisability(){
        return !checkDisability(CLICK_BUTTON);
    }
    //todo: it's not stay on the list page
    public AllOwnersPage submit() {
        System.out.println("in the submit method");
        cssClick(CLICK_BUTTON);
        return new AllOwnersPage(driver);
        // driver.get(driver.getCurrentUrl());
    }
//    public boolean isAdded() {
//        String fullName=FIRST_NAME+" "+LAST_NAME;
//        return fullName.equals(allTableElements(ALL_OWNERS_TABLE).get(allTableElements(ALL_OWNERS_TABLE).size()-1).getText());
//    }
    public boolean checkErrorMsg(String errorMsg){
        return checkPresentOfErrorMsg(errorMsg);
    }
    public boolean pageNotRedirected(){

        return isNotRedirected(URL);
    }


}
