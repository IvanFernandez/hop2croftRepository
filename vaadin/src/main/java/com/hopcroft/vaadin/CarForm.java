package com.hopcroft.vaadin;

import java.util.Collection;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;

@SuppressWarnings("serial")
public class CarForm extends Form implements ClickListener {

	private final IndexedContainer tableContainer = new IndexedContainer();
	
	private Button save = new Button("Save", (ClickListener) this);
	private Button cancel = new Button("Cancel", (ClickListener) this);
	private Button edit = new Button("Edit", (ClickListener) this);
	private CarApplication carApplication;

	public CarForm(CarApplication carApplication) {
		this.carApplication = carApplication;
        setWriteThrough(false);
        
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(save);
        footer.addComponent(cancel);
        footer.addComponent(edit);
        footer.setVisible(true);
        setFooter(footer);
	}
	
	private void getTableContainer() {
		tableContainer.addContainerProperty("Id", Long.class, 0);
		tableContainer.addContainerProperty("Nombre", String.class, "");
		tableContainer.addContainerProperty("Descripcion", String.class, "");
		// FIXME
		// ver como asociar un checkbox al container.
		tableContainer.addContainerProperty("Opcional", Boolean.class, false);
	}

	public void buttonClick(ClickEvent event) {
		 Button source = event.getButton();
	        if (source == save) {
	             if (!isValid()) {
	                 return;
	             }
	             commit();
	             setReadOnly(true);
	         } else if (source == cancel) {
	             discard();
	             setReadOnly(true);
	         } else if (source == edit) {
	             setReadOnly(false);
	         }
	}




}
