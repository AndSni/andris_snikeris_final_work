package lv.lu.finalwork.ui.renders;

import lv.lu.finalwork.model.Product;

import static lv.lu.finalwork.system.Utilities.*;

public class RenderProduct {
    public void render(Product product) {
        renderMenuBorder();
        System.out.printf("ID            --  %-4s\n", product.getId());
        System.out.printf("Name          --  %-15s\n", product.getName());
        System.out.printf("Category      --  %-15s\n", product.getCategory().name());
        System.out.printf("Regular price --  %-1.2f $\n", product.getPrice());
        System.out.printf("Discount      --  %-1s%%\n", product.getDiscount());
        System.out.printf("Actual price  --  %-1.2f $\n", calculatePriceWithDiscount(product.getPrice(), product.getDiscount()));
        System.out.printf("Description   --  %-40s\n", product.getDescription());
        renderMenuBorder();
    }
}
