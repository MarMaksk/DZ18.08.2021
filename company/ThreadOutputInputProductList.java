package com.DZ.company.Thread;

import com.DZ.company.Production.Product;
import com.DZ.company.Warehouse;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ThreadOutputInputProductList implements Runnable {
    private Warehouse warehouse;
    private boolean output = true;
    private File file;
    private static final Semaphore SEMAPHORE = new Semaphore(1, true);


    public ThreadOutputInputProductList(Warehouse warehouse, boolean output) {
        this.warehouse = warehouse;
        this.output = output;
        this.file = new File("warehouse " + warehouse.getAdress() + " product list" + ".dat");
    }

    @Override
    public void run() {
        try {
            SEMAPHORE.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        SEMAPHORE.release();
    }
}

