package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.ProductCategory;

import static lv.lu.finalwork.system.Utilities.*;

public class RenderCategories {

    public void render() {
        int i = 1;
        renderMenuBorder();
        for(ProductCategory category : ProductCategory.values()){
            System.out.printf("%-3s ---   %-10s\n", i, category.name());
            i++;
        }
        renderMenuBorder();
    }
}
