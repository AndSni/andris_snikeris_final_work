package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.model.ProductForListing;
import lv.lu.finalwork.ui.Launcher;
import lv.lu.finalwork.ui.MenuType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Utilities {

    public static int renderableProductId = 0;

    public static BigDecimal calculatePriceWithDiscount(BigDecimal regularPrice, BigDecimal discount) {
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
        for (Product product : productList) {
            productForListingList.add(prepareProductForListing(product));
        }
        return productForListingList;
    }

    public static void renderMenuBorder() {
        System.out.println("----------------------------------------");
    }

    public static MenuType menuScanner() throws IOException {
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'Q') { Setup setup = new Setup(); setup.exit();}
        return MenuType.returnType(Integer.parseInt(value));
    }

    public static String standardInputScanner(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static ProductCategory menuScannerForCategories() throws Exception {
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'Q') { Setup setup = new Setup(); setup.exit();}
        return ProductCategory.returnCategory(Integer.parseInt(value));
    }

    public static MenuType menuScannerForCategoriesList() throws Exception {

        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'M') {
            return MenuType.MAIN;
        }
        if (Character.toUpperCase(letter) == 'A') {
            return MenuType.PRODUCT_ADD;
        }
        if (Character.toUpperCase(letter) == 'D') {
            System.out.println("D detected");
        }
        if (Character.toUpperCase(letter) == 'Q') { Launcher.setup.exit();}
        renderableProductId = Integer.parseInt(value);
        return MenuType.returnType(Integer.parseInt(value));
    }


}
