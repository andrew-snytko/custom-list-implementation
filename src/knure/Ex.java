package knure;


public class Ex {

	public static void main(String[] args) {
		Transport t[] = new Transport[9];
		t[0] = new Truck("Man", "самосвал", 50000.0, "black", 320, 10000, 8);
		t[1] = new Truck("Scania", "т€гач", 60000.0, "white", 540, 40000, 12);
		t[2] = new Truck("Daf", "самосвал", 30000.0, "white", 380, 5000, 6);
		t[3] = new Passenger("Audi", "купе", 40000, "зелЄный", 250, 9);
		t[4] = new Passenger("BMW", "седан", 55000, "синий", 380, 7);
		t[5] = new Passenger("Chevrolet", "джип", 30000, "красный", 250, 8);
		t[6] = new Ship("LBG", "танкер", 4000000, "чЄрный", 50000000);
		t[7] = new Ship("BING", "круизный лайнер", 5500000, "синий", 380000);
		t[8] = new Ship("DFRY", "прогулочный катер", 300000, "красный", 10000);
		
		System.out.println(t[0].getClass().toString());
		
		MyListImpl list = new MyListImpl();
		list.add(t[0]);
		list.add(t[1]);
		list.add(t[2]);
		list.add(t[3]);
		list.add(t[4]);
		
		list.addByIndex(t[8], 5);

		System.out.println(list);
		System.out.println(list.getSize());

	}

}
