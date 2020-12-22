package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler implements IDataHandler {
    private Scanner input;

    @Override
    public void open(String path) {
        File file = new File(path);
        try {
            this.input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        this.input.close();
    }

    @Override
    public String getCurrencyName() {
        return this.input.next();
    }

    @Override
    public double getQuantity() {
        return this.input.nextDouble();
    }

    @Override
    public boolean hasData() {
        return this.input.hasNext();
    }
}
