package StepDefs;

import Base.BaseScenario;

import Pages.SearchPage;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

public class SearchPageStepDef extends BaseScenario {

    SearchPage searchPage = new SearchPage();

    @When("^The user has entered the desired position \"(.*?)\"$")
    public void theUserHasEnteredThePosition(String position) {
        searchPage.typeThePosition(position);
    }

    @When("^The user has selected the desired location \"(.*?)\"$")
    public void theUserHasEnteredTheLocation(String location) {
        searchPage.selectTheLocation(location);
    }

    @Then("^The system should display at least \"(.*?)\" of opened positions$")
    public void theSystemShouldDisplayTheCorrectAmountOfOpenedPositions(Integer expectedAmount) {
        assertTrue("Expected amount of opened positions should be at least " + expectedAmount,
                searchPage.getAmountOfOpenedPositions() >= expectedAmount);
    }

    @When("^The user has clicked on the first found result with the text \"(.*?)\" and \"(.*?)\"$")
    public void theUserHasClickedOnTheFirstFoundResult(String position, String location) throws InterruptedException {
        searchPage.clickOnTheFirstFoundResult(position, location);
    }

    @Then("^The system should open the new page \"(.*?)\"$")
    public void theSystemShouldOpenTheNewPage(String page) {
        assertTrue("Expected URL should contain " + page, getCurrentUrl().contains(page));
    }

    @Then("^The title should contain the \"(.*?)\" and \"(.*?)\"$")
    public void theTitleShouldContainThePosition(String position, String location) {
        assertTrue("Expected position '" + position + "' not found", getTitle().contains(position));
        assertTrue("Expected location '" + location + "' not found", getTitle().contains(location));
    }

    @When("^The user has clicked the apply button")
    public void theUserHasClickedTheButton() {
        searchPage.clickOnApplyButton();
    }

    @Then("^The system should reveals the application e-mail \"(.*?)\"$")
    public void theSystemShouldRevealsTheApplicationEmail(String email) {
        assertTrue("Expected email '" + email + "' not found", getPageSource().contains(email));
    }
}
