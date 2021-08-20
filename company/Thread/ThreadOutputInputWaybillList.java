package com.company.Thread;

import com.company.Warehouse;
import com.company.Waybill;

import java.io.*;
import java.util.LinkedList;

public class ThreadOutputInputWaybillList implements Runnable {
    private Warehouse warehouse;
    private boolean output;

    public ThreadOutputInputWaybillList(Warehouse warehouse, boolean output) {
        this.warehouse = warehouse;
        this.output = output;
    }

    @Override
    public void run() {
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
    }
}
