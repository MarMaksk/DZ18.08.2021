package com.company.Service;

import com.company.Production.Product;
import com.company.Production.ProductTree;
import com.company.Production.nullProduct;
import com.company.Warehouse;
import com.company.Waybill;

import java.io.*;
import java.util.*;

public class ServiceManager implements Serializable {

    public static Set<String> listOfAllCompany = new HashSet<>();

    public Warehouse admission(Warehouse warehouse, Waybill waybill) {
        if (!waybill.isUse()) {
            warehouse.getWaybillList().add(waybill);
            warehouse.getCompanyList().add(waybill.getCompany());
            listOfAllCompany.add(waybill.getCompany());
            //К нам может поступить товар который уже есть на складе
            for (Product product : warehouse.getProductsList()) {
                for (Product prod : waybill.getProductList()) {
                    if (product.getProdName().equals(prod.getProdName())) {
                        product.setAmount(product.getAmount() + prod.getAmount());
                        product.setPrice(product.getPrice() + prod.getPrice());
                        waybill.getProductList().remove(prod);
                        warehouse.setProdID(warehouse.getProdID() + 1);
                    }
                }
            }
            // Оставшейся просто добавляем
            waybill.getProductList().stream().forEach(el -> {
                warehouse.getProductsList().add(warehouse.getProdID(), el);
                warehouse.setProdID(warehouse.getProdID() + 1);
            });
        }
        waybill.setUse(true);
        return warehouse;
    }

    public void showAllProduct(Warehouse warehouse) {
        warehouse.getProductsList().forEach(System.out::println);
    }

    public Optional<Product> searchProduct(Warehouse warehouse, String prodName) {
        return warehouse.getProductsList().stream().filter(el -> el.getProdName().equals(prodName)).findFirst();
    }

    // Метод для выделения товаров со склада. Продуктовое дерево\деревья можно будет отправить в метод createWaybill
    public ProductTree exchangeProduct(Warehouse warehouse, String prodName, int amount, int price) {
        // Выделяем продукт со склада для накладной
        // одневременно делая проверку на наличие
        for (Product list : warehouse.getProductsList()) {
            if (list.getProdName().equals(prodName)) {
                if (list.getAmount() >= amount) {
                    list.setAmount(list.getAmount() - amount);
                    return new Product(warehouse.getProdID(), prodName, amount, price);
                }
            }
        }
        return new nullProduct();
    }

    public Waybill createWaybill(Warehouse from, Warehouse to, String company, String date, ProductTree... prod) {
        //Создаём и заполняем накладную товарами
        return new Waybill(date, from, to, company, new ArrayList(Arrays.asList(prod)));
    }

    public Waybill createWaybill(String from, Warehouse to, String company, String date, ProductTree... prod) {
        //Создаём и заполняем накладную товарами
        return new Waybill(date, from, to, company, new ArrayList(Arrays.asList(prod)));
    }

    public Set<String> getExternalCompany() {
        listOfAllCompany.stream().forEach(el -> {
            if (!el.equals("XXX")) {
                System.out.println(el);
            }
        });
        return listOfAllCompany;
    }
}
