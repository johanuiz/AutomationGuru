package commonLibs.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ReportUtils {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public ReportUtils(String htmlReportFilename){
        htmlReportFilename = htmlReportFilename.trim();

        htmlReporter = new ExtentHtmlReporter(htmlReportFilename);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        }
        public void createTestCase(String testcaseName){
        extentTest = extentReports.createTest(testcaseName);
        }
        public void addTestLog(Status status, String comment){
        extentTest.log(status,comment);
        }
        public void attachScreeShotToReport(String filename)throws Exception{
        extentTest.addScreenCaptureFromPath(filename);
        }
        public void flushReport(){
        extentReports.flush();
        }
    }
