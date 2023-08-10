import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//public class LoginMyStepDefs {
//    WebDriver webDriver;
//    WebDriverWait wait;
//
//    @Before
//    public void openBrowser() {
//        System.setProperty("webdriver.chrome.driver","/Users/patryknerc/Desktop/WebDrivers/chromedriver");
//        webDriver = new ChromeDriver();
//        wait = new WebDriverWait(webDriver, 3);
//
//    }
//
//    @And("I open login page")
//    public void iOpenLoginPage() {
//        webDriver.get("https://the-internet.herokuapp.com/login");
//
//    }
//    @After
//    public void closeBrowser() {
//        webDriver.quit();
//
//    @When("I type {string} as login")
//    public void iTypeAsLogin(String login) {
//       WebElement element = webDriver.findElement(By.cssSelector("input[type='text']"));
//        element.sendKeys(login);
//
//    }
//
//    @And("I type {string} as password")
//    public void iTypeAsPassword(String haslo) {
//        WebElement element = webDriver.findElement(By.cssSelector("input[type='password']"));
//        element.sendKeys(haslo);
//    }
//
//    @And("I click login button")
//    public void iClickLoginButton() {
//        WebElement element = webDriver.findElement(By.cssSelector("button[type='submit']"));
//        element.click();
//    }
//
//    @Then("I'm logged in")
//    public void iMLoggedIn() {
//        wait.until(ExpectedConditions.urlContains("secure"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/logout']")));
//        WebElement element = webDriver.findElement(By.cssSelector("div[id='flash']"));
//        String currentelement = element.getText();
//        String expected = "You logged into a secure area!";
//        Assert.assertTrue(currentelement.contains(expected));
//
//    }
//
//    @Then("I'm not logged in")
//    public void iMNotLoggedIn() {
//        WebElement element = webDriver.findElement(By.cssSelector("div[id='flash']"));
//        String currentelement = element.getText();
//        String expected = "Your password is invalid!";
//        Assert.assertTrue(currentelement.contains(expected));
//
//    }
//
//    @When("I type {string} and {string}")
//    public void iTypeAnd(String login, String password) {
//        iTypeAsLogin(login);
//        iTypeAsPassword(password);
//        iClickLoginButton();
//    }
//}


// nowy

    public class LoginMyStepDefs {
        WebDriver webDriver;
        WebDriverWait wait;
        @Before
        public void openBrowser() {
            System.setProperty("webdriver.chrome.driver", "/Users/patryknerc/Desktop/WebDrivers/chromedriver");
            webDriver = new ChromeDriver();
            wait = new WebDriverWait(webDriver, 3);
        }
        @And("I open login page")
        public void iOpenLoginPage() {
            webDriver.get("https://the-internet.herokuapp.com/login");
        }
        @After
        public void closeBrowser() {
            webDriver.quit();
        }
        @When("I type {string} as login")
        public void iTypeAsLogin(String login) {
            WebElement element = webDriver.findElement(By.cssSelector("input[type='text']"));
            element.sendKeys(login);
        }
        @And("I type {string} as password")
        public void iTypeAsPassword(String password) {
            WebElement element = webDriver.findElement(By.cssSelector("input[type='password']"));
            element.sendKeys(password);
        }
        @And("I click login button")
        public void iClickLoginButton() {
            WebElement element = webDriver.findElement(By.cssSelector("button[type='submit']"));
            element.click();
        }
        @Then("I am logged in")
        public void iAmLoggedIn() {
            wait.until(ExpectedConditions.urlContains("secure"));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/logout']"))); //"a" to hiperlacze
          //  WebElement element = webDriver.findElement(By.cssSelector("div[id='flash']")); // atrybut id o wartosci flash
          //  String currentelement = element.getText();
            String expectedResult = "You logged into a secure area!";
           // Assert.assertTrue(currentelement.contains(expectedResult));
            verifyText(expectedResult);
        }
        @Then("I am NOT logged in")
        public void iAmNOTLoggedIn() {
    //        WebElement element = webDriver.findElement(By.cssSelector("div[id = 'flash']"));
    //        String currentelement = element.getText();
            String expectedResult = "Your password is invalid!";
    //        Assert.assertTrue(currentelement.contains(expectedResult));
            verifyText(expectedResult);
        }

        private void verifyText(String expectedResult){
            WebElement element = webDriver.findElement(By.cssSelector("div[id = 'flash']"));
            String currentelement = element.getText();
          //  String expectedResult = "Your password is invalid!";
            Assert.assertTrue(currentelement.contains(expectedResult));
        //    verifyText(expectedResult);

        }
        @When("I type {string} and {string}")
        public void iTypeAnd(String login, String password) {
            iTypeAsLogin(login);
            iTypeAsPassword(password);
            iClickLoginButton();
        }
    }