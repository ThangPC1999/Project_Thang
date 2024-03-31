package buyCar;

public class carFactory {

	public void getCarType (String carTypeName) {
		Car car;
		if(carTypeName.equalsIgnoreCase("Honda")) {
			car = new Honda();
			car.viewCar();
			car.driveCar();
			car.banhxe();
			car.getColorCar();
		} else if (carTypeName.equalsIgnoreCase("Toyota")) {
			car = new Toyota();
			car.viewCar();
			car.driveCar();
			car.banhxe();
			car.getColorCar();
		} else if (carTypeName.equalsIgnoreCase("Yamaha")) {
			car = new Yamaha();
			car.viewCar();
			car.driveCar();
			car.banhxe();
			car.getColorCar();
		}
	}
}
