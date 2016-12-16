package knure;

import java.util.Comparator;

public class Ship  extends Transport {
	double displacement; //водоизмещение
	String typeEngine;
	double capacity;
	public void isItGoDown(double cargo){    // cargo - вес груза
		if(cargo > capacity){
			System.out.println("Your ship is going down!. I am sorry.");
		}
		if(cargo < capacity){
			System.out.println("It is OK. Your ship is not going down");
		}
	}
 	Ship(){
 		name = null;
		weight = 0.0;
		price = 0.0;
		color = null;
		type = null;
		power = 0;
		displacement = 0;
		typeEngine = null;
		capacity = 0.0;
	}
 	Ship(String name, double weight, double price, String color, String type, int power, double displacement, String typeEngine, double capacity){
 		this.name = name;
 		this.weight = weight;
		this.price = price;
		this.color = color;
		this.type = type;
		this.power = power;
		this.displacement = displacement;
		this.typeEngine = typeEngine;
		this.capacity = capacity;
 	}
 	Ship(String name, String type, double price, String color, double capacity) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.color = color;
		this.capacity = capacity;
	}
 	
	public Object[] toArray() {
		Object t[] = new Object[9];
		t[0] = getName();
		t[1] = getType();
		t[2] = getColor();
		t[3] = getPrice();
		t[4] = getPower();
		t[5] = getWeight();
		t[6] = getDisplacement();
		t[7] = getCapacity();
		t[8] = getTypeEngine();
		return t;
	}
 	
 	public String toString(){
 		return "Название: " + name + '\n' + 
				"Тип: " + type + '\n' +
				"Цвет: " + color + '\n' + 
				"Стоимость: " + price + "$" + '\n' + 
				"Мощность: " + power + "лс" + '\n' + 
				"Вес: " + weight + "кг" + '\n' + 
				"Водоизмащение: " + displacement + "кг" + '\n' + 
				"Грузоподъемность: " + capacity + '\n' +
				"Тип двигателя: " + typeEngine + '\n';
 	}
	public int compareTo(Ship s) {
		int res = 0;
		if(this.capacity - s.capacity > 0) res = 1;
		if(this.capacity - s.capacity < 0) res = -1;
		return res;
	}

	public double getDisplacement(){
		return displacement;
	}
	public void setDisplacement(double displacement){
		this.displacement = displacement;
	}
	
	public String getTypeEngine(){
		return typeEngine;
	}
	public void setTypeEngine(String typeEngine){
		this.typeEngine = typeEngine;
	}
	
	public double getCapacity(){
		return capacity;
	}
	public void setCapacity(double capacity){
		this.capacity = capacity;
	}
	
	public boolean equals (Ship s){
		if(	this.name == s.name &&
		this.weight == s.weight &&
		this.price == s.price &&
		this.color == s.color &&
		this.type == s.type &&
		this.power == s.power &&
		this.displacement == s.displacement &&
		this.typeEngine == s.typeEngine &&
		this.capacity == s.capacity) return true;
		return false;
	}

}

class SortByCapacity implements Comparator <Ship> {
	public int compare(Ship s1, Ship s2) {
		int res = 0;
		if(s1.capacity > s2.capacity) res = 1;
		if(s1.capacity < s2.capacity) res = -1;
		return res;
	}
}
