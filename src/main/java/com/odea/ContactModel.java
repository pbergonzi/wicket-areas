package com.odea;

import org.apache.wicket.model.IModel;

public class ContactModel implements IModel<Contact> {
    Contact contact;

    public ContactModel(Contact contact) {
        this.contact = contact;
    }

    public Contact getObject() {
        return this.contact;
    }

    public void setObject(Contact contact) {
        this.contact = contact;
    }

    public void detach() {
        this.contact = null;
    }
}
