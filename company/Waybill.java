package com.company;

import com.company.Production.Product;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Waybill implements Serializable {
    private int ID;
    private String from;
    private Warehouse by;
    private Warehouse to;
    private List<Product> productList;
    private String company;
    private boolean use = false;
    private Date date;

    public Waybill(String date, Object from, Warehouse to, String company, List<Product> productList) {
        if (from instanceof String) {
            String str = (String) from;
            this.from = str;
        } else if (from instanceof Warehouse) {
            Warehouse wh = (Warehouse) from;
            this.by = wh;
        }
        this.to = to;
        this.productList = productList;
        this.company = company;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.ID = ID++;
    }
    /*
    * Как лучше. Делать перегрузки или сделать как я сделал в первом конструкторе через instaneof?
    * Есть ли смысл делать глобальную переменную from типом object?
    * В дальнейшем если бы это понадобилось использовать тогда надо было бы писать instanceof
    * Но тогда бы не понадобилась перегрузка в методе createWaybill в классе ServiceManager
     */

//    public Waybill(SimpleDateFormat date, String from, Warehouse to, String company, List<Product> productList) {
//        this.from = from;
//        this.to = to;
//        this.productList = productList;
//        this.company = company;
//        this.date = date;
//        this.ID = ID++;
//    }
//
//    // Перегузка на случай перемещения между складами и поступления из вне
//    public Waybill(SimpleDateFormat date, Warehouse from, Warehouse to, String company, List<Product> productList) {
//        this.by = from;
//        this.to = to;
//        this.productList = productList;
//        this.company = company;
//        this.date = date;
//        this.ID = ID++;
//    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return "Накладная{" +
                "Номер=" + ID +
                ", Откуда='" + from + '\'' +
                ", Куда='" + to + '\'' +
                ", Список товаров=" + productList +
                ", Поставщик='" + company + '\'' +
                ", Зачислено=" + use +
                ", Дата=" + date +
                '}';
    }
}