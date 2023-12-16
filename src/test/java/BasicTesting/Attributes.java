package BasicTesting;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
@Ignore
public class Attributes {
@Test(description="log in method",priority=2,enabled=false)
public void test1() {
	System.out.println("test1");
}

@Test(description="xyz",priority=1,timeOut=2000)
public void test2() throws InterruptedException {
	Thread.sleep(3000);
	System.out.println("test2");
}

@Test(description="pqr",priority=3,invocationCount=3,invocationTimeOut=2000)
public void test3() throws InterruptedException {
	Thread.sleep(3000);
	System.out.println("test3");
}
@Ignore
@Test(description="stg")
public void test4() {
	System.out.println("test4");
}

@Test(description="stg")
public void test5() {
	System.out.println("test5");
}

@Test(description="stg")
public void test6() {
	System.out.println("test6");
}
}
