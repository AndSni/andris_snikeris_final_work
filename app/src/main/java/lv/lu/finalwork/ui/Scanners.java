package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.system.InputValidator;
import lv.lu.finalwork.system.Utilities;

import java.io.IOException;
import java.util.Scanner;

public class Scanners {
    public enum PRODUCT_INPUT_TYPE {ADD_NAME, ADD_PRICE, ADD_DISCOUNT, ADD_DESCRIPTION, YES_NO}

    public static String productInputScanner(PRODUCT_INPUT_TYPE _type) {
        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        switch (_type) {
            case ADD_NAME, ADD_DESCRIPTION: {
                do {
                    value = scan.nextLine();
                    inputVerified = InputValidator.validateTextInput(value);
                    if (!inputVerified) {
                        System.out.println("Entered text is not valid. Only letters and numbers is allowed.");
                    }
                } while (!inputVerified);
            }
            break;
            case ADD_PRICE: {
                do {
                    value = scan.nextLine();
                    inputVerified = InputValidator.validateDoubleInput(value);
                    if (!inputVerified) {
                        System.out.println("Entered price is not valid. Must be a decimal.");
                    }
                } while (!inputVerified);
            }
            break;
            case ADD_DISCOUNT: {
                do {
                    value = scan.nextLine();
                    inputVerified = InputValidator.validatePercentageInput(value);
                    if (!inputVerified) {
                        System.out.println("Entered discount is not valid. Must be number in range 0-99.");
                    }
                } while (!inputVerified);
            }
            break;
            case YES_NO: {
                do {
                    value = scan.nextLine();
                    inputVerified = InputValidator.validateYesNoInput(value);
                    if (!inputVerified) {
                        System.out.println("Entered value is not valid. Enter Y for yes, N for no.");
                    }
                } while (!inputVerified);
            }
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + _type);
        }

        return value;
    }


    public static MenuType menuScanner() throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        do {
            value = scan.nextLine();
            inputVerified = InputValidator.validateMenuChars(value, 'Q');
            if (!inputVerified) {
                try {
                    int inputNumber = Integer.parseInt(value);
                    if (inputNumber >= 1 && inputNumber <= 3) inputVerified = true;

                } catch (Exception e) {
                    inputVerified = false;
                }
            }
            if (!inputVerified) {
                System.out.println("Entered value is not valid. Check for correct option value.");
            }
        } while (!inputVerified);

        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'Q') {
            Launcher.setup.exit();
        }
        return MenuType.returnType(Integer.parseInt(value));
    }

    public static ProductCategory categoryListInput() throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        do {
            value = scan.nextLine();
            inputVerified = InputValidator.validateCategoryMenuInput(value, 'Q');
            if (!inputVerified) {
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
            inputVerified = InputValidator.validateMenuChars(value, 'Q', 'M', 'A', 'D');

            if (!inputVerified) {
                inputVerified = InputValidator.validateProductIdWithinCategoryRange(value, Launcher.setup.getProductRepository(), _category);
            }
            if (!inputVerified) {
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
            inputVerified = InputValidator.validateMenuChars(value, 'E', 'M', 'D', 'Q');
            if (!inputVerified) {
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

    public static MenuType productSearchInput() throws Exception {

        Scanner scan = new Scanner(System.in);
        boolean inputVerified;
        String value;

        do {
            value = scan.nextLine();
            inputVerified = InputValidator.validateMenuChars(value, 'Q', 'M');

            if (!inputVerified) {
                inputVerified = InputValidator.validateProductIdAllRange(value, Launcher.setup.getProductRepository());
            }
            if (!inputVerified) {
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
