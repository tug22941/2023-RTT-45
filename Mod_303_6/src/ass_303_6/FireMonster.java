package ass_303_6;

public class FireMonster extends Monster{

	public FireMonster(String name) {this.name = name;}
	
	@Override
	public String attack() {
		return name + " used: Fireball";
	}
}
