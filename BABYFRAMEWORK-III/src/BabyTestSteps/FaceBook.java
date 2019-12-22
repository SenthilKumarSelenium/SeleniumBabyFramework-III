package BabyTestSteps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ReusableFunctionality.Mobilefunction;
import ReusableFunctionality.babyfunction;
import SupportLibraries.Excel;
import SupportLibraries.Report;
import SupportLibraries.pro_1;
import SupportLibraries.pro_2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import jxl.read.biff.BiffException;

public class FaceBook extends BabyTestSteps {
	
  public static pro_1 obj = new pro_1(file.show());
  public static pro_1 fb = new pro_1(file.fb());

  


  
  
  public static void TestTemplate() 
  {
	try {
				babyfunction.inputbyid(fb.ReadProperty("fbFirstname"), "Enter First name", Excel.Exceldata("FBTestData", "FirstName"));
				babyfunction.clickbyid(obj.ReadProperty("login"), "Login", "Nil");
	}catch(Exception e){
		Report.fail("Error: "+e, "Nil", "Nil");
	}
  }
  
  
  
  public static void fbLoginNew() 
  {
	  try{
		    babyfunction.inputbyid(fb.ReadProperty("fbEmail"), "Enter FB User name", "sadfsf");
		    babyfunction.inputbyid(fb.ReadProperty("fbPassword"), "Enter FB Password", "sdfdgr");
	  
	  }catch(Exception e)
	  {
		  Report.fail("Error: "+e, "Nil", "Nil");
	  }
		
		
  }
  
  public static void fbRegistrationDropDown() 
  {
	  try{
 		    babyfunction.inputbyid(fb.ReadProperty("fbFirstname"), "Enter First name", Excel.Exceldata("FBTestData", "FirstName"));
		    babyfunction.inputbyid(fb.ReadProperty("fbLastName"), "Enter Last Name", Excel.Exceldata("FBTestData", "LastName"));
		    babyfunction.inputbyid(fb.ReadProperty("fbmailId"), "Enter Mail ID", Excel.Exceldata("FBTestData", "MailID"));
		    babyfunction.inputbyid(fb.ReadProperty("fbReenterMailid"), "Enter Mail OID again", Excel.Exceldata("FBTestData", "ConfirmMailID"));
		    babyfunction.inputbyid(fb.ReadProperty("fbnewPassword"), "Enter Confirm Password", Excel.Exceldata("FBTestData", "Password"));
		    
		  
		    babyfunction.DropSelectbyID(fb.ReadProperty("fbDaySelectid"), "Drop down select day", Excel.Exceldata("FBTestData", "DD"));
		    babyfunction.DropSelectbyID(fb.ReadProperty("fbMonthSelectid"), "Drop down select Month", Excel.Exceldata("FBTestData", "MM"));
		    babyfunction.DropSelectbyID(fb.ReadProperty("fbYearSelectid"), "Drop down select year", Excel.Exceldata("FBTestData", "YYYY"));
		    
		    String Gender=Excel.Exceldata("FBTestData", "Gender");
		    if(Gender.equals("Male")){
		    babyfunction.clickbyid(fb.ReadProperty("male"), "Click male option", "Nil");
		    }else{
		    babyfunction.clickbyid(fb.ReadProperty("female"), "Click female option", "Nil");	
		    }
		    babyfunction.ScreenShot("FB Registration Page");
		    babyfunction.clickbyid(fb.ReadProperty("fbsignup"), "Click signup Button", "Nil");
	  }catch(Exception e){
		  Report.fail("Error: "+e, "Nil", "Nil");
}
	  
}					

  
  
}
