package testNGpractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider4 {
	@Test(dataProvider="data")
	public void test(Object s) {
		System.out.println(s);
		
	}
	
	@DataProvider(name="data")
	public Iterator<Object> testData() {
		List<Object> data=new ArrayList();
		data.add("java");
		data.add("selenium");
		data.add(123);
		return data.iterator();
		
	}

}
