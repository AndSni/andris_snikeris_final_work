package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.repository.Repository;

import java.math.BigDecimal;
import java.util.List;


public class Updater {

    public void updateProduct(Product product, String name, BigDecimal price, ProductCategory category, BigDecimal discount, String description) {
        if(name != null) product.setName(name);
        if(price != null) product.setPrice(price);
        if(category != null) product.setCategory(category);
        if(discount != null) product.setDiscount(discount);
        if(description != null) product.setDescription(description);
    }

    public void updateDiscountForCategory(ProductRepository repository, ProductCategory category, BigDecimal discount){
        List<Product> repositoryList = repository.findAll();
        for(Product product : repositoryList){
            if(product.getCategory() == category) product.setDiscount(discount);
        }
    }


}
