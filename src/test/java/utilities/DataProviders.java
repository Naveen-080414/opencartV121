package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// Data provider1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\loginTest.xlsx";      // taking xl file from the testData
		
		ExecleUtility xlutil=new ExecleUtility(path);   // creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcells=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcells];   // Created two dimension array which can store data
				
		for(int i=1;i<=totalrows;i++)  // 1  // read the data from xl storing into two dimensional array
		{
			for(int j=0;j<totalcells;j++)  // 0    // i is rows and j is cells
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1", i, j);  // 1, 0
			}
		}
		
		return logindata;    // returning two dimensional array
		
	}
	
	// Data Provider2
	
	// Data Provider3
	
	// Data Provider4
	
	
}
