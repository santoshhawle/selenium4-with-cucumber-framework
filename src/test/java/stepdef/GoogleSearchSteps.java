package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import roboticqa.core.DriverFactory;

public class GoogleSearchSteps {

    private WebDriver driver;

    @Given("User is on google search page")
    public void user_is_on_google_search_page() {
        driver = DriverFactory.getDriver(DriverFactory.BrowserType.CHROME);
        driver.get("https://www.google.com");
    }

    @When("User search for {string}")
    public void userSearchFor(String searchText) {
        driver.findElement(By.name("q")).sendKeys(searchText);
        driver.findElement(By.name("q")).submit();
    }

    @Then("User should see the search results")
    public void userShouldSeeTheSearchResults() {
        DriverFactory.quitDriver();
    }
}