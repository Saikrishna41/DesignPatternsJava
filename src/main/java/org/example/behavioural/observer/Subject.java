package org.example.behavioural.observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

interface Observer {
    void update(String avail);
}
