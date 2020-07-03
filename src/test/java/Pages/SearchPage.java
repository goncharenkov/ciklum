package Pages;

import Base.BaseScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BaseScenario {

    public void typeThePosition(String position) {
        driver.findElement(By.id("searchtext")).sendKeys(position);
    }

    public void selectTheLocation(String location) {
        driver.findElement(By.cssSelector("button[data-id='cityName']")).click();
        driver.findElement(By.linkText(location)).click();
    }

    public Integer getAmountOfOpenedPositions() {
        return driver.findElements(By.xpath("//*[@id=\"suche-kontext\"]/form/div[1]/ul/a/li")).size();
    }

    public void clickOnTheFirstFoundResult(String position, String location) throws InterruptedException {
        waitForElementToBeClickable(By.className("list-group-item"));
        List<WebElement> webElements = driver.findElements(By.className("list-group-item"));
        for (WebElement webElement : webElements) {
            if (webElement.getText().contains(position) && webElement.getText().contains(location)) {
                webElement.click();
                return;
            }
        }
    }

    public void clickOnApplyButton() {
        driver.findElement(By.id("applyNow")).click();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

}
