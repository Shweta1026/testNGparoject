package groupingconcept;

import org.testng.annotations.Test;

@Test(groups= {"all"})
public class Demo3 {
@Test(groups= {"smoke","windows.functional"})
public void Test8() {
	System.out.println("Test8");
}

@Test(groups= {"functional","regression"})
public void Test9() {
	System.out.println("Test9");
}

@Test(groups= {"windows.smoke"})
public void Test10() {
	System.out.println("Test10");
}
}
