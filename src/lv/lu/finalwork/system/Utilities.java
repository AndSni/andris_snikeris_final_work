package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductForListing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Utilities {

    private static BigDecimal calculatePriceWithDiscount(BigDecimal regularPrice, BigDecimal discount) {
        return regularPrice.subtract((regularPrice.multiply(discount).divide(new BigDecimal("100"))));
    }


    public static void clearScreen() {
        int screenClearingRows = 20;
        for (int i = 0; i < screenClearingRows; i++) {
            System.out.println("");
        }
    }

    public static ProductForListing prepareProductForListing(Product product) {
        return new ProductForListing(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getDiscount(),
                product.getDescription(),
                calculatePriceWithDiscount(product.getPrice(), product.getDiscount()));
    }

    public static List<ProductForListing> prepareListForRendering(List<Product> productList) {
        List<ProductForListing> productForListingList = new ArrayList<>();
        for(Product product : productList){
            productForListingList.add(prepareProductForListing(product));
        }
        return productForListingList;
    }

}
