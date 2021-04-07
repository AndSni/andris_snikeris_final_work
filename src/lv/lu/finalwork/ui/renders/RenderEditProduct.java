package lv.lu.finalwork.ui.renders;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.ui.Launcher;
import lv.lu.finalwork.ui.Renderer;
import lv.lu.finalwork.ui.Scanners;

import java.math.BigDecimal;

import static lv.lu.finalwork.system.Utilities.renderMenuBorder;

public class RenderEditProduct {
    private Product tempProduct = new Product();

    public void editProductRoutine(int id) throws Exception {
        String input;
        System.out.println("Editing product. Leave empty space if no changes necessary.");
        renderMenuBorder();

        System.out.printf("Current name: %-10s | Enter new NAME", getName(id));
        input = Scanners.standardInputScanner();
        if (!input.isEmpty()) {
            tempProduct.setName(input);
        } else {
            tempProduct.setName(getName(id));
        }

        System.out.printf("Current price: %-10s$ | Enter new PRICE", getPrice(id));
        input = Scanners.standardInputScanner();
        if (!input.isEmpty()) {
            System.out.println("Debug:" + input);
            tempProduct.setPrice(new BigDecimal(input));
        } else {
            tempProduct.setPrice(new BigDecimal(getPrice(id)));
        }

        System.out.printf("Current Discount: %-10s$ | Enter new DISCOUNT", getDiscount(id));
        input = Scanners.standardInputScanner();
        if (!input.isEmpty()) {
            tempProduct.setDiscount(new BigDecimal(input));
        } else {
            tempProduct.setDiscount(new BigDecimal(getDiscount(id)));
        }

        System.out.printf("Current description: %-10s \n Enter new DESCRIPTION", getDescription(id));
        input = Scanners.standardInputScanner();
        if (!input.isEmpty()) {
            tempProduct.setDescription(input);
        } else {
            tempProduct.setDescription(getDescription(id));
        }

        tempProduct.setCategory(getCategory(id));

        renderMenuBorder();
        Renderer renderer = new Renderer();
        System.out.println("Is entered information correct? Y / N");
        char option = Scanners.standardInputScanner().charAt(0);
        System.out.println(option);
        switch (Character.toUpperCase(option)) {
            case 'Y':
                tempProduct.setId((long) id);
                Launcher.setup.getProductRepository().update((long) id, tempProduct);

                renderer.renderProductView(id);
                break;
            case 'N':
                renderer.renderProductView(id);
                break;
            default:
                renderer.renderMainMenu();
        }

    }

    private String getName(long id) {
        return Launcher.setup.getProductRepository().findById(id).getName();
    }
    private String getPrice(long id) {
        return Launcher.setup.getProductRepository().findById(id).getPrice().toString();
    }
    private String getDiscount(long id) {
        return Launcher.setup.getProductRepository().findById(id).getDiscount().toString();
    }
    private String getDescription(long id) {
        return Launcher.setup.getProductRepository().findById(id).getDescription();
    }
    private ProductCategory getCategory(long id) {
        return Launcher.setup.getProductRepository().findById(id).getCategory();
    }
}
