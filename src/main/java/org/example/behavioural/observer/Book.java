package org.example.behavioural.observer;

import java.util.ArrayList;
import java.util.List;



public class Book implements Subject {
    private String bookName;
    private String author;

    private String genre;

    private String price;

    private String available;


    private List<Observer> obsList = new ArrayList<>();

    public Book(String bookName, String author, String genre, String price, String available) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.available = available;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
    public String getAvailable() {
        return available;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public List<Observer> getObsList() {
        return obsList;
    }

    public void setObsList(List<Observer> obsList) {
        this.obsList = obsList;
    }

    @Override
    public void registerObserver(Observer observer) {
        obsList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        obsList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        System.out.println("Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price='" + price + '\'' +
                ", is now ='" + available + '\'' +
                '}');

        for (Observer o : obsList) {
            o.update(this.available);
        }
    }
}
