package Pages;

import org.openqa.selenium.WebDriver;

public class FactoryPage {

    public WebDriver driver;
    public Calculator_Home_Page calculator_home_page;

    public FactoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public Calculator_Home_Page calculator_Home_Page() {
        if (calculator_home_page == null) {
            calculator_home_page = new Calculator_Home_Page(driver);
        }
        return calculator_home_page;
    }
}
