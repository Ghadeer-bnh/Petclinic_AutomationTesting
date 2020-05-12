package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Keys.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.chord;

public abstract class Page {

    protected WebDriver driver;
    //= new ChromeDriver();;
    private String title;
    private String TITLE_TAG="h2";

    protected Page(WebDriver driver,String title) {
      this.driver = driver;

        this.title = title;
    }


    public boolean isCurrent() {
        return title.equals(driver.findElement(By.tagName(TITLE_TAG)).getText());
    }

    public boolean isCurrentByHeader() {
        boolean isCurrent = title.equals(driver.findElement(By.xpath(TITLE_TAG)).getText());
        return isCurrent;
    }

    public boolean isCurrentBySelector() {
        boolean isCurrent = title.equals(driver.findElement(cssSelector(TITLE_TAG)).getText());
        System.out.println(driver.findElement(cssSelector(TITLE_TAG)).getText());
        return isCurrent;
    }

    public boolean isCurrentByText() {

        System.out.println(title + driver.getCurrentUrl());
        //  WebDriverWait wait = new WebDriverWait(driver, 30);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-owner-list/div/div/h2")));
        boolean isCurrent = title.equals(driver.findElement(By.linkText("Owners")).getText());
        System.out.println(driver.findElement(By.linkText("Owners")).getText());
        return isCurrent;
    }
public boolean checkDisability(String path){
    WebElement e = driver.findElement(cssSelector(path));

    boolean enabled = e.isEnabled();
    return enabled;
}
public boolean checkPresentOfErrorMsg(String errorMsg){
    return driver.getPageSource().contains(errorMsg);
}
    protected void goTo(String url) {
        driver.get(url);
    }

    protected void cssClick(String path) {
        driver.findElement(cssSelector(path)).click();
    }
    protected void linkTextClick(String path) {
       //waitForBySelector(path,50);
       driver.findElement(By.partialLinkText(path)).click();
       // driver.findElement(By.cssSelector(path)).click();
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    protected String getText(String cssPath) {
        return driver.findElement(By.xpath(cssPath)).getText();
    }

    protected void fill(String id, String value) {
        final WebElement element = waitFor(id);
        element.clear();
        element.sendKeys(value);
    }

    protected boolean checkTick(String selector, String tickClassName) {
        //final WebElement element=driver.findElement(By.id(selector));
          WebElement first = driver.findElement(By.id(selector));

       // boolean result= first.findElements(By.cssSelector("body > app-root > app-owner-add > div > div > form > div.form-group.has-feedback.has-error > div > span.glyphicon.form-control-feedback.glyphicon-remove")).isDesiable();
      String xpath="/html/body/app-root/app-owner-add/div/div/form/div/div/span";
        boolean result;
       // result = first.findElements(By.xpath(xpath)).isDisplayed();
      result=  first.findElement(By.xpath(xpath)).isDisplayed();
        System.out.println(result+selector);
      return result;
      // return driver.findElements(By.cssSelector("body > app-root > app-owner-add > div > div > form > div.form-group.has-feedback.has-error > div > span.glyphicon.form-control-feedback.glyphicon-remove")).size()>0;

//        System.out.println(selector+tickClassName);
//        //System.out.println( driver.findElement(By.id(selector)).findElements(By.className(tickClassName))!=null);
//        WebElement first = driver.findElement(By.id(selector));
//
//        System.out.println( first.findElement(By.className(tickClassName)).isDisplayed());
//
//        return first.findElement(By.className(tickClassName))!=null;

    }
    protected void clearField(String cssPath) {
        driver.findElement(cssSelector(cssPath)).sendKeys(chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    protected void selectFirst(String id) {
        new Select(driver.findElement(By.id(id))).selectByIndex(1);
    }

    protected void click(String id) {
        waitFor(id).click();
    }

    private WebElement waitFor(String id) {
        return waitFor(id, 5);
    }

    private WebElement waitFor(String id, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }
    private WebElement waitForBySelector(String selector, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(cssSelector(selector)));
    }
    protected boolean exists(String id) {
        return driver.findElement(By.id(id)) != null;
    }
    public boolean isNotRedirected(String url)
    {

        return url.equals(driver.getCurrentUrl());
    }
    protected List<WebElement> allTableElements(String xpath)
    {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> tableElements = driver.findElements(By.xpath(xpath));
        return tableElements;
    }

}