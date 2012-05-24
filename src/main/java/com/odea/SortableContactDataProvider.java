package com.odea;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SortableContactDataProvider extends SortableDataProvider<Contact> {
    List<Contact> contacts = new ArrayList<Contact>();
    private ISortState contactsSortState;

    public SortableContactDataProvider() {
        for(int i=0;i<100;i++){
            this.contacts.add(new Contact(i,i+"nombre",i+"apellido"));
            setSort("firstName", SortOrder.ASCENDING);
        }
    }

    public Iterator<? extends Contact> iterator(int first, int count) {
        return this.contacts.subList(first,first + count).iterator();
    }

    public int size() {
        return contacts.size();
    }

    public IModel<Contact> model(Contact contact) {
        return new ContactModel(contact);
    }

}
