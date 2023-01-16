package Modules;

import Base.Base;
import Pages.FactoryPage;
import org.testng.annotations.Test;

public class SubmitFormWithDefaultCalculatorValues extends Base {
    public FactoryPage factoryPage;

    @Test(description = "User should be able to update default calculator values")
    public void submitFormWithACalValue() {
        factoryPage = new FactoryPage(driver);
        factoryPage.calculator_Home_Page().submitMainFormDefaultCalculator("40", "68"
                , "$100000", "75000", "500000"
                , "10", "1");
        factoryPage.calculator_Home_Page().verifyUserIsOnDefaultCalculatorValuesPopup(10);
        factoryPage.calculator_Home_Page().submitDefaultCalculatorValuesPopupForm("500", "20"
                , "7", "75"
                , "8", "5");
        factoryPage.calculator_Home_Page().ClickCalculateBtn();
        factoryPage.calculator_Home_Page().verifyUserSeeTheResults(10);


    }
}
