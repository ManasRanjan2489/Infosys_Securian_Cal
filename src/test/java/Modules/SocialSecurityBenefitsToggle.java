package Modules;

import Base.Base;
import Pages.FactoryPage;
import Util.ConfigReader;
import org.testng.annotations.Test;

public class SocialSecurityBenefitsToggle extends Base {
    public FactoryPage factoryPage;
    ConfigReader config;

    @Test(description = "User should be able to submit form with all required fields filled in")
    public void submitFormWithAllReqField() {
        factoryPage = new FactoryPage(driver);
        factoryPage.calculator_Home_Page().submitFormWithAdditionalSocialSecurityField("40", "68"
                , "$100000", "75000", "500000"
                , "10", "1", "4000");
        factoryPage.calculator_Home_Page().verifyUserSeeTheResults(10);
    }
}
