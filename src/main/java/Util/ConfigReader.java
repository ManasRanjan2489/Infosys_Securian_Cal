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
            Reporter.log("Exception is =="+e.getMessage());
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
}
