package groupingconcept;

import org.testng.annotations.Test;

public class Demo1 {
	@Test(groups= {"smoke","regression"})
	public void Test1() {
		System.out.println("Test1");
	}
	
	@Test(groups= {"functional","regression"})
	public void Test2() {
		System.out.println("Test2");
	}

	
	@Test(groups= {"regression"})
	public void Test3() {
		System.out.println("Test3");
	}


}
