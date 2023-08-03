package by.pvt.core.multi.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String type;
    private String nameProduct;
    private int codeProduct;
    private double price;

    public Product(int id, String types, String productName, int code_Product, double priSe) {
        this.id = id;
        this.type = types;
        this.nameProduct = productName;
        this.codeProduct = code_Product;
        this.price = priSe;
    }
    public Product(){}
    public int getId(){return id;}
    public String getType(){ return type;}
    public String getNameProduct(){return nameProduct;}
    public  int getCodeProduct(){return codeProduct;}
    public double getPrice(){return price;}

    public void setId(int Id){ this.id = Id; }
    public void setType(String t) {this.type = t;}
    public void setNameProduct (String sNP) {this.nameProduct = sNP;}
    public void setCodeProduct(int sCP) {this.codeProduct = sCP;}
    public void setPrice(double pRise) {this.price = pRise;}

}
