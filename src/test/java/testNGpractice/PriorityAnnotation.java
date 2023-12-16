package testNGpractice;

import org.testng.annotations.Test;

public class PriorityAnnotation {
	
	@Test(priority=1)
	public void A() {
		System.out.println("A");
	}
	
	@Test(priority=3)
	public void Z() {
		System.out.println("Z");
	}
	
	@Test(priority=3)
	public void G() {
		System.out.println("G");
	}
	
	@Test(priority=4)
	public void D() {
		System.out.println("D");
	}

}
