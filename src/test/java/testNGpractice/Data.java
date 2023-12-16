package testNGpractice;

import org.testng.annotations.DataProvider;

public class Data {
	
	@DataProvider(name="data",indices= {0,1},parallel=true)
	public Object[][] testData() {
		Object[][] data=new Object[][] {
			{"Admin","admin123"},
		    {"Admin","test"},
		    {"pqr",456}
		};
		return data;
		
	}

}
