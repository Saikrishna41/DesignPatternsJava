package org.example.structural.proxy;

public class ProxyPatternImpl {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.request();
    }
}
