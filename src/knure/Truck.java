package knure;
import java.util.Comparator;

public class Truck extends Auto {
	double maxCapacity;
	int numWeels;
	boolean haveTrailer;
	public void isBigTrack(){
		if(maxCapacity > 100000.0){
			System.out.println("It is a big track! You have road monster! You can transport very big objects!");
		}
		if(maxCapacity < 1000.0){
			System.out.println("You cheated! It is not a track! Just buy track!");
		}
		if(maxCapacity > 1000.0 && maxCapacity < 100000.0){
			System.out.println("You have normal track.");
		}
	}
	Truck(){
		name = null;
		weight = 0.0;
		price = 0.0;
		color = null;
		type = null;
		power = 0;
		numGears = 0;
		maxCapacity = 0.0;
		numWeels = 0;
		haveTrailer = false;
	}
	Truck(String name, double weight, double price, String color, String type, int power, int numGears, double maxCapacity, int numWeels, boolean haveTrailer){
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.color = color;
		this.type = type;
		this.power = power;
		this.numGears = numGears;
		this.maxCapacity = maxCapacity;
		this.numWeels = numWeels;
		this.haveTrailer = haveTrailer;
	}
	Truck(String name, String type, double price, String color, int power, double maxCapacity, int numWeels) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.color = color;
		this.power = power;
		this.maxCapacity = maxCapacity;
		this.numWeels = numWeels;
	}
	Truck(String name, String type, String color) {
		this.name = name;
		this.type = type;
		this.color = color;
	}
	public String toString(){
		String s;
		if(haveTrailer) s = "Да";
		else s = "Нет";
		return "Название: " + name + '\n' + 
				"Тип: " + type + '\n' +
				"Цвет: " + color + '\n' + 
				"Стоимость: " + price + "$" + '\n' + 
				"Мощность: " + power + "лс" + '\n' + 
				"Вес: " + weight + "кг" + '\n' + 
				"Грузоподъемность: " + maxCapacity + "кг" + '\n' + 
				"Количество осей: " + numWeels/2 + '\n' +
				"Клолчество передач: " + numGears + '\n' + 
				"Наличие прицепа: " + s + '\n';
				
	}

	public Object[] toArray() {
		Object t[] = new Object[10];
		t[0] = getName();
		t[1] = getType();
		t[2] = getColor();
		t[3] = getPrice();
		t[4] = getPower();
		t[5] = getWeight();
		t[6] = getNumGears();
		t[7] = getMaxCapacity();
		t[8] = getNumWeels();
		t[9] = checkOnHaveTrailer();
		return t;
	}
	
	public double getMaxCapacity(){
		return maxCapacity;
	}
	public void setMaxCapacity(double maxCapacity){
		this.maxCapacity = maxCapacity;
	}

	public int getNumWeels(){
		return numWeels;
	}
	public void setNumWeels(int numWeels){
		this.numWeels = numWeels;
	}
	
	public boolean checkOnHaveTrailer(){
		return haveTrailer;
	}
	public void setHaveTrailer(boolean haveTrailer){
		this.haveTrailer = haveTrailer;
	}
	
	public int compareTo(Truck t) {
		int res = 0;
		if(this.price > t.price) res = 1;
		if(this.price < t.price) res = -1;
		return res;
	}
	
	public boolean equals (Truck t){
		if(	this.name == t.name &&
		this.weight == t.weight &&
		this.price == t.price &&
		this.color == t.color &&
		this.type == t.type &&
		this.power == t.power &&
		this.numGears == t.numGears &&
		this.maxCapacity == t.maxCapacity &&
		this.numWeels == t.numWeels &&
		this.haveTrailer == t.haveTrailer) return true;
		return false;
	}

}

class SortByNumWeels implements Comparator <Truck> {
	public int compare(Truck t1, Truck t2) {
		int res = 0;
		if(t1.numWeels > t2.numWeels) res = 1;
		if(t1.numWeels < t2.numWeels) res = -1;
		return res;
	}
}

class SortByColorAndType implements Comparator <Truck> {
	public int compare(Truck t1, Truck t2) {
		if(t1.color.compareTo(t2.color) == 0){
			return t1.type.compareTo(t2.type);
		}
		return t1.color.compareTo(t2.color);
	}
}