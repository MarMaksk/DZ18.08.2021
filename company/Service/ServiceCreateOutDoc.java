package com.company.Service;

import com.company.Thread.ThreadOutputInputProductList;
import com.company.Thread.ThreadOutputInputWaybillList;
import com.company.Warehouse;

import java.io.*;

public class ServiceCreateOutDoc implements Serializable {

    //Долго мучился но никак не смог избавиться от метода sleep. Если будет время то расскажите
    //И покажите как синхронизировать потоки. У меня и в тех практических заданиях это не вышло
    //Запись в файл никак не получается синхронизовать. А другое я не пробовал

    public void createDocAboutWarehouse(Warehouse warehouse) {
        new Thread(new ThreadOutputInputProductList(warehouse, true)).start();
        new Thread(new ThreadOutputInputWaybillList(warehouse, true)).start();
    }

    public void showDoc(Warehouse warehouse) {
        new Thread(new ThreadOutputInputProductList(warehouse, false)).start();
        new Thread(new ThreadOutputInputWaybillList(warehouse, false)).start();
    }

    public String WarehouseToTheArchive(Warehouse warehouse) {
        File file = new File(warehouse.getAdress() + "OLD" + ".dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(warehouse);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getName();
    }

    public Warehouse getWarehouseOutOfTheArchive(String warehouseName) throws ClassNotFoundException {
        File file = new File(warehouseName + "OLD" + ".dat");
        Warehouse warehouse = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            warehouse = (Warehouse) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return warehouse;
    }
}
