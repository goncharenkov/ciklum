package Common;

import Base.BaseScenario;
import cucumber.api.java.en.Given;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class CommonStepDef extends BaseScenario {

    @Given("^The user has opened a website as \"(.*?)\"$")
    public void theUserHasOpenedWebSite(String screenSize) {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        if (screenSize.equalsIgnoreCase("desktop")) {
            // Resize the browser to desktop
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(1268, 1024));
        } else if (screenSize.equalsIgnoreCase("hd-desktop")) {
            // Resize the browser to desktop
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(1968, 1024));
        } else if (screenSize.equalsIgnoreCase("mobile")) {
            // Resize the browser to mobile
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(320, 568));
        } else if (screenSize.equalsIgnoreCase("tablet")) {
            // Resize the browser to mobile
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(768, 1024));
        }
        driver.get(getSiteBaseUrl() + "/");
    }

    @Given("^The user has navigated to a search page")
    public void theUserHasNavigatedToSearchPage() {
        driver.get(getSiteBaseUrl() + "zeitarbeit-de/bewerber/jobs-deutsche-bahn");
    }
}