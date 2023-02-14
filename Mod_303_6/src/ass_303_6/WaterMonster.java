package ass_303_6;

public class WaterMonster extends Monster {
	
	public WaterMonster(String name) {this.name = name;}
	
	@Override
	public String attack() {
		if(name.equals("Levadon")) {
			return name + " used: Tidal Wave";
		}else {return name + " used: Tsunami";}
	}
	
}
