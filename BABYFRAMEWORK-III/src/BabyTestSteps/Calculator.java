package BabyTestSteps;

import io.appium.java_client.MobileBy;
import ReusableFunctionality.Mobilefunction;
import SupportLibraries.Report;
import SupportLibraries.pro_1;


public class Calculator extends BabyTestSteps {
	
  public static pro_1 calc = new pro_1(file.calc());

  


  
  public static void calculatorSUM() 
  {
	  try{
 		  Mobilefunction.ScreenShot("Calculator launch");
		  Mobilefunction.clickbyname(mobiledriver,calc.ReadProperty("Button2"), "Click 2", "Nil");
		  Mobilefunction.clickbyname(mobiledriver,calc.ReadProperty("Button+"), "Click +", "Nil");
		  Mobilefunction.clickbyname(mobiledriver,calc.ReadProperty("Button4"), "Click 4", "Nil");
		  Mobilefunction.clickbyname(mobiledriver,calc.ReadProperty("Button4"), "Click 4", "Nil");
		  Mobilefunction.clickbyname(mobiledriver,calc.ReadProperty("ButtonEqual"), "Click =", "Nil");
		  Mobilefunction.ScreenShot("Calculator Sum Value");
          try{
		  String sum=mobiledriver.findElement(MobileBy.xpath(calc.ReadProperty("Textarea"))).getText();
		  if(sum.equals("46"))
		  {
			  Report.pass("Expect Text is available: "+sum, "NIL", "NIL");
		  }else{
			  Report.fail("Expect Text is not available: "+sum, "NIL", "NIL"); 
		  }
          }catch(Exception e)
          {
        	  Report.fail("Error: "+e, "Nil", "Nil");
          }

  }catch(Exception e)
  {
	  Report.fail("Error: "+e, "Nil", "Nil");
  }
		
  }

  

  
}
