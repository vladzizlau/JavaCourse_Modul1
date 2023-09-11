package by.pvt.core.multi.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private long id;
    private String type;
    private String nameProduct;
    private int codeProduct;
    private double price;

    public Product(long id, String types, String productName, int code_Product, double priSe) {
this.id = id;
        this.type = types;
        this.nameProduct = productName;
        this.codeProduct = code_Product;
        this.price = priSe;
    }
    public Product(){}


    public long getId(){return id;}
    public String getType(){ return type;}
    public String getNameProduct(){return nameProduct;}
    public  int getCodeProduct(){return codeProduct;}
    public double getPrice(){return price;}

    public void setId(long Id){ this.id = Id; }
    public void setType(String t) {this.type = t;}
    public void setNameProduct (String sNP) {this.nameProduct = sNP;}
    public void setCodeProduct(int sCP) {this.codeProduct = sCP;}
    public void setPrice(double pRise) {this.price = pRise;}

}
