package buyCar;

public class Direcrtor {

	public static void main(String[] args) {

		carFactory carFactory = new carFactory();
		carFactory.getCarType("Honda");
		carFactory.getCarType("Toyota");
	}

}
