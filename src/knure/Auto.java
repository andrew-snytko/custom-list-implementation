package knure;

public class Auto extends Transport {

	protected int numGears;

	public int getNumGears(){
		return numGears;
	}
	public void setNumGears(int numGears){
		this.numGears = numGears;
	}

	
	public boolean equals (Auto a){
		if(	this.name == a.name &&
		this.weight == a.weight &&
		this.price == a.price &&
		this.color == a.color &&
		this.type == a.type &&
		this.power == a.power) return true;
		return false;
	}
	
}

