package ReusableFunctionality;
 
import io.appium.java_client.AppiumDriver;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import BabyExecute.BABYRUN;
import BabyTestSteps.BabyTestSteps;
import SupportLibraries.Report;
 
 
public class babyfunction extends BabyTestSteps{
               
/////////////////////////////////////////Click by using ID///////////////////////               
                public static void clickbyid(String objects, String description,
                                                String testData)  {
                                try {
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.id(objects)).click();
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using name///////////////////////        
                public static void clickbyname(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.name(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.name(objects)).click();
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using xpath///////////////////////        
                public static void clickbyxpath(String objects,String description, String testData)
                {
                                try{
                                int count=driver.findElements(By.xpath(objects)).size();
                                if(count==1)
                                {
                                                driver.findElement(By.xpath(objects)).click();
                                                Report.pass( description,  objects, testData);
                                }else
                                {
                                                Report.fail(description+" Object not available",  objects, testData);
                                }
                                }
                                catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using LinkText///////////////////////  
                public static void clickbylinktext(String objects, String description,
                                                String testData){
                                try {
                                int count = driver.findElements(By.linkText(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.linkText(objects)).click();
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                               
                                                
                                }catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
 
/////////////////////////////////////////Click by using ID///////////////////////               
                public static void inputbyid(String objects, String description,
                                                String testData){
                                try{
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.id(objects)).sendKeys(testData);;
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Input by using name///////////////////////      
public static void inputbyname(String objects, String description,
                                String testData){
                try {
                int count = driver.findElements(By.name(objects)).size();
                if (count == 1) {
                                driver.findElement(By.name(objects)).sendKeys(testData);;
                                Report.pass(description, objects, testData);
                } else {
                                Report.fail(description+" Object not available", objects, testData);
                }
               
                                
                } catch (Exception e) {
                                Report.fail("Error: "+e, "Nil", "Nil");
                }
}

/////////////////////////////////////////Drop Down Selection Through Xpath(No test data)///////////////////////  

                public static void DropboxSelectXpath(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                               
                                                String dropText =  driver.findElement(By.xpath(objects)).getText();
                                                String[] drop=objects.split("/option");
                                                new Select(driver.findElement(By.xpath(drop[0]))).selectByVisibleText(dropText);
                                               
                                                Report.pass(description, objects, dropText);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }

               
/////////////////////////////////////////Input by using xpath///////////////////////                  
                public static void inputbyxpath(String objects, String description,
                                                String testData){
                                try{
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.xpath(objects)).sendKeys(testData);;
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
                
                
/*/////////////////////////////////////////Input by using xpath///////////////////////      
                public static void babyinputBack_xpath(String objects, String description,
                                                String testData)  {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                               
                                                                for(int i=0;i<=10;i++)
                                                                {
                                                                driver.findElement(By.xpath(objects)).sendKeys(Keys.BACK_SPACE);
                                                                }
                                                                driver.findElement(By.xpath(objects)).clear();
                                                               
                                                driver.findElement(By.xpath(objects)).sendKeys(testData);
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
               
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }*/
               
               
/////////////////////////////////////////Save Text by using xpath///////////////////////             
                public static void Savebyxpath(String objects, String description,
                                                String testData)  {
                                try {
                                String runtimeText="";;
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                runtimeText=driver.findElement(By.xpath(objects)).getText();
                                                if(runtimeText.trim().equals(testData))
                                                {
                                                                Report.pass("Expected text is available: "+testData, objects, testData);
                                                }else
                                                {
                                                                Report.fail("Expected text is not available: "+testData, objects,testData);
                                                }
                                                //Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
/*                public static String babySave_xpathReturn(String objects, String description,
                                                String testData) throws IOException, ParserConfigurationException,
                                                SAXException {
                                String runtimeText="";;
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                runtimeText=driver.findElement(By.xpath(objects)).getText();
                                                //System.out.println("Save Text"+runtimeText.trim());
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                try {
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                                return runtimeText;
}*/
                
                ////////String Compare/////////////////////   
               
                public static void stringCompare(String error1, String error2,String objects, String description,
                                                String testData)  {
                                try {
                                if (error1.trim().equals(error2.trim())) {
                                                Report.pass("Expected error message is available: " + error2, objects ,testData);
                                } else {
                                                Report.fail("Expected error message is not available: " + error2, objects ,testData);
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
               
/////////////////////////////////////////Save Text by using id///////////////////////     
                public static void Savebyid(String objects, String description,
                                                String testData)  {
                                try {
                                String runtimeText = "";
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                runtimeText = driver.findElement(By.id(objects)).getText();
                                                if (runtimeText.trim().equals(testData)) {
                                                                Report.pass("Expected text is available: " + testData, objects,
                                                                                                testData);
                                                } else {
                                                                Report.fail("Expected text is not available: " + testData,
                                                                                                objects, testData);
                                                }
                                                // Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
/////////////////////////////////////////Save Text by using name///////////////////////             
                public static void Savebyname(String objects, String description,
                                                String testData) {
                                try{
                                String runtimeText = "";
                                int count = driver.findElements(By.name(objects)).size();
                                if (count == 1) {
                                                runtimeText = driver.findElement(By.name(objects)).getText();
                                                if (runtimeText.trim().equals(testData)) {
                                                                Report.pass("Expected text is available: " + testData, objects,
                                                                                                testData);
                                                } else {
                                                                Report.fail("Expected text is not available: " + testData,
                                                                                                objects, testData);
                                                }
                                                // Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
                
                ////////Drop Down Select/////////////////////   
               
                public static void DropSelectbyID(String objects, String description,
                                                String testData) {
                                try{
                                String runtimeText = "";
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                new Select(driver.findElement(By.id(objects))).selectByVisibleText(testData);        
                                                Report.pass("Dro down selected successfully " + testData, objects,
                                                        testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
              
                ////////Mouse Moving verification/////////////////////   
               
                public static void MouseMovebyXpath(String objects, String description,
                                                String testData)  {
                                try{
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                               
                                                  WebElement MainMenu;
                          //WebElement SubMenu;
                          MainMenu = driver.findElement(By.xpath(objects));
                          //SubMenu = driver.findElement(By.xpath("//span/span[contains(.,'PAGs, PAs & Accounts')]"));
                          Actions builder = new Actions(driver);  
                           // Move cursor to the Main Menu Element  
                          builder.moveToElement(MainMenu).perform();
                          // Waiting For the Submenu to Display          
                          
                                                                Report.pass("Mouse moving success ", objects, testData);
                                               
                                }else{
                                                Report.fail(description + " Object not available", objects,              testData);
                                }
                                Thread.sleep(3000);}catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
               
                
                ////////Child Window navigation/////////////////////   
                
                public static void NavigateChildWIndow(String objects, String description,
                                                String testData) {
                                try{
                                //boolean blnExpectedWindowFound=false;
                                
                                for (String handle : driver.getWindowHandles()) {
                                                driver.switchTo().window(handle);
                                                String strCurrentUrl = driver.getCurrentUrl();
                                                //Decoding the URL
                                                String strDecodedUrl=URLDecoder.decode(strCurrentUrl, "US-ASCII");
                                                if ((strDecodedUrl.toUpperCase()).indexOf(testData.toUpperCase())!=-1){
                                                                //blnExpectedWindowFound=true;
                                                                try {
                                                                                ((JavascriptExecutor) driver).executeScript("window.focus();");
                                                                                driver.manage().window().maximize();
                                                                                Report.pass("Child window navigation Success", objects, testData);
                                                                } catch (Exception ex){
                                                                                Report.fail("Child window not available: "+testData, objects, testData);
                                                                }
                                                                break;
                                                }
                                } 
                                Thread.sleep(3000);}catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
               
              
                
                ////////Object available validation/////////////////////   
               
                public static void ObjectXpathYes(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                Report.pass(description + " Object available", objects,
                                                                                testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
                
                
          ////////Object not available validation/////////////////////      
                
                public static void ObjectXpathNO(String objects, String description,
                                                String testData)  {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 0) {
                                                Report.pass(description + " Object not available", objects,
                                                                                testData);
                                } else {
                                                Report.fail(description + " Object available", objects,
                                                                                testData);
                                }
                               
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
                
                
   /*             public static void babyDataMatch(String objects, String description,String testData) {
                try{
                                String splitt[]=objects.split("!");
     int rowcount1 = driver.findElements(By.xpath(splitt[0])).size();
     int rowcount2 = driver.findElements(By.xpath(splitt[1])).size();
                if(rowcount1==rowcount2)
                {
                                Report.pass("Expected data count is available both-- list box count is: "+rowcount1+" and Table view count is: "+rowcount2,description,testData);
                               
                }else
                {
                                Report.fail("Expected data count is not available both-- list box count is: "+rowcount1+" and Table view count is: "+rowcount2,description,testData);
                }
                   }catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
                */
                
///Browser back validation///////////////////                
                public static void Browserbackbyxpath(String objects, String description,
                                                String testData)  {
                                try{
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                Thread.sleep(3000);
                                                driver.navigate().back();
                                                Report.pass(description + " Object available", objects,
                                                                                testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                                
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
   
          	  public static void ScreenShot(String DES)
              {
                   try{
                          if(!Browser1.equals("HTML Unit Driver"))
                         {
                         DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
                         Date date1 = new Date();
                        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                        FileUtils.copyFile(scrFile, new File("Reports//"+date23+"//"+dateFormat1.format(date1)+"screenshot.png"));
                       
                                 bw.write("<tr>");
                                 bw.write("<td border="+2+" width="+50+">" +
                                             "<a href="+dateFormat1.format(date1)+"screenshot.png"+"><font color="+blue+"><b><center>ScreenShot</center></font></a></td>");
                                 bw.write("<td colspan="+5+" border="+2+" width="+300+">"+DES+"</td>");
                                 bw.write("</tr>");
                         }
                          Thread.sleep(500);
                   }catch(Exception e)
                 {
                        System.out.println("Error: "+e);
                 }
           
        }
              ///Page Scroll Down///////////////////             
                 
                public static void ScrollDownEnd() {
                                try{
                                Robot robot=new Robot();
                                robot.keyPress(java.awt.event.KeyEvent.VK_END);
                                robot.keyRelease(java.awt.event.KeyEvent.VK_END);
                                Thread.sleep(3000);}
                                catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
 /////////////Wait by ID/////////////////////////
                
                public static void waitbyID(String obj,int waittime) {
                	try{
                	(new WebDriverWait(mobiledriver, waittime))
 				   .until(ExpectedConditions.elementToBeClickable(By.id(obj)));
                	}catch (Exception e) {
                         Report.failm("Error: "+e, "Nil", "Nil");
         }

    }
               
}