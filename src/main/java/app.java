import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class app{
	WebDriver driver;
    JavascriptExecutor js;
    
    @BeforeAll
    public static void initialize() {
    	WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void prepareDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().setScriptTimeout(Duration.ofMinutes(2));

        js = (JavascriptExecutor) driver;
    }

    @Test
    public void verifyToDoListCreatedSuccessfully_noParams() throws InterruptedException {
    	driver.get("https://todomvc.com");
    	openTechnologyApp("Backbone.js");
    	addNewTodoItem("Meet a friend");
    	addNewTodoItem("Buy meat");
    	addNewTodoItem("clean the car");
    	removeTodo();
    	assertLeftItems(2);
       
    }
    private void assertLeftItems(int expectedCount) {
    	WebElement resultSpan = driver.findElement(By.xpath("//footer/*/span | //footer/span"));
    	if(expectedCount == 1 ) {
    		String expectedText = String.format("$d item left", expectedCount);
    		validateInnerText(resultSpan,expectedText);
    	} else {
    		String expectedTest = String.format("$d items left", expectedCount);
    		validateInnerText(resultSpan,expectedTest);
    	}
    }
    @ParameterizedTest
    @ValueSource(strings = {"Backbone.js",
    		"AngularJS",
    		"Dojo",
    		"React"})
    public void todosTestCase(String technologyName) {
    	driver.get("https://todomvc.com");
    	openTechnologyApp(technologyName);
    	addNewTodoItem("Meet a friend");
    	addNewTodoItem("Buy meat");
    	addNewTodoItem("clean the car");
    	removeTodo();
    	assertLeftItems(2);
       
    }
    
    private void openTechnologyApp(String technologyName) {
    	WebElement element = driver.findElement(By.linkText(technologyName));
        element.click();
    }
    private void addNewTodoItem(String todoItem) {
    	WebElement todoInput = driver.findElement(By.className("new-todo"));
    	todoInput.sendKeys(todoItem);
    	todoInput.sendKeys(Keys.RETURN);
    }
    private void removeTodo() {
    	WebElement todoRemoved = driver.findElement(By.cssSelector("li:nth-child(2) .toggle"));
    	todoRemoved.click();
    }

	private void validateInnerText(WebElement element, String expectedText) {
		ExpectedConditions.textToBePresentInElement(element, expectedText);
	}

	@AfterEach
    public void quitDriver() throws InterruptedException {
        driver.quit();
    }
}
