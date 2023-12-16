package testNGpractice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependsOnMethods {
	String trackNum=null;
	@Ignore
	@Test(priority=2)
	public void createShipment() {
		System.out.println("create shipment");
		trackNum="abc234";
	}
	
	
	@Test(priority=1,dependsOnMethods= {"createShipment"},ignoreMissingDependencies=true)
	public void trackShipment() {
		
		if(trackNum!=null) {
			System.out.println("track shipment");
		}
		else {
			System.out.println("shipment failed");
		}
	}
	
	@Test(priority=3,dependsOnMethods= {"createShipment","trackShipment"},ignoreMissingDependencies=true)
	public void deleteShipment() {
		if(trackNum!=null) {
			System.out.println("delete shipment");
		}
		else {
			System.out.println("shipment failed");
		}
		
	}

}
