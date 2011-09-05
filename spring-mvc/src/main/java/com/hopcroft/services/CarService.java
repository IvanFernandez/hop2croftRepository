package com.hopcroft.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hopcroft.domain.Car;
import com.hopcroft.exception.CarException;

@Service
public interface CarService {
	public List<Car> getCars() throws CarException;
	public long insertCar(Car car) throws CarException;
}
