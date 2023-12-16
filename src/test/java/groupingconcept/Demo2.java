package groupingconcept;

import org.testng.annotations.Test;

public class Demo2 {
	@Test(groups= {"sanity","functional"})
	public void Test4() {
		System.out.println("Test4");
	}
	
	@Test(groups= {"sanity","regression","windows.smoke"})
	public void Test5() {
		System.out.println("Test5");
	}

	
	@Test(groups= {"smoke","windows.sanity"})
	public void Test6() {
		System.out.println("Test6");
	}

	
	@Test
	public void Test7() {
		System.out.println("Test7");
	}


}
