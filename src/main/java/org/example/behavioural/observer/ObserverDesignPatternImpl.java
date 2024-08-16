package org.example.behavioural.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObserverDesignPatternImpl {
    public static void main(String[] args) {
        Book b1 = new Book("goosebumps", "rlsteine", "horror", "12.99", "outofstock");
        EndUser user = new EndUser(b1, "Sai");
        List<Observer> observerList = b1.getObsList();
        observerList.add(user);
        Iterator<Observer> iterator = observerList.iterator();
        while (iterator.hasNext()) {
            EndUser eu = (EndUser) iterator.next();
            System.out.println(eu.getName()+" has subscribed for "+b1.getBookName()+" Book");
            eu.update(b1.getAvailable());
            System.out.println("book is now available");
            b1.setAvailable("backinstock");
        }
    }
}
