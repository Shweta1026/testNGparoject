
public class DataProvider {
	
	@DataProvider(name="datasupplier1")
	public Object[][] logInDataSupplier(){
		Object[][] data=new Object[][] {
			{"Admin","admin123"},{"Test","admin123"},{"Admin","test123"},{"test","test123"}
		}
		return data;
	}

}
