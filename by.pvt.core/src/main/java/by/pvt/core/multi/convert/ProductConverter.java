package by.pvt.core.multi.convert;

import by.pvt.api.dto.ProductRequest;
import by.pvt.api.dto.ProductResponse;
import by.pvt.core.multi.domain.Product;

public class ProductConverter
    {
    //из объекта в сущность
    public Product productToDTO(ProductRequest productR) {
        Product pp = new Product();
        pp.setId(productR.getId());
        pp.setType(productR.getType());
        pp.setNameProduct(productR.getNameProduct());
        pp.setCodeProduct(productR.getCodeProduct());
        pp.setPrice(productR.getPrice());
        return pp;
    }
    // из сущности в объект
    public ProductResponse productToEntity(Product product) {
        ProductResponse dto = new ProductResponse();
        dto.setId(product.getId());
        dto.setType(product.getType());
        dto.setNameProduct(product.getNameProduct());
        dto.setCodeProduct(product.getCodeProduct());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
