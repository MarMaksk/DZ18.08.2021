package com.company.Thread;

import com.company.Production.Product;
import com.company.Warehouse;

import java.io.*;
import java.util.ArrayList;

public class ThreadOutputInputProductList implements Runnable {
    private volatile Warehouse warehouse;
    private volatile boolean output;
    private volatile File file;


    public ThreadOutputInputProductList(Warehouse warehouse, boolean output) {
        this.warehouse = warehouse;
        this.output = output;
        this.file = new File("warehouse " + warehouse.getAdress() + " product list" + ".dat");
    }

    @Override
    public void run() {
        if (output == true) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                file.createNewFile();
                oos.writeObject(warehouse.getProductsList());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                ArrayList<Product> pt = (ArrayList<Product>) ois.readObject();
                pt.forEach(System.out::println);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

