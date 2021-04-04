package lv.lu.finalwork.ui.renders;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;

import java.util.List;

public class RenderListHeader {

    public static void renderHeaderForList() {
        System.out.printf("%-4s | %-12s | %-12s | %-14s | %-8s | %-12s | %-40s \n", "ID", "Product name", "Category", "Regular price", "Discount", "Actual price", "Description");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    public static void renderHeaderForCategory(ProductCategory category) {
        String title = "Products in category: " + category;
        System.out.printf("|| %-96s ||\n", title);
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s | %-12s | %-14s | %-8s | %-12s | %-40s \n", "ID", "Product name", "Regular price", "Discount", "Actual price","Description");
        System.out.println("------------------------------------------------------------------------------------------------------");
    }
}
