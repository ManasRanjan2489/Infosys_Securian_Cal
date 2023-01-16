package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GlobalPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public GlobalPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void typeIn(final WebElement locator, final String element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
            // locator.clear();
            locator.click();
            locator.sendKeys(element);
        } catch (Exception e) {
            throw new RuntimeException("element is not displayed");
        }

    }

    public void clickOn(final WebElement locator) {
        try {
//            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
        } catch (Exception e) {
            if (!locator.isDisplayed()) {
                throw new NoSuchElementException(locator.toString(), e);
            } else {
                if (!locator.isEnabled()) {
                    throw new RuntimeException("element is not displayed");
                }
            }

        }
    }

    /**
     * This method waits until page is loaded, then if checkbox is unchecked, it checks,
     * if checkbox is checked, it does nothing.
     *
     * @param element UIElement that appears on the page.
     */
    protected void check(final WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * This method waits until page is loaded, then if checkbox is checked, it unchecks,
     * if checkbox is unchecked, it does nothing.
     *
     * @param element UIElement that appears on the page.
     */
    protected void unCheck(final WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected String getTextOrValue(final WebElement element) {
        String result;
        result = element.getText();

        if (result != null && !result.isEmpty()) {
            return result;
        } else {
            result = element.getAttribute("value");
            return result;
        }

    }
    public void explicitWait(WebElement locator, int timeInSec) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }




}
