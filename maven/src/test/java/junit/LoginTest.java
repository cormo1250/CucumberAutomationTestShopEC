package junit;

import io.cucumber.skeleton.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    WebDriver webDriver;
    WebDriverWait wait;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "/Users/patryknerc/Desktop/WebDrivers/chromedriver");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 3);
    }

    @After
    public void cleseBrowser(){
        webDriver.quit();

    }


    @Test
    public void correctCredentials() {

        LoginPage loginPage = new LoginPage(webDriver, wait);
        loginPage.OpenLoginPage();
        loginPage.TypeLogin("tomsmith");
        loginPage.TypePassword("SuperSecretPassword!");
        loginPage.ClickButton();

//        webDriver.get("https://the-internet.herokuapp.com/login");
//        WebElement element = webDriver.findElement(By.cssSelector("input[type='text']"));
//        element.sendKeys("tomsmith");
//        element = webDriver.findElement(By.cssSelector("input[type='password']"));
//        element.sendKeys("SuperSecretPassword!");
//        element = webDriver.findElement(By.cssSelector("button[type='submit']"));
//        element.click();
        wait.until(ExpectedConditions.urlContains("secure"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/logout']")));
        String expectedResult = "You logged into a secure area!";
        verifyText(expectedResult);

    }

    @Test
    public void incorrectCredentials() {
//        webDriver.get("https://the-internet.herokuapp.com/login");
//        WebElement element = webDriver.findElement(By.cssSelector("input[type='text']"));
//        element.sendKeys("tomsmith");
//        element = webDriver.findElement(By.cssSelector("input[type='password']"));
//        element.sendKeys("SuperSecretPassword!!");
//        element = webDriver.findElement(By.cssSelector("button[type='submit']"));
//        element.click();
        //wait.until(ExpectedConditions.urlContains("secure"));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/logout']")));
        String expectedResult = "Your password is invalid!";
        verifyText(expectedResult);
    }

    private void verifyText(String expectedResult) {
        WebElement element = webDriver.findElement(By.cssSelector("div[id = 'flash']"));
        String currentelement = element.getText();
        //  String expectedResult = "Your password is invalid!";
        Assert.assertTrue(currentelement.contains(expectedResult));
        //    verifyText(expectedResult);

    }
}
