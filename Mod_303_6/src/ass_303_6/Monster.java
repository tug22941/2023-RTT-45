package ass_303_6;

public class Monster {

	String name;
	
	public Monster() {}
	public Monster(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String attack() {
		return name + " used: no moves available";
	}
	
	
}
