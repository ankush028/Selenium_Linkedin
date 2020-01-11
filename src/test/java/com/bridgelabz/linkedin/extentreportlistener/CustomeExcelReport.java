package com.bridgelabz.linkedin.extentreportlistener;

import org.automationtesting.excelreport.Xl;

public class CustomeExcelReport {
 
	public static void getCustomReport() {
		try {
			Xl.generateReport("/home/admin1/Desktop/JavaAdvanced/Linkedin/CustomExcelReport"
					,"excelReport.xlsx" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
