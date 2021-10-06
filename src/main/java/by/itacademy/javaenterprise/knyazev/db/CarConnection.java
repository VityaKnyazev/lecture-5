package by.itacademy.javaenterprise.knyazev.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.itacademy.javaenterprise.knyazev.entities.Car;

public class CarConnection implements IConnection<Car> {
	private final static Car DEFAULT_CAR = new Car("lada", "3", 12556255L);
	public final static int DEFAULT_CAR_ID = 0;
	private List<Car> cars;

	public CarConnection() {
		createCarList();
	}

	@Override
	public Car getSingle(int id) {
		return cars.get(id);
	}

	@Override
	public List<Car> getAll() {
		return cars;
	}

	@Override
	public void addSingle(Car car) {
		if (cars.contains(car)) {
			int index = cars.indexOf(car);
			cars.add(index, car);
		} else {
			cars.add(car);
		}
	}

	private void createCarList() {
		this.cars = new ArrayList<Car>();

		Car lada = new Car("lada", "vesta", 0L);
		Car opel = new Car("opel", "omega", 25L);
		Car mazda = new Car("mazda", "3", 268L);
		Car skoda = new Car("skoda", "rapid", 12L);
		
		Car[] cars = { DEFAULT_CAR, lada, opel, mazda, skoda };

		Collections.addAll(this.cars, cars);
	}

	@Override
	public String connect() {
		// TODO some connection to DB
		return "Connection succeed!";
	}

}
