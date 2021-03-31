package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.model.ProductForListing;
import lv.lu.finalwork.system.Utilities;

import java.util.List;


public class RenderList {

    public void render(List<Product> productList) {
        RenderListHeader.renderHeaderForList();
        List<ProductForListing> preparedList = Utilities.prepareListForRendering(productList);
        for (ProductForListing product : preparedList) {
            System.out.printf("%-4d | %-12s | %-12s | %12.2f $ | %7s%% | %9.2f $  | %-40s \n", product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getDiscount(), product.getPriceWithDiscount(), product.getDescription());
        }
    }

    public void render(List<Product> productList, ProductCategory category) {
        RenderListHeader.renderHeaderForCategory(category);
        List<ProductForListing> preparedList = Utilities.prepareListForRendering(productList);
        for (ProductForListing product : preparedList) {
            if (product.getCategory() == category) {
                System.out.printf("%-4d | %-12s | %12.2f $ | %7s%% | %9.2f $  | %-40s \n", product.getId(), product.getName(), product.getPrice(), product.getDiscount(), product.getPriceWithDiscount(), product.getDescription());
            }
        }
    }
}
