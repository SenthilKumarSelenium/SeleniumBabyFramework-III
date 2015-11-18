package SupportLibraries;

import java.io.File;
import java.io.IOException;

import BabyExecute.BABYRUN;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel extends BABYRUN {
	
	
	public static String Exceldata(String SheetName,String ColumnName) throws BiffException, IOException{
		
		File inputworkbook=new File("src//TestCases//"+Excel1+".xls");
		Workbook w;
		w=Workbook.getWorkbook(inputworkbook);
		Sheet sheet=w.getSheet(SheetName);
		int ii=0;
		while(ii<=400)
		{
			String name=sheet.getCell(ii,0).getContents();
			if(name.equals(ColumnName))
			{
				break;
			}
			ii++;
		}
		int jj=0;
		while(jj<=400)
		{
			String name=sheet.getCell(0,jj).getContents();
			if(name.equals(TCID1))
			{
				break;
			}
			jj++;
		}
		String op=sheet.getCell(ii,jj).getContents();
		w.close();
		return op;
		
	}

}
