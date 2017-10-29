package rummikub;

import java.util.ArrayList;
import java.util.LinkedList;

public class Rack {

	public LinkedList<Tiles> rack;

	public Rack() {
		rack = new LinkedList<Tiles>();
	}
	
	public void addTile(Tiles t) {
		rack.add(t);
	}
	
	private Tiles getTile(int index){
		return rack.get(index);
	}
	
	public setRack(LinkedList<Tiles> newRack){
		this.rack = newRack;
	}
	
	
	public void sortByColour(){
		ArrayList<Rack> colorTiles = this.separateByColour();;
		LinkedList<Tiles> rack = new LinkedList<Tiles>;
		
		for(int i = 0; i < 5; i++){
			colorTiles.get(i).sortByNumber();
			//not sure
			rack.addAll(colorTiles.get(i));
		}

		this.setRack(rack);
	}
	
	
	public void sortRackByNumber(){	
        Collections.sort(rack,
        new Comparator<Tiles>() {
            public int compare(Tiles t1, Tiles t2) {
                return t1.getValue()-t2.getValue();
            }
        });
	}
	
	
	
	
	//seperate rack by color
	public ArrayList<Rack> seperateRackByColor() {


		ArrayList<Rack> colorTiles = new ArrayList<Rack>();
		Tiles currentTile;
		
		for(int i = 0; i < 5; i++)
			colorTiles.add(new Rack());

		for(int i = 0; i < rack.size(); i++){
			currentTile = this.getTile(i);
			
			switch (currentTile.getColor()){
				case(Color.Black):
					colorTiles.get(0).addTile(currentTile);
					break;
				case(Color.Blue):
					colorTiles.get(1).addTile(currentTile);
					break;
				case(Color.Red):
					colorTiles.get(2).addTile(currentTile);
					break;
				case(Color.Yellow):
					colorTiles.get(3).addTile(currentTile);
					break;
				case(Color.Joker):
					colorTiles.get(4).addTile(currentTile);
					break;
			}

		return colorTiles;
	}
	
		

	
		
	


	@Override
	public String toString() {
		String output = "";
		int i = 1;
		for (Tiles t : rack) {
			output += i + ". \t";
			output += t + " \n";
			i++;
		}
		return output;
	}

	public boolean isEmpty() {
		if (rack.isEmpty()) {
			return true;
		}
		return false;
	}
}
