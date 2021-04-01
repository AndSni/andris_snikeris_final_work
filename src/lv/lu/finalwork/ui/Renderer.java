package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.system.Setup;
import lv.lu.finalwork.system.Utilities;


import java.io.IOException;
import java.sql.SQLOutput;

import static lv.lu.finalwork.system.Utilities.*;

public class Renderer {

    public void render(MenuType type, int id, ProductCategory category) throws Exception {

        switch (type) {
            case MAIN -> renderMainMenu();
            case PRODUCT_VIEW -> renderProductView(id);
            case CATEGORY_VIEW -> renderCategoryView(category);
            case CATEGORY_LIST -> renderCategoryList();
            case PRODUCT_SEARCH -> renderProductSearch();
            case PRODUCT_ADD -> renderAddProductRoutine(category);
            default -> throw new Exception("Render type not available");
        }

    }

    private void renderAddProductRoutine(ProductCategory category) throws Exception {
        RenderAddProduct addRoutine = new RenderAddProduct();
        addRoutine.addProductRoutine(category);
    }


    public void renderMainMenu() throws Exception {
        renderMenuBorder();
        System.out.printf("%4s  ---  Search product by ID\n", 1);
        System.out.printf("%4s  ---  List all products\n", 2);
        System.out.printf("%4s  ---  List categories\n", 3);
        System.out.printf("%4s  ---  Exit application\n", "Q");
        renderMenuBorder();
        renderMainMenuOptions();
    }

    private void renderProductSearch() throws Exception {
        clearScreen();
        renderMenuBorder();
        System.out.printf("Type ID number of Product\n");
        renderMenuBorder();
        render(menuScanner(), 0, null);
    }

    private void renderCategoryList() throws Exception {
        clearScreen();
        RenderCategories categories = new RenderCategories();
        categories.render();
        renderCategoryListOptions();
    }

    private void renderCategoryListOptions() throws Exception {
        System.out.println();
        System.out.println("Enter according number to continue:");
        render(MenuType.CATEGORY_VIEW, 0, menuScannerForCategories());
    }

    public void renderCategoryView(ProductCategory category) throws Exception {
        RenderList list = new RenderList();
        list.render(Launcher.setup.getProductRepository().findAll(), category);
        renderCategoryViewOptions(category);
    }

    private void renderCategoryViewOptions(ProductCategory category) throws Exception {
        System.out.println();
        System.out.println("Enter according ID to EDIT product.");
        System.out.println("Enter 'A' to ADD new PRODUCT");
        System.out.println("Enter 'D' to set DISCOUNT for all current category products.");
        System.out.println("Enter 'M' for MAIN MENU." );
        System.out.println("Enter 'Q' to EXIT application." );
        render(menuScannerForCategoriesList(), renderableProductId, category);

    }

    private void renderProductView(int id) {

    }

    public void renderStartup() throws Exception {
        render(MenuType.MAIN, 0, null);

    }


    private void renderMainMenuOptions() throws Exception {
        System.out.println();
        System.out.println("Enter according number to continue:");
        render(menuScanner(), 0, null);
    }

    }
