package testNGpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {
	@Test(dataProvider="data")
	public void test(Object[] s) {
		for(int i=0;i<s.length;i++) {
			System.out.println(s[i]);
		}
		System.out.println("********");
		
	}
	
	@DataProvider(name="data")
	public Object[][] testData() {
		Object[][] data=new Object[][] {
			{"abc",123,},
		    {"xyz",123,334,"ddd"},
		    {"pqr",456,"ert"}
		};
		return data;
		
	}


}
