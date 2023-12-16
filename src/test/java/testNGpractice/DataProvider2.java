package testNGpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
	@Test(dataProvider="data")
	public void test(Object s) {
		System.out.println(s);
		
	}
	
	@DataProvider(name="data")
	public Object[] testData() {
		Object[] data=new Object[] {
		"abc",
		123};
		return data;
		
	}

}
