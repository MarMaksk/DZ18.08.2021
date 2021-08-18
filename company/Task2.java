package com.company;

import com.company.Production.Product;
import com.company.Production.ProductTree;
import com.company.Service.ServiceCreateOutDoc;
import com.company.Service.ServiceManager;

public class Task2 {
    public static void main(String[] args) {
        Warehouse wh1 = new Warehouse("Getchi street, house 2");
        Warehouse wh2 = new Warehouse("Getch street, house 3");
        ServiceManager serviceManager = new ServiceManager();
        Waybill wb1 = serviceManager.createWaybill("XXY", wh1, "XXY", "11.11.2020",
                new Product(0, "Better", 10, 1),
                new Product(1, "Warhead", 10, 1090));
        Warehouse wh3 = new Warehouse("G");
        serviceManager.admission(wh3, wb1);
        serviceManager.admission(wh1, wb1); // не добавит т.к. флаг тру
        //serviceManager.showAllProduct(wh3);
        ProductTree pt = serviceManager.exchangeProduct(wh1, "Better", 1, 1);
        serviceManager.createWaybill(wh2, wh1, "XXX", "11.12.2202");
        ServiceCreateOutDoc scod = new ServiceCreateOutDoc();
        scod.createDocAboutWarehouse(wh3);
        scod.showDoc(wh3);
    }
}
