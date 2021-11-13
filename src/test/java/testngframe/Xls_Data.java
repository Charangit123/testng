package testngframe;

import java.util.ArrayList;

public class Xls_Data {
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataExcel(){
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
		reader = new Xls_Reader("C:\\Users\\user1\\eclipse-workspace\\TestNg_frame_maven\\Book1.xlsx" );
		}catch (Exception e) {
			e.printStackTrace();
		}
		for(int rowCnt= 2; rowCnt<=reader.getRowCount("Sheet1");rowCnt++) {
			String firstname=reader.getCellData("Sheet1", "FirstName", rowCnt);
			String Surname=reader.getCellData("Sheet1", "Surname", rowCnt);
			String Email=reader.getCellData("Sheet1", "Email", rowCnt);
			String NewPassword=reader.getCellData("Sheet1", "NewPassword", rowCnt);
			String dobdate=reader.getCellData("Sheet1", "dobdate", rowCnt);
			String dobMonth=reader.getCellData("Sheet1", "dobMonth", rowCnt);
			String dobyear=reader.getCellData("Sheet1", "dobyear", rowCnt);
			String Gender=reader.getCellData("Sheet1", "Gender", rowCnt);
			
			Object ob[]= {firstname,Surname,Email,NewPassword,dobdate,dobMonth,dobyear,Gender};
			mydata.add(ob);
			}
			return mydata;
		}
	}


