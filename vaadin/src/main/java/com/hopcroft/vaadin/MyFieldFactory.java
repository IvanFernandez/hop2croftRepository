package com.hopcroft.vaadin;

import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class MyFieldFactory implements FormFieldFactory {
    public Field createField(Item item, Object propertyId,
                             Component uiContext) {
        // Identify the fields by their Property ID.
        String pid = (String) propertyId;
        if ("name".equals(pid)) {
            return new TextField("Name");
        } else if ("city".equals(pid)) {
            Select select = new Select("City");
            select.addItem("Berlin");
            select.addItem("Helsinki");
            select.addItem("London");
            select.addItem("New York");
            select.addItem("Turku");
            select.setNewItemsAllowed(true);
            return select;
        }
        
        return null; // Invalid field (property) name.
    }
}
