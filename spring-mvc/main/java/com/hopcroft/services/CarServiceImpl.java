package com.hopcroft.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.hopcroft.domain.Car;
import com.hopcroft.exception.CarException;

public class CarServiceImpl implements CarService {
	public CarServiceImpl() {
	}

	public List<Car> getCars() throws CarException {
		List<Car> cars = initCars();
		if ((Calendar.getInstance().getTimeInMillis() % 2) == 0) {
			return cars;
		} else if ((Calendar.getInstance().getTimeInMillis() % 2) == 0) {
			throw new CarException(1L, "Car service ", new Date());
		} else
			throw new RuntimeException();
	}
	
	public long insertCar(Car car) throws CarException {
		// TODO Auto-generated method stub
		return 0;
	}

	// TODO: llamar al DAO de car.
	private List<Car> initCars() {
		List<Car> carList = new ArrayList<Car>();
		Car car = new Car();
		car.setBrand("Ferrari");
		car.setName("F40");
		car.setPrice(1000000L);

		Car car2 = new Car();
		car2.setBrand("Porsche");
		car2.setName("Carrera");
		car2.setPrice(200000L);

		Car car3 = new Car();
		car3.setBrand("Opel");
		car3.setName("Astra");
		car3.setPrice(18000L);

		carList.add(car);
		carList.add(car2);
		carList.add(car3);

		return carList;
	}
}
