package com.hopcroft.vaadin;

import javax.xml.datatype.XMLGregorianCalendar;

public class Car {
	private String brand;
	private String model;
	private long price;
	private XMLGregorianCalendar year;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public XMLGregorianCalendar getYear() {
		return year;
	}
	public void setYear(XMLGregorianCalendar year) {
		this.year = year;
	}

}
