package by.pvt.api.dto;

public class ProductResponse {
    private long id;
    private String type;
    private String nameProduct;
    private int codeProduct;
    private double price;

    public ProductResponse(long ID, String type, String nameProduct, Integer codeProduct, double PRice){
this.id = ID; this.type = type; this.nameProduct = nameProduct; this.codeProduct = codeProduct; this.price = PRice;
}
public ProductResponse(){}
public long getId(){ return id; }
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
    public void setId(long Id){ this.id = Id; }
    public void setType(String t){ this.type = t;}
    public void setNameProduct(String nP){ this.nameProduct = nP; }
    public void setCodeProduct(Integer cp){ this.codeProduct = cp;  }
    public void setPrice(double Price){ this.price = Price; }
}
