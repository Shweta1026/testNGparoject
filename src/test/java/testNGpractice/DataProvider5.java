package testNGpractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider5 {
	@Test(dataProvider="data")
	public void test(Object[] s) {
		System.out.println(s[0]+">>"+s[1]);
		
	}
	
	@DataProvider(name="data")
	public Iterator<Object> testData() {
		List<Object> data=new ArrayList();
		data.add(new Object[] {"abc","xyz"});
		data.add(new Object[] {"pqr","mno"});
		
		return data.iterator();
		
	}
}
