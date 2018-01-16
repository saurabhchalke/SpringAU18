package templatePattern;

public abstract class HomeDesigner {
	
	public abstract void designStructure();
	public abstract void designWalls();
	public abstract void designDoors();
	public abstract void designWindows();
	public abstract void designFurnishing();
	
	public void getDesign() {
		designStructure();
		designWalls();
		designDoors();
		designWindows();
		designFurnishing();
	}
	
	void getDesigner() {
		System.out.println("Designer of the houses");
	}
	
}
