package BabyExecute;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BabyTestSteps.BabyTestSteps;
import SupportLibraries.Report;
import SupportLibraries.pro_1;
import SupportLibraries.pro_2;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BABYRUN extends BabyTestSteps {
	  public static String Excel1;
	  public static String TCID1;
	  public static pro_2 file = new pro_2();
	  public static pro_1 objj = new pro_1(file.show());
	  
	private static String inputFile;
	public static void setInputFile(String inputFile) {
		BABYRUN.inputFile = inputFile;
	}
	
	public static void main(String ar[])  
	{
		try{
			Class noparams[] = {};
			Class cls = Class.forName("BabyTestSteps.BabyTestSteps");
			Object obj = cls.newInstance();
			
		setInputFile("Module.xls");
		File inputWorkbook = new File(inputFile);
		Workbook w;
		w = Workbook.getWorkbook(inputWorkbook);
		// Get the first sheet
		Sheet sheet = w.getSheet(0);
		
		int bbb=sheet.getRows();
		

		int bbbb=bbb-1;
		for(int i=0;i<=bbbb;i++)
		{
			String activeStatus=sheet.getCell(1,i).getContents();
			if(activeStatus.equals("Active"))
			{
				
				new File("Reports//" + date23).mkdir();
				Date date2 = new Date();
				String date233=dateFormat1.format(date2);
				File ff = new File("Reports//" + date23 + "//"
						+ sheet.getCell(0,i).getContents() +date233+ "_Module Summary_.htm");
				BufferedWriter bww = new BufferedWriter(new FileWriter(
						ff));
				
				
				bww.write("<html>");
				bww.write("<body bgcolor =" + "#d4d4d4" + ">");
				bww.write("<center><h3>SUMMARY REPORT</h3></center>");
				bww.write("<hr>");
				
				
				
				bww.write("<center><table border=" + 5 + " >");
				bww.write("<th width=" + 250
						+ " ><center>Module Name:</center></th>");
				bww.write("<th width=" + 250 + " ><center>"
						+ sheet.getCell(0,i).getContents() + "</center></th>");
				pro_2 file = new pro_2();
				pro_1 objj = new pro_1(file.show());
				String browser = objj.ReadProperty("Browser");
				bww.write("</center></table border=" + 5 + " >");
				bww.write("<hr>");
				bww.write("<center><table border=" + 5 + " >");
				bww.write("<tr>");
				bww.write("<th width="
						+ 250
						+ " bgcolor ="
						+ gray
						+ "><center>Execution Report PASS/FAIL</center></th>");
				bww.write("<th width=" + 250 + " bgcolor =" + gray
						+ "><center>TestCase ID</center></th>");
				bww.write("<th width=" + 250 + " bgcolor =" + gray
						+ "><center>Brower Name/Appium</center></th>");
				bww.write("<th width=" + 250 + " bgcolor =" + gray
						+ "><center>Date/Time</center></th>");
				bww.write("</tr>");

				String MDACTIVE=sheet.getCell(0,i).getContents();
				Excel1=MDACTIVE;
			    setInputFile("src//TestCases//"+MDACTIVE+".xls");
				File inputWorkbook1 = new File(inputFile);
				Workbook ww = Workbook.getWorkbook(inputWorkbook1);
				// Get the first sheet
				Sheet sheet1 = ww.getSheet(0);
				
				int rowcount=sheet1.getRows();
				for(int j=0;j<=rowcount-1;j++)
				{
					
					String TCactive=sheet1.getCell(1,j).getContents();
					if(TCactive.equals("Active"))
					{
						
						Date date3 = new Date();
						
						String date234=dateFormat1.format(date3);
						f = new File("Reports//" + date23 + "//"
								+ sheet1.getCell(0,j).getContents()+date234 + ".htm");
						bw = new BufferedWriter(new FileWriter(f));
						bw.write("<html>");
						bw.write("<body  bgcolor =" + "#d4d4d4"
								+ ">");

						bw.write("<center><h3>EXECUTION REPORT</h3></center>");
						bw.write("<hr>");
						bw.write("<center><table border=" + 5
								+ " >");
						// bw.write("<tr>");
						bw.write("<th width="
								+ 250
								+ " ><center>Module Name:</center></th>");
						bw.write("<th width=" + 250 + " ><center>"
								+ sheet.getCell(0,i).getContents() + "</center></th>");
						bw.write("</center></table border=" + 5
								+ " >");
						bw.write("<center><table border=" + 5
								+ " >");
						bw.write("<th width="
								+ 250
								+ " ><center>TestCase ID:</center></th>");
						bw.write("<th width=" + 250 + " ><center>"
								+  sheet1.getCell(0,j).getContents() + "</center></th>");
						// bw.write("</tr>");
						bw.write("</center></table border=" + 5
								+ " >");

						// /
						// bw.write("<center><h2>Module Name: "+modulename+" ---- Test Case ID: "+TestCaseID+"</h2></center>");
						bw.write("<hr>");
						// bw.write("<center><h2>Test Case ID: "+TestCaseID+"</h2></center>");
						bw.write("<table border=" + 5 + " ");
						bw.write("<hr>");
						
						
						String URLSTRING=sheet1.getCell(3,j).getContents();
						new BabyTestSteps().save(URLSTRING);
						
						int colcount=sheet1.getColumns();
						for(int k=4;k<=colcount-1;k++){ 
							String keywordd=sheet1.getCell(k,j).getContents();						
							if(keywordd.equals("")){
							break;	
							}
							
							if(k==4)
							{
							Method method = cls.getDeclaredMethod(keywordd, String.class);
							method.invoke(obj, sheet1.getCell(2,j).getContents());
							String BRO1=sheet1.getCell(2,j).getContents();
							
							}else
							{
								Method method = cls.getDeclaredMethod(keywordd);
								TCID1=sheet1.getCell(0,j).getContents();
								method.invoke(sheet1.getCell(0,j).getContents());
							}
							
						}

						bww.write("<tr>");
						int count = new Report().count();
						if (count > 0) {
							bww.write("<td border="
									+ 2
									+ " width="
									+ 50
									+ ">"
									+ "<a href="
									+ ""
									+  sheet1.getCell(0,j).getContents()+date234
									+ ".htm"
									+ "><font color="
									+ red
									+ "><b><center>FAIL Report</center></font></a></td>");

							bww.write("<td width=" + 50
									+ "><font><center>"
									+  sheet1.getCell(0,j).getContents()
									+ "</center></font></td>");
							bww.write("<td width=" + 50
									+ "><font><center>"
									+ sheet1.getCell(2,j).getContents()
									+ "</center></font></td>");
							DateFormat dateFormat1 = new SimpleDateFormat(
									"yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							bww.write("<td width=" + 150
									+ "><font color=" + black + ">"
									+ dateFormat1.format(date)
									+ "</font></td>");
							
						} else {
							
							bww.write("<td border="
									+ 2
									+ " width="
									+ 50
									+ ">"
									+ "<a href="
									+ ""
									+  sheet1.getCell(0,j).getContents()+date234
									+ ".htm"
									+ "><font color="
									+ green
									+ "><b><center>PASS Report</center></font></a></td>");

							bww.write("<td width=" + 50
									+ "><font><center>"
									+  sheet1.getCell(0,j).getContents()
									+ "</center></font></td>");
							bww.write("<td width=" + 50
									+ "><font><center>"
									+ sheet1.getCell(2,j).getContents()
									+ "</center></font></td>");
							DateFormat dateFormat2 = new SimpleDateFormat(
									"yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							bww.write("<td width=" + 150
									+ "><font color=" + black + ">"
									+ dateFormat2.format(date)
									+ "</font></td>");
						}

						Report.valueReset();
					}
					if (j == rowcount-1) {
						
						bww.write("</tr>");
						bww.write("</table>");
						bww.write("</body>");
						bww.write("</html>");
						bww.close();
						Desktop.getDesktop().browse(ff.toURI());
					}
					
					
					}
				 }
				
			}
			
		}catch(Exception e)
		{System.out.println("Exception: "+e);}
	}
}
