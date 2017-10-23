package rummikub;

public enum Color {
	Black, 
	Blue, 
	Red,
	Yellow,
	Joker;
	
	@Override
	public String toString(){
		switch(this){
			case Black	: return "Blk";
			case Blue	: return "Blu";
			case Red	: return "Red";
			case Yellow	: return "Yel";
			default		: return "Jok";
		}
	}
}
