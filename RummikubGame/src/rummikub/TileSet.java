package rummikub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileSet {
	private List<Tile> sets;
	
	public TileSet() {
		sets = new ArrayList<>();
	}
	
	public void addToSet(Tile tile) {
		sets.add(tile);
	}
	
	public void removeFromSet(Tile tile) {
		sets.remove(tile);
	}
	
	public List<Tile> getSets() {
		return sets;
	}
	
	@Override
	public String toString() {
		String output = "";
		for (Tile t : sets) {
			output += t + " ";
		}
		if (output == "") {
			return "No Tile.";
		}
		return output;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (TileSet) super.clone();
	}
	
	public void sortByNumber() {
		Collections.sort(sets);
	}
	
	public void sortByColor() {
		Collections.sort(sets);
		Collections.sort(sets, Tile.TileColorComparator);
	}
	
	
	//check each tile color sort by color->check color same?-> check difference by 1? 123
	private boolean checkRun() {
		
		
		return true;
	}
	
	
	private boolean checkGroup() {
		sortByNumber();
		int tileValue = 0;
		List<Color> colors = new ArrayList<>();
		boolean sameValue = true;
		boolean differentColor = true;
		
		for(Tile t: sets){
			if(tileValue == 0) {
				tileValue = t.getValue();
			}
			
			if(t.getValue()!=tileValue){
				sameValue = false;
				break;
			}
			
			if(!colors.contains(t.getColor()))
				colors.add(t.getColor());
			
		}
		
		if(colors.size()<3)
			differentColor = false;
		
		return sameValue && differentColor;
	}
	
	public boolean checkIfTileSetAvailable() {
		boolean run = checkRun();
		boolean group = checkGroup();
		if (run && group)
			return false;
		else if (run)
			return true;
		else if (group)
			return true;
		else
			return false;
	}
}
