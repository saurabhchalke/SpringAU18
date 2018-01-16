package templatePattern;

public class Resident {
	
	public static void main(String[] args) {
		
		HomeDesigner residentA = new ApartmentHouse();
		residentA.getDesign();
		
		HomeDesigner residentV = new VillaHouse();
		residentV.getDesign();
		
	}
	
}
