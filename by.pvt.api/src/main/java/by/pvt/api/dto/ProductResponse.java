package by.pvt.api.dto;

public class ProductResponse {
    private int id;
    private String type;
    private String nameProduct;
    private int codeProduct;
    private double price;

    public ProductResponse(Integer ID, String type, String nameProduct, Integer codeProduct, double PRice){
this.id = ID; this.type = type; this.nameProduct = nameProduct; this.codeProduct = codeProduct; this.price = PRice;
}
public ProductResponse(){}
public int getId(){ return id; }
public String getType(){
return type;
}
public String getNameProduct(){
return nameProduct;
}
public int getCodeProduct(){
return codeProduct;
}
public double getPrice(){
return price;
}
    public void setId(Integer Id){ this.id = Id; }
    public void setType(String t){ this.type = t;}
    public void setNameProduct(String nP){ this.nameProduct = nP; }
    public void setCodeProduct(Integer cp){ this.codeProduct = cp;  }
    public void setPrice(double Price){ this.price = Price; }
}
