package com.company.Production;

public class Product implements ProductTree {
    private int id;
    private String prodName;
    private int amount;
    private int price;
    private int sum;

    public Product(int id, String prodName, int amount, int price) {
        this.id = id;
        this.prodName = prodName;
        this.amount = amount;
        this.price = price;
        this.sum = price*amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Товар{" +
                "поз. " + id +
                ", наименование='" + prodName + '\'' +
                ", количества=" + amount +
                ", цена=" + price +
                ", сумма=" + sum +
                '}';
    }
}

