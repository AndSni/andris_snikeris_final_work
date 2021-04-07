package lv.lu.finalwork.ui.renders;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.ui.Launcher;
import lv.lu.finalwork.ui.Renderer;
import lv.lu.finalwork.ui.Scanners;

import java.math.BigDecimal;

import static lv.lu.finalwork.system.Utilities.*;

public class RenderAddProduct {

    private Product tempProduct = new Product();

    public void addProductRoutine(ProductCategory category) throws Exception {
        System.out.println("Adding new product");
        renderMenuBorder();
        System.out.println("Enter product NAME");
        tempProduct.setName(Scanners.standardInputScanner());
        tempProduct.setCategory(category);
        System.out.println("Enter PRICE");
        tempProduct.setPrice(new BigDecimal(Scanners.standardInputScanner()));
        System.out.println("Enter DISCOUNT");
        tempProduct.setDiscount(new BigDecimal(Scanners.standardInputScanner()));
        System.out.println("Enter DESCRIPTION");
        tempProduct.setDescription(Scanners.standardInputScanner());
        renderMenuBorder();
        Renderer renderer = new Renderer();
        System.out.println("Is entered information correct? Y / N");
        char option = Scanners.standardInputScanner().charAt(0);
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
