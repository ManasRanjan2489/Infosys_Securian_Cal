package Pages;

import Util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Calculator_Home_Page extends GlobalPage {
    @FindBy(id = "current-age")
    WebElement Current_Age;

    @FindBy(id = "retirement-age")
    WebElement Retirement_Age;

    @FindBy(id = "current-income")
    WebElement Current_Annual_Income;

    @FindBy(id = "spouse-income")
    WebElement Spouses_annual_income;

    @FindBy(id = "current-total-savings")
    WebElement Current_retirement_savings_balance;

    @FindBy(id = "current-annual-savings")
    WebElement Current_saving_retirement_contribution;

    @FindBy(id = "savings-increase-rate")
    WebElement Annual_retirement_contribution_increase;

    @FindBy(xpath = "//label[@for = 'yes-social-benefits']")
    WebElement Social_Security_Income_Yes;

    @FindBy(xpath = "//label[@for = 'no-social-benefits']")
    WebElement Social_Security_Income_No;

    @FindBy(xpath = "//label[@for = 'single']")
    WebElement Relationship_status_Single;

    @FindBy(xpath = "//label[@for = 'married']")
    WebElement Relationship_status_Married;

    @FindBy(id = "social-security-override")
    WebElement Social_Security_Override;

    @FindBy(xpath = "//button[@data-tag-id= 'submit']")
    WebElement calculate_Button;

    @FindBy(xpath = "//div[@id=\"calculator-results-container\"]//h3[text()='Results']")
    WebElement Results_txt;

    @FindBy(xpath = "//button[@class='dsg-btn-primary btn-block' and @data-target='#calc-email-modal']")
    WebElement Email_My_Results_txt;

    @FindBy(xpath = "//button[@onclick='navigateToRetirementForm();']")
    WebElement Edit_Info_txt;

    @FindBy(xpath = "//button[@class='dsg-btn-secondary btn-block' and @onclick='showFullResults();']")
    WebElement See_Full_Results_txt;

    @FindBy(xpath = "//a[text()='Adjust default values']")
    WebElement Adjust_default_values_btn;

    @FindBy(xpath = "//h1[text()='Default calculator values']")
    WebElement Default_calculator_values_txt;

    @FindBy(id = "additional-income")
    WebElement Additional_other_income;

    @FindBy(id = "retirement-duration")
    WebElement Retirement_duration;

    @FindBy(xpath = "//label[@for = 'include-inflation' and text() = 'Yes']")
    WebElement Post_retirement_inflation_yes;

    @FindBy(id = "expected-inflation-rate")
    WebElement expected_inflation_rate;

    @FindBy(id = "retirement-annual-income")
    WebElement retirement_annual_income;

    @FindBy(id = "pre-retirement-roi")
    WebElement pre_retirement_roi;

    @FindBy(id = "post-retirement-roi")
    WebElement post_retirement_roi;

    @FindBy(xpath = "//button[text() = 'Save changes']")
    WebElement Save_changes_btn;


    public Calculator_Home_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void submitFormWithAllMandatoryField(String Age, String Retirement_Age_value, String Current_Annual_Income_Value, String Spouses_annual_income_Value,
                                                String Current_retirement_savings_value, String Current_retirement_contribution_value, String Annual_contribution_increase_value) {
        typeIn(Current_Age, Age);
        typeIn(Retirement_Age, Retirement_Age_value);
        typeIn(Current_Annual_Income, Current_Annual_Income_Value);
        typeIn(Spouses_annual_income, Spouses_annual_income_Value);
        typeIn(Current_retirement_savings_balance, Current_retirement_savings_value);
        typeIn(Current_saving_retirement_contribution, Current_retirement_contribution_value);
        typeIn(Annual_retirement_contribution_increase, Annual_contribution_increase_value);
        clickOn(calculate_Button);
    }

    public void submitFormWithAllRequiredField(String Age, String Retirement_Age_value, String Current_Annual_Income_Value,
                                               String Current_retirement_savings_value, String Current_retirement_contribution_value, String Annual_contribution_increase_value) {
        typeIn(Current_Age, Age);
        typeIn(Retirement_Age, Retirement_Age_value);
        typeIn(Current_Annual_Income, Current_Annual_Income_Value);
        typeIn(Current_retirement_savings_balance, Current_retirement_savings_value);
        typeIn(Current_saving_retirement_contribution, Current_retirement_contribution_value);
        typeIn(Annual_retirement_contribution_increase, Annual_contribution_increase_value);
        clickOn(calculate_Button);
    }

    public void submitFormWithAdditionalSocialSecurityField(String Age, String Retirement_Age_value, String Current_Annual_Income_Value,
                                                            String Spouses_annual_income_Value,
                                                            String Current_retirement_savings_value, String Current_retirement_contribution_value,
                                                            String Annual_contribution_increase_value, String Social_Security_Override_value) {
        typeIn(Current_Age, Age);
        typeIn(Retirement_Age, Retirement_Age_value);
        typeIn(Current_Annual_Income, Current_Annual_Income_Value);
        typeIn(Spouses_annual_income, Spouses_annual_income_Value);
        typeIn(Current_retirement_savings_balance, Current_retirement_savings_value);
        typeIn(Current_saving_retirement_contribution, Current_retirement_contribution_value);
        typeIn(Annual_retirement_contribution_increase, Annual_contribution_increase_value);
        check(Social_Security_Income_Yes);
        check(Relationship_status_Single);
        typeIn(Social_Security_Override, Social_Security_Override_value);
        clickOn(calculate_Button);

    }

    public void verifyUserSeeTheResults(int timeInSec) {
        explicitWait(Results_txt,timeInSec);
        Assert.assertEquals(getTextOrValue(Results_txt), Constants.RESULTS_TEXT);
    }

    public void verifyUserIsOnDefaultCalculatorValuesPopup(int timeInSec){
        explicitWait(Default_calculator_values_txt,timeInSec);
        Assert.assertEquals(getTextOrValue(Default_calculator_values_txt), Constants.DEFAULT_CALCULATOR_VALUE_TXT);
    }

    public void submitDefaultCalculatorValuesPopupForm(String Additional_other_income_val, String Retirement_duration_val, String expected_inflation_rate_val,
                                                       String retirement_annual_income_val,String pre_retirement_roi_val, String post_retirement_roi_val){
        typeIn(Additional_other_income, Additional_other_income_val);
        typeIn(Retirement_duration, Retirement_duration_val);
        check(Post_retirement_inflation_yes);
        typeIn(expected_inflation_rate, expected_inflation_rate_val);
        typeIn(retirement_annual_income, retirement_annual_income_val);
        typeIn(pre_retirement_roi, pre_retirement_roi_val);
        typeIn(post_retirement_roi, post_retirement_roi_val);
        clickOn(Save_changes_btn);
    }

    public void submitMainFormDefaultCalculator(String Age, String Retirement_Age_value, String Current_Annual_Income_Value, String Spouses_annual_income_Value,
                                                String Current_retirement_savings_value, String Current_retirement_contribution_value, String Annual_contribution_increase_value) {
        typeIn(Current_Age, Age);
        typeIn(Retirement_Age, Retirement_Age_value);
        typeIn(Current_Annual_Income, Current_Annual_Income_Value);
        typeIn(Spouses_annual_income, Spouses_annual_income_Value);
        typeIn(Current_retirement_savings_balance, Current_retirement_savings_value);
        typeIn(Current_saving_retirement_contribution, Current_retirement_contribution_value);
        typeIn(Annual_retirement_contribution_increase, Annual_contribution_increase_value);
        clickOn(Adjust_default_values_btn);
    }

    public void ClickCalculateBtn(){
        clickOn(calculate_Button);
    }
}
