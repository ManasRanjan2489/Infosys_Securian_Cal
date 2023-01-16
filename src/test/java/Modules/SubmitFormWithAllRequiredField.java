package Modules;

import Base.Base;
import Pages.FactoryPage;
import org.testng.annotations.Test;

public class SubmitFormWithAllRequiredField extends Base {

    public FactoryPage factoryPage;

    @Test(description = "User should be able to submit form with all required fields filled in")
    public void submitFormWithAllReqField() {
        factoryPage = new FactoryPage(driver);
        factoryPage.calculator_Home_Page().submitFormWithAllRequiredField("40", "68"
                , "$100000", "500000"
                , "10", "1");
        factoryPage.calculator_Home_Page().verifyUserSeeTheResults(10);


    }
}
