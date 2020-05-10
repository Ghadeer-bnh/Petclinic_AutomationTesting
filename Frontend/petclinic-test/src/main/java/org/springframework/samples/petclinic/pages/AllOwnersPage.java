package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;

public class AllOwnersPage extends Page{
 public static final String URL="http://localhost:8081/petclinic/owners";
    public static final String TITLE="Owners";
    public static final String HEADERXPATH="body > app-root > app-owner-list > div > div > h2";
    public static final String HOME_PAGE_NAVIGATOR_PATH="body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a";
            //"/html/body/app-root/app-owner-list/div/div/h2";

    public AllOwnersPage(){

      super(TITLE);
     // goTo(URL);
    }
public void navigateFromHomePage(){
    try {
        wait(30);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    driver.findElement(By.cssSelector(HOME_PAGE_NAVIGATOR_PATH)).click();
  //cssClick(HOME_PAGE_NAVIGATOR_PATH);

}

}
