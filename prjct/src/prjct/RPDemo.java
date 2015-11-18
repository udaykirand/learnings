package prjct;


class Vehicle {
	public void drive() {
		System.out.println("Vehicle");
	}
}

class Car extends Vehicle {
	public void drive() {
		System.out.println("Car");
	}
}

class Truck extends Vehicle {
	public void drive() {
		System.out.println("truck");
	}
	
	public void load() {
		System.out.println("Loading");
	}
}

public class RPDemo {

	public static void main(String[] args) {
		 Vehicle car = new Car();
		 car.drive();
		 Vehicle truck = new Truck();
		 truck.drive();
		 //truck.load();
		 Truck truc = new Truck();
		 truc.load();
		 System.out.println(Math.floor(-0.000000000001));
		 System.out.println(Math.floor(-10.8d));
		 System.out.println(Math.floor(10000000000000001L));
		 
	}

}
