package org.example.structural.proxy;

/**
 * The Proxy Pattern in Java is a structural design pattern that provides an object
 * representing another object. It is used to control access to the actual object and can
 * be used for various purposes such as lazy initialization, access control, logging, etc.
 * Here is a simple example of the Proxy Pattern in Java:
 */
public interface Subject {
    void request();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("Real subject : Handling request");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;
    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        System.out.println("Proxy: Logging request");
        realSubject.request();
    }
}
