package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;

import java.math.BigDecimal;
import java.sql.SQLOutput;

import static lv.lu.finalwork.system.Utilities.*;

public class RenderAddProduct {

    private Product tempProduct = new Product();

    public void addProductRoutine(ProductCategory category) throws Exception {
        System.out.println("Adding new product");
        renderMenuBorder();
        System.out.println("Enter product NAME");
        tempProduct.setName(standardInputScanner());
        tempProduct.setCategory(category);
        System.out.println("Enter PRICE");
        tempProduct.setPrice(new BigDecimal(standardInputScanner()));
        System.out.println("Enter DISCOUNT");
        tempProduct.setDiscount(new BigDecimal(standardInputScanner()));
        System.out.println("Enter DESCRIPTION");
        tempProduct.setDescription(standardInputScanner());
        renderMenuBorder();
        Renderer renderer = new Renderer();
        System.out.println("Is entered information correct? Y / N");
        char option = standardInputScanner().charAt(0);
        System.out.println(option);
        switch (Character.toUpperCase(option)) {
            case 'Y':
                Launcher.setup.getProductRepository().save(tempProduct);
                renderer.renderCategoryView(category);
                break;
            case 'N':
                renderer.renderCategoryView(category);
                break;
            default:
                renderer.renderMainMenu();
        }

    }


}
