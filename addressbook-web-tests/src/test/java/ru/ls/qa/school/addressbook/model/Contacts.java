package ru.ls.qa.school.addressbook.model;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.ForwardingSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contacts extends ForwardingList<ContactData> {

    private List<ContactData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new ArrayList<>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new ArrayList<>();
    }

    @Override
    protected List<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

    public Contacts withChange(ContactData without, ContactData withAdd) {
        Contacts contacts = new Contacts(this);
        contacts.remove(without);
        contacts.add(withAdd);
        return contacts;
    }
}