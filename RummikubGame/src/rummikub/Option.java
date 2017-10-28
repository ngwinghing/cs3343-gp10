package rummikub;

public enum Option {
	Draw, 
	Play, 
	SortByNumber,
	SortByColor;
	
	@Override
	public String toString(){
		switch(this){
			case Draw	: return "Draw a tile";
			case Play	: return "Play set(s)";
			case SortByNumber	: return "Sort By Number";
			case SortByColor	: return "Sort By Color";
			default: return "No such option.";
		}
	}
	
	
}