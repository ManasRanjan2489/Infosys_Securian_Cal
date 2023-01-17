package Util;

import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties pro;

    public ConfigReader() {
        try {
            File src = new File("./Configuration/config.property");
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            Reporter.log("Exception is ==" + e.getMessage());
        }
    }

    public String getBrowserName() {
        return pro.getProperty("browser");
    }

    public String getCurrentAge() {
        return pro.getProperty("Current_Age");
    }

    public String getCRetirement_Age() {
        return pro.getProperty("Retirement_Age");
    }

    public String getCurrent_annual_income() {
        return pro.getProperty("Current_annual_income");
    }

    public String getSpouse_annual_income() {
        return pro.getProperty("Spouse_annual_income");
    }

    public String getCurrent_retirement_savings() {
        return pro.getProperty("Current_retirement_savings");
    }

    public String getCurrent_retirement_contribution() {
        return pro.getProperty("Current_retirement_contribution");
    }

    public String getAnnual_retirement_contribution_increase() {
        return pro.getProperty("Annual_retirement_contribution_increase");
    }

    public String getSocial_Security_Override() {
        return pro.getProperty("Social_Security_Override");
    }

    public String getAdditional_Income() {
        return pro.getProperty("Additional_Income");
    }

    public String getRetirement_Duration() {
        return pro.getProperty("Retirement_Duration");
    }

    public String getExpected_Inflation_Rate() {
        return pro.getProperty("Expected_Inflation_Rate");
    }

    public String getRetirement_Annual_Income() {
        return pro.getProperty("Retirement_Annual_Income");
    }

    public String getPre_Retirement_ROI() {
        return pro.getProperty("Pre_Retirement_ROI");
    }

    public String getPost_Retirement_ROI() {
        return pro.getProperty("Post_Retirement_ROI");
    }


    /**
     * Additional_Income = 500
     * Retirement_Duration = 20
     * Expected_Inflation_Rate = 7
     * Retirement_Annual_Income = 75
     * Pre_Retirement_ROI = 8
     * Post_Retirement_ROI = 5
     */

}
