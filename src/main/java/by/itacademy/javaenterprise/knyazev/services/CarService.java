package by.itacademy.javaenterprise.knyazev.services;

import java.util.List;

import by.itacademy.javaenterprise.knyazev.db.CarConnection;
import by.itacademy.javaenterprise.knyazev.db.IConnection;
import by.itacademy.javaenterprise.knyazev.entities.Car;

public class CarService implements IService<Car, List<Car>>{
	private final IConnection<Car> carConnection;
	
	public CarService() {
		carConnection = new CarConnection();
	}
	

	@Override
	public List<Car> getAllData() {
		return carConnection.getAll();
	}

	@Override
	public Car getSingleData(int id) {
		return carConnection.getSingle(id);
	}
	
	@Override
	public void addData(Car car) {
		carConnection.addSingle(car);
	}
	
	public Car createCar(String firm, String model, long serialNumber) {
		Car car = new Car(firm, model, serialNumber);
		return car;
	}

}
