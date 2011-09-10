package com.hopcroft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hopcroft.domain.Car;
import com.hopcroft.services.CarService;

public class CarFormController extends SimpleFormController {

	public CarFormController() {
		setCommandClass(Car.class);
		setCommandName("carInsert");
	}
	
//	@Autowired
	private CarService carService;

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		super.initBinder(request, binder);
	}
	
	@Override
	protected void doSubmitAction(Object command) throws Exception {
		Car car = (Car) command;
		carService.insertCar(car);	
	}

}
