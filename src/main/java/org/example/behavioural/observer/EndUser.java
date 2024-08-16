package org.example.behavioural.observer;

public class EndUser implements Observer {
    private String name;

    public String getName() {
        return name;
    }

    public EndUser(Subject subject, String name) {
        this.name = name;
        subject.registerObserver(this);
    }
    @Override
    public void update(String avail) {
        System.out.println("your book is "+avail);
    }


}
