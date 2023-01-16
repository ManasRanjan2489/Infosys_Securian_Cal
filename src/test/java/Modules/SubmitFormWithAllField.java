package Modules;

import Base.Base;
import Pages.FactoryPage;
import Util.ConfigReader;
import org.testng.annotations.Test;

public class SubmitFormWithAllField extends Base {
    public FactoryPage factoryPage;

    @Test(description = "User should be able to submit form with all fields filled in")
    public void submitFormWithAllField() {
        factoryPage = new FactoryPage(driver);
        factoryPage.calculator_Home_Page().submitFormWithAllMandatoryField("40", "68"
                , "$100000", "75000", "500000"
                , "10", "1");
        factoryPage.calculator_Home_Page().verifyUserSeeTheResults(10);

    }
}
