package io.cucumber.skeleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    WebDriver webDriver;
    WebDriverWait wait;

    public void OpenLoginPage(){
        webDriver.get("https://the-internet.herokuapp.com/login");
        WebElement element = webDriver.findElement(By.cssSelector("input[type='text']"));
    }

    public void TypeLogin(String login) {

        WebElement element = webDriver.findElement(By.cssSelector("input[type='text']"));
        element.sendKeys(login);

    }

    public void TypePassword(String password){
        WebElement element = webDriver.findElement(By.cssSelector("input[type='password']"));
        element.sendKeys(password);

    }

    public void ClickButton(){
        WebElement element = webDriver.findElement(By.cssSelector("button[type='submit']"));
        element.click();

    }

}
