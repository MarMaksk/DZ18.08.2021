package com.DZ.company.Thread;

import com.DZ.company.Warehouse;
import com.DZ.company.Waybill;

import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ThreadOutputInputWaybillList implements Runnable {
    private Warehouse warehouse;
    private boolean output = true;
    private File file;
    private static final Semaphore SEMAPHORE = new Semaphore(1, true);

    public ThreadOutputInputWaybillList(Warehouse warehouse, boolean output) {
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
            File file2 = new File("warehouse" + warehouse.getAdress() + " waybill list" + ".dat");
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2))) {
                file2.createNewFile();
                oos.writeObject(warehouse.getWaybillList());

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
            File file2 = new File("warehouse" + warehouse.getAdress() + " waybill list" + ".dat");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2))) {
                LinkedList<Waybill> pt1 = (LinkedList<Waybill>) ois.readObject();
                pt1.forEach(System.out::println);
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
