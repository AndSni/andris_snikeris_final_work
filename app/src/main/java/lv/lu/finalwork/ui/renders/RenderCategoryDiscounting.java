package lv.lu.finalwork.ui.renders;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.ui.Launcher;
import lv.lu.finalwork.ui.Renderer;
import lv.lu.finalwork.ui.Scanners;

import java.math.BigDecimal;

import static lv.lu.finalwork.system.Utilities.renderMenuBorder;

public class RenderCategoryDiscounting {
    ProductCategory category;

    public void updateDiscountRoutine(ProductCategory category) throws Exception {

        this.category = category;

        System.out.println();
        renderMenuBorder();
        System.out.println("Enter amount of discount in %");
        renderMenuBorder();
        BigDecimal tempDiscount = new BigDecimal(Scanners.productInputScanner(Scanners.PRODUCT_INPUT_TYPE.ADD_DISCOUNT));
        Renderer renderer = new Renderer();
        System.out.println("Is entered information correct? Y / N");
        char option = Scanners.productInputScanner(Scanners.PRODUCT_INPUT_TYPE.YES_NO).charAt(0);
        System.out.println(option);
        switch (Character.toUpperCase(option)) {
            case 'Y':
                //Launcher.setup.getProductRepository().save(tempProduct);
                updateProductDiscounts(tempDiscount);
                renderer.renderCategoryView(category);
                break;
            case 'N':
                renderer.renderCategoryView(category);
                break;
            default:
                renderer.renderMainMenu();
        }

    }

    private void updateProductDiscounts(BigDecimal tempDiscount) {
        for(Product product : Launcher.setup.getProductRepository().findByCategory(category)){
            product.setDiscount(tempDiscount);
        }
    }

}
