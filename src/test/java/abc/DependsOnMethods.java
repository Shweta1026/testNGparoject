package abc;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependsOnMethods {
	@Test(groups={"smoke","regression"}) 
	public void test1() {
		System.out.println("test1");
	}
	
	@Test (groups={"sanity","regression"})
	public void test2() {
		System.out.println("test2");
	}
	
	@Test (groups={"regression"})
	public void test3() {
		System.out.println("test3");
	}
	
	
	@Test (groups={"sanity"})
	public void test4() {
		System.out.println("test4");
	}
	
	@Test  
	public void test5() {
		System.out.println("test5");
	}
	

}