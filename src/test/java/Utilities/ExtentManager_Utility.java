package Utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager_Utility 
{
	public static ExtentReports extent;

    public static ExtentReports getReport() {

        ExtentSparkReporter spark =
         new ExtentSparkReporter(
           "./Reports/AutomationExerciseReport.html");

        extent = new ExtentReports();

        extent.attachReporter(spark);

        return extent;
    }
}

