package org.example;

public interface IDataHandler {
    void open(String path);
    void close();
    String getCurrencyName();
    double readQuantity();
    boolean hasData();
}
