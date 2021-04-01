package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.Product;

import static lv.lu.finalwork.system.Utilities.*;

public class RenderProduct {
    public void render(Product product) {
        renderMenuBorder();
        System.out.printf("ID            --  %-4s\n", product.getId());
        System.out.printf("Name          --  %-15s\n", product.getName());
        System.out.printf("Category      --  %-15a\n", product.getCategory());
        System.out.printf("Regular price --  %5.2f $\n", product.getPrice());
        System.out.printf("Discount      --  %2s%%\n", product.getDiscount());
        System.out.printf("Actual price  --  %5.2f $\n", calculatePriceWithDiscount(product.getPrice(), product.getDiscount()));
        System.out.printf("Description   --  %-40s\n", product.getDescription());
        renderMenuBorder();
    }
}
