/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.hopcroft.vaadin;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */

@SuppressWarnings("serial")
public class CarApplication extends Application {
	private VerticalLayout layout = new VerticalLayout();
	private Window window;
	private Table table;
	private List<Car> carList;
	private CarForm carForm;

	@Override
	public void init() {
		window = new Window("My Vaadin Application");
		setMainWindow(window);
		table = new Table("Lista de coches");
		displayTable(getCarList());
//		carForm = new CarForm(this);
//		carForm.setFormFieldFactory(new MyFieldFactory());
//		setMainWindow(window);
//		Button button = new Button("Click Me");
//		button.addListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//				window.addComponent(new Label("Thank you for clicking"));
//			}
//		});
//		loadCarList();
//		window.addComponent(button);

	}

	private void displayTable(List<Car> carList2) {
		table.setSelectable(true);
		table.setWriteThrough(false);
		table.setPageLength(carList2.size());
		BeanItemContainer<Car> container = new BeanItemContainer<Car>(Car.class,carList2);
		table.setContainerDataSource(container);
		table.addListener(new Property.ValueChangeListener() {
		    public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
		        new Label().setValue("Selected: " + table.getValue());
		    }
		});
		window.addComponent(table);
		window.addComponent(new Button("abrir",new Button.ClickListener(){
			public void buttonClick(ClickEvent event) {
				if (table.getValue() != null) {
					Car car = (Car) table.getValue();
					displayForm(car);
				}
				else {
					getMainWindow().showNotification("Selecciona un coche primero");
				}
			}
		}));
	}


	private List<Car> getCarList() {
		Car car1 = new Car();
		car1.setBrand("Ferrari");
		car1.setModel("f430");
		car1.setPrice(245000);

		Car car2 = new Car();
		car2.setBrand("Porsche");
		car2.setModel("911");
		car2.setPrice(100000);

		Car car3 = new Car();
		car3.setBrand("Mercedes");
		car3.setModel("SLK");
		car3.setPrice(50000);

		carList = new ArrayList<Car>();
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		return carList;
	}

	private void displayForm(Car car) {
		layout.removeAllComponents();
    	//tendremos que coger el Bean seleccionado en el onclick de la tabla.
        BeanItem<Car> beanCar = new BeanItem<Car>(car);
        carForm = new CarForm(this);
        carForm.setItemDataSource(beanCar);
        layout.addComponent(carForm);
        window.addComponent(layout);
    }
	

}
