package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.system.InputValidator;
import lv.lu.finalwork.system.Utilities;

import java.io.IOException;
import java.util.Scanner;

public class Scanners {

    public static String standardInputScanner() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static MenuType menuScanner() throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        do {
            value = scan.nextLine();
            inputVerified = InputValidator.validateMenu(value,'Q');
            if(Integer.parseInt(value) < 1 || Integer.parseInt(value) > 3) inputVerified = false;
            if(!inputVerified){
                System.out.println("Entered value is not valid. Check for correct option value.");
            }
        } while (!inputVerified);

        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'Q') {
            Launcher.setup.exit();
        }
        return MenuType.returnType(Integer.parseInt(value));
    }

    public static ProductCategory menuScannerForCategories() throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        do {
            value = scan.nextLine();
            inputVerified = InputValidator.validateCategoryMenuInput(value,'Q');
            if(!inputVerified){
                System.out.println("Entered value is not valid. Check for correct option value.");
            }
        } while (!inputVerified);


        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'Q') {
            Launcher.setup.exit();
        }
        return ProductCategory.returnCategory(Integer.parseInt(value));
    }

    public static MenuType menuScannerForCategoriesList(ProductCategory _category) throws Exception {

        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        do {
            value = scan.nextLine();
            inputVerified = InputValidator.validateMenu(value,'Q','M','A','D');
            if(!InputValidator.validateProductIdWithinCategoryRange(value, Launcher.setup.getProductRepository(), _category)) inputVerified = false;
            if(!inputVerified){
                System.out.println("Entered value is not valid. Check for correct option value.");
            }
        } while (!inputVerified);

        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'M') {
            return MenuType.MAIN;
        }
        if (Character.toUpperCase(letter) == 'A') {
            return MenuType.PRODUCT_ADD;
        }
        if (Character.toUpperCase(letter) == 'D') {
            return MenuType.CATEGORY_DISCOUNT;
        }
        if (Character.toUpperCase(letter) == 'Q') {
            Launcher.setup.exit();
        }

        Utilities.renderableProductId = Integer.parseInt(value);
        return MenuType.PRODUCT_VIEW;
    }

    public static MenuType menuScannerForProductView() throws Exception {

        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        do {
            value = scan.nextLine();
            inputVerified = InputValidator.validateMenuOnlyChars(value,'E','M','D','Q');
            if(!inputVerified){
                System.out.println("Entered value is not valid. Check for correct option value.");
            }
        } while (!inputVerified);

        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'M') {
            return MenuType.MAIN;
        }
        if (Character.toUpperCase(letter) == 'E') {
            return MenuType.PRODUCT_EDIT;
        }
        if (Character.toUpperCase(letter) == 'D') {
            return MenuType.PRODUCT_DELETE;
        }
        if (Character.toUpperCase(letter) == 'Q') {
            Launcher.setup.exit();
        }

        Utilities.renderableProductId = Integer.parseInt(value);
        return MenuType.PRODUCT_VIEW;
    }

    public static MenuType menuScannerForProductSearch() throws Exception {

        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        do {
            value = scan.nextLine();
            inputVerified = InputValidator.validateMenu(value,'Q','M');
            if(!InputValidator.validateProductIdAllRange(value, Launcher.setup.getProductRepository())) inputVerified = false;
            if(!inputVerified){
                System.out.println("Entered value is not valid. Check for correct option value.");
            }
        } while (!inputVerified);


        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'M') {
            return MenuType.MAIN;
        }
        if (Character.toUpperCase(letter) == 'Q') {
            Launcher.setup.exit();
        }

        Utilities.renderableProductId = Integer.parseInt(value);
        return MenuType.PRODUCT_VIEW;
    }
}
