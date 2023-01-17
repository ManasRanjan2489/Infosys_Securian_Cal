package Modules;

import Base.Base;
import Pages.FactoryPage;
import Util.ConfigReader;
import org.testng.annotations.Test;

public class SubmitFormWithDefaultCalculatorValues extends Base {
    public FactoryPage factoryPage;
    ConfigReader config;

    @Test(description = "User should be able to update default calculator values")
    public void submitFormWithACalValue() {
        factoryPage = new FactoryPage(driver);
        config = new ConfigReader();

        factoryPage.calculator_Home_Page().submitMainFormDefaultCalculator(config.getCurrentAge(), config.getCRetirement_Age()
                , config.getCurrent_annual_income(), config.getSpouse_annual_income(), config.getCurrent_retirement_savings()
                , config.getCurrent_retirement_contribution(), config.getAnnual_retirement_contribution_increase());
        factoryPage.calculator_Home_Page().verifyUserIsOnDefaultCalculatorValuesPopup(10);
        factoryPage.calculator_Home_Page().submitDefaultCalculatorValuesPopupForm(config.getAdditional_Income(), config.getRetirement_Duration()
                , config.getExpected_Inflation_Rate(), config.getRetirement_Annual_Income()
                , config.getPre_Retirement_ROI(), config.getPost_Retirement_ROI());
        factoryPage.calculator_Home_Page().ClickCalculateBtn();
        factoryPage.calculator_Home_Page().verifyUserSeeTheResults(10);


    }
}
