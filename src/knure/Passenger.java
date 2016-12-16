package knure;

import java.util.Comparator;

public class Passenger extends Auto {
	int numSeat;
	int safetyClass;
	public void isSafe(){
		if(safetyClass < 8){
			System.out.println("Car is not safety! Be carefull!");
		}
		else{
			System.out.println("Car is safety! You have good car.");
		}
	}
	Passenger(){
		name = null;
		weight = 0.0;
		price = 0.0;
		color = null;
		type = null;
		power = 0;
		numGears = 0;
		numSeat = 0;
		safetyClass = 0;
	}
	Passenger(String name, double weight,double price, String color, String type, int power, int numGears, int numSeat, int safetyClass){
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.color = color;
		this.type = type;
		this.power = power;
		this.numGears = numGears;
		this.numSeat = numSeat;
		this.safetyClass = safetyClass;
	}
	Passenger(String name, String type, double price, String color, int power, int safetyClass) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.color = color;
		this.power = power;
		this.safetyClass = safetyClass;
	}
	
	public Object[] toArray() {
		Object t[] = new Object[9];
		t[0] = getName();
		t[1] = getType();
		t[2] = getColor();
		t[3] = getPrice();
		t[4] = getPower();
		t[5] = getWeight();
		t[6] = getNumGears();
		t[7] = getSafetyClass();
		t[8] = getNumSeat();
		return t;
	}
	
	public String toString(){
		return "Название: " + name + '\n' + 
				"Тип: " + type + '\n' +
				"Цвет: " + color + '\n' + 
				"Стоимость: " + price + "$" + '\n' + 
				"Мощность: " + power + "лс" + '\n' + 
				"Вес: " + weight + "кг" + '\n' + 
				"Количество сидений: " + numSeat + '\n' + 
				"Класс безопасности: " + safetyClass + '\n' +
				"Клолчество передач: " + numGears + '\n';
	}
	public int compareTo(Passenger p) {
		return this.power - p.power;
	}

	public int getNumSeat(){
		return numSeat;
	}
	public void setNumSeat(int numSeat){
		this.numSeat = numSeat;
	}
	
	public int getSafetyClass(){
		return safetyClass;
	}
	public void setSafetyClass(int safetyClass){
		this.safetyClass = safetyClass;
	}
	
	public boolean equals (Passenger p){
		if(	this.name == p.name &&
		this.weight == p.weight &&
		this.price == p.price &&
		this.color == p.color &&
		this.type == p.type &&
		this.power == p.power &&
		this.numGears == p.numGears &&
		this.numSeat == p.numSeat &&
		this.safetyClass == p.safetyClass) return true;
		return false;
	}
}


class SortBySafetyClass implements Comparator <Passenger> {
	public int compare(Passenger p1, Passenger p2) {
		int res = 0;
		if(p1.safetyClass > p2.safetyClass) res = 1;
		if(p1.safetyClass > p2.safetyClass) res = -1;
		return res;
	}
}
