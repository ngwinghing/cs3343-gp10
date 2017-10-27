package rummikub;

public class Tiles {

	
	private int value;
	private Color color;
	
	
	public Tiles(int value, Color color){
		this.value = value;
		this.color = color;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public String toString(){
		return color.toString()+value;
	}
	
	
}
