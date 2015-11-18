package BabyTestSteps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
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
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import BabyExecute.BABYRUN;

//import com.gargoylesoftware.htmlunit.javascript.host.Document;
//import com.opera.core.systems.OperaDriver;
//import com.opera.core.systems.OperaProfile;






import ReusableFunctionality.babyfunction;
import SupportLibraries.Report;
import SupportLibraries.pro_1;
import SupportLibraries.pro_2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BabyTestSteps  {
	
  public static WebDriver driver;
  public static AppiumDriver mobiledriver;
  public static String baseUrl;
  public static BufferedWriter bw;
  public static File f;
  public static String gray="gray";  
  public static String red="red";  
  public static String green="green"; 
  public static String Yellow="Yellow";
  public static String Orange="Orange";
  public static String  black="black";
  public static String blue="blue";
  public static String abc;
  public static String Browser1;
  public static DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
  public static Date date1 = new Date();
  public static String date23=dateFormat1.format(date1);
  public static pro_2 file = new pro_2();
  public static pro_1 obj = new pro_1(file.show());


  ///////////////////////////////////////browser setup//////////////////////////////////////////////////// 
  public static WebDriver browser(String TCID) throws ParserConfigurationException, SAXException, IOException
  {
	  String browser=TCID;
	        if(browser.equals("Mozilla"))
	        {
	        	driver = new FirefoxDriver();
	        }
	        if(browser.equals("IE"))
	        {
	            System.setProperty("webdriver.ie.driver", obj.ReadProperty("IEDriver"));
	            DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
	            capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            driver = new InternetExplorerDriver(capab); 
	        }
	        if(browser.equals("Chrome"))
	        {
        	    System.setProperty("webdriver.chrome.driver", obj.ReadProperty("ChromeDriver"));
	            DesiredCapabilities capab = DesiredCapabilities.chrome();
	            driver = new ChromeDriver(capab);
	        }
	        if(browser.equals("Safari"))
	        {
	        	 driver = new SafariDriver();
	        }
	        if(browser.equals("Opera"))
	        {
	        	 System.setProperty("webdriver.opera.driver", obj.ReadProperty("OperaDriver"));
	        	DesiredCapabilities capabilities = DesiredCapabilities.opera();
	        	 driver = new OperaDriver(capabilities);
	        }
	        if(browser.equals("HTML Unit Driver"))
	        {
	        	driver = new HtmlUnitDriver();
	        }
	        
	return driver;
  }
  

  public static WebDriver StartAppium(String browser) throws ParserConfigurationException, SAXException, IOException
  {
	  try{
	       
	        	DesiredCapabilities cap=new DesiredCapabilities();
	    		cap.setCapability("BROWSER_NAME", "Android");
	    		cap.setCapability("VERSION",obj.ReadProperty("AndroidVersion"));
	    		cap.setCapability("deviceName",obj.ReadProperty("DeviceName"));
	    		cap.setCapability("platformName","Android");
	    		
	    		cap.setCapability("appPackage",obj.ReadProperty("AppPackage"));
	    		cap.setCapability("appActivity",obj.ReadProperty("AppActivity"));
	    		
	    		mobiledriver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	    		Report.heading();
	  		  Report.pass("application launches successfully","Nil",obj.ReadProperty(abc));
	  		BROReturn(browser);
	  }catch(Exception e)
	  {
		  System.out.println("Exception: "+e);
	  }
	return mobiledriver;
  }
   public static String BROReturn(String browser) 
  {
	Browser1=browser;
	return Browser1;
  }
   
  public static String save(String url) throws ParserConfigurationException, SAXException, IOException
  {
	  abc=url;
	return url;
  }
    public static String StartBrowser(String Browser11) throws IOException, ParserConfigurationException, SAXException
  {
	 driver=browser(Browser11);
	  try{
		  
	      driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      driver.get(obj.ReadProperty(abc));
	      Report.heading();
		  Report.pass("application launches successfully","Nil",obj.ReadProperty(abc));
		 
	  	}catch(Exception e)
		  {
			  System.out.println("Error: "+e);
		  }
	  Browser1=Browser11;
	return Browser1;
  }
  

    public static String StopBrowser()
    {
  	  try{
  		  
  		    driver.quit();
  		    bw.write("</table>");
  		    bw.write("<hr>");
  		    bw.write("<center><h2> Test Steps Status</h2></center>");
  		    bw.write("<center><table border="+3+"");
  		    Report.headingStatus();
  		    Report.totalStatus();
  		    
  		    //Desktop.getDesktop().browse(f.toURI());
  			  }catch(Exception e)
  			  {
  				  System.out.println("Error: "+e);
  			  }
  	return null;
    }
    
    public static String stopAppium()
    {
  	  try{
  		    mobiledriver.closeApp();
  			mobiledriver.quit();
  		    bw.write("</table>");
  		    bw.write("<hr>");
  		    bw.write("<center><h2> Test Steps Status</h2></center>");
  		    bw.write("<center><table border="+3+"");
  		    Report.headingStatus();
  		    Report.totalStatus();
  		    
  		    //Desktop.getDesktop().browse(f.toURI());
  			  }catch(Exception e)
  			  {
  				  System.out.println("Error: "+e);
  			  }
  	return null;
    }
    
    
    
    //////////////////////////////////////////////////////Test Steps/////////////////////////////////////////////////////////////////////////////////////////
    
     
    
  ////Appium Calculator Test//////  
  public static void calculatorSUM() 
  { try{
			Calculator.calculatorSUM();
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  
  //// Fb registration Test////////////
  public static void fbRegistration() 
  { try{
			FaceBook.fbRegistrationDropDown();
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  


  
  

  

}
