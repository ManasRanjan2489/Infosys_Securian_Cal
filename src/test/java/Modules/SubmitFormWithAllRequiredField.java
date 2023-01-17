package Modules;

import Base.Base;
import Pages.FactoryPage;
import Util.ConfigReader;
import org.testng.annotations.Test;

public class SubmitFormWithAllRequiredField extends Base {

    public FactoryPage factoryPage;
    ConfigReader config;

    @Test(description = "User should be able to submit form with all required fields filled in")
    public void submitFormWithAllReqField() {
        factoryPage = new FactoryPage(driver);
        config = new ConfigReader();

        factoryPage.calculator_Home_Page().submitFormWithAllRequiredField(config.getCurrentAge(), config.getCRetirement_Age()
                , config.getCurrent_annual_income(), config.getCurrent_retirement_savings()
                , config.getCurrent_retirement_contribution(), config.getAnnual_retirement_contribution_increase());
        factoryPage.calculator_Home_Page().verifyUserSeeTheResults(10);


    }
}
