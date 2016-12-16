package knure;

public class Transport implements Comparable <Transport> {
	protected String name;
	protected double weight;
	protected double price;
	protected String color;
	protected String type;
	protected int power;
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public double getWeight(){
		return weight;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color = color;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}

	public int getPower(){
		return power;
	}
	public void setPower(int power){
		this.power = power;
	}

	public Object[] toArray() {
		Object t[] = new Object[6];
		t[0] = getName();
		t[1] = getType();
		t[2] = getColor();
		t[3] = getPrice();
		t[4] = getPower();
		t[5] = getWeight();
		return t;
	}
	
	public int compareTo(Transport t) {
		int res = 0;
		if(this.price > t.price) res = 1;
		if(this.price < t.price) res = -1;
		return res;
	}
	
	public boolean equals (Transport t){
		if(	this.name == t.name &&
		this.weight == t.weight &&
		this.price == t.price &&
		this.color == t.color &&
		this.type == t.type &&
		this.power == t.power) return true;
		return false;
	}
}