package Modules;

import Base.Base;
import Pages.FactoryPage;
import Util.ConfigReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SocialSecurityBenefitsToggle extends Base {
    public FactoryPage factoryPage;
    ConfigReader config;

    /**
     * We can use Data provider also here for inputting multipleSets of data
     * Not Implemented data provider here
     *
     * @return
     */
    @DataProvider(name = "AllReqField")

    public static Object[][] inputData() {

        return new Object[][]{{"40", "68", "100000", "75000", "500000", "10", "1", "4000"}};
    }

    /**
     * Updating the methods as passing values from property file using ConfigReader
     */

    @Test(description = "User should be able to submit form with all required fields filled in")  //dataProvider = "AllReqField"

    public void submitFormWithAllReqField() {
        factoryPage = new FactoryPage(driver);
        config = new ConfigReader();

        factoryPage.calculator_Home_Page().submitFormWithAdditionalSocialSecurityField(config.getCurrentAge(), config.getCRetirement_Age()
                , config.getCurrent_annual_income(), config.getSpouse_annual_income(), config.getCurrent_retirement_savings()
                , config.getCurrent_retirement_contribution(), config.getAnnual_retirement_contribution_increase(), config.getSocial_Security_Override());
        factoryPage.calculator_Home_Page().verifyUserSeeTheResults(10);
    }
}
