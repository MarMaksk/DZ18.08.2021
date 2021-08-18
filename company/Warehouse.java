package com.company;

import com.company.Production.Product;

import java.io.Serializable;
import java.util.*;

public class Warehouse implements Serializable {
    private String adress;
    private List<Product> productsList = new ArrayList<>();
    private List<Waybill> waybillList = new LinkedList<>();
    private static Set<String> companyList = new HashSet<>(); // Общий для всех складов список поставщиков
    private int prodID = 0; // Чтобы нумеровать каждый товар

    public Warehouse(String adress) {
        this.adress = adress;
    }

    public Warehouse(String adress, List<Product> productsList) {
        this.adress = adress;
        this.productsList = productsList;
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public List<Waybill> getWaybillList() {
        return waybillList;
    }

    public void setWaybillList(List<Waybill> waybillList) {
        this.waybillList = waybillList;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public static Set<String> getCompanyList() {
        return companyList;
    }

    public static void setCompanyList(Set<String> companyList) {
        Warehouse.companyList = companyList;
    }

    @Override
    public String toString() {
        return "Склад{" +
                "Адрес='" + adress + '\'' +
                ", Список продуктов на складе=" + productsList +
                ", Список накладных=" + waybillList +
                '}';
    }
}
