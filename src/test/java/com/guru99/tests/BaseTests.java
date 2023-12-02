package com.guru99.tests;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;
import commonLibs.implentation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTests {

    CommonDriver cmnDriver;
    String url;
    WebDriver driver;
    LoginPage loginPage;
    String configFileName;
    String currentWorkinkgDirectory;
    Properties configProperty;
    String reportFilename;
    ReportUtils reportUtils;
    ScreenshotUtils screenshot;
    long executionTime = System.currentTimeMillis();

    @BeforeSuite
    public void preSetup()throws Exception{
        currentWorkinkgDirectory = System.getProperty("user.dir");
        configFileName = currentWorkinkgDirectory + "/config/config.properties";
        reportFilename = currentWorkinkgDirectory + "/reports/guru99TestReport"+ executionTime + ".html";
        configProperty = ConfigUtils.readProperties(configFileName);
        reportUtils = new ReportUtils(reportFilename);
    }


    @BeforeClass
    public void setup() throws Exception{
       url = configProperty.getProperty("baseUrl");
       String browserType = configProperty.getProperty("browserType");
       cmnDriver = new CommonDriver(browserType);
       driver = cmnDriver.getDriver();
       loginPage = new LoginPage(driver);
       screenshot = new ScreenshotUtils(driver);
       cmnDriver.navigateTourl(url);
    }

    @AfterClass
    public void tearDown(){
        cmnDriver.closeAllBrowser();
    }

    @AfterMethod
    public void postTestAction(ITestResult result)throws Exception{
        String testcasename = result.getName();
        String screenshotFilename = currentWorkinkgDirectory +  "/screenshots/" + testcasename + executionTime + ".jpeg";
        if(result.getStatus()==ITestResult.FAILURE){
            reportUtils.addTestLog(Status.FAIL,"One or more steps failed");
            screenshot.captureAndSaveScreenShot(screenshotFilename);
            reportUtils.attachScreeShotToReport(screenshotFilename);
        }
    }

    @AfterSuite
    public void postTeardown(){
        reportUtils.flushReport();
    }
}
