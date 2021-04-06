package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.ui.renders.*;


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
            case PRODUCT_DELETE -> renderProductDeleteRoutine(id);
            case PRODUCT_EDIT -> renderProductEditRoutine(id);
            case PRODUCT_LIST -> renderProductList();
            case CATEGORY_DISCOUNT -> renderCategoryDiscounting(category);

            default -> throw new Exception("Render type not available");
        }

    }

    private void renderCategoryDiscounting(ProductCategory category) throws Exception {
        RenderCategoryDiscounting discounting = new RenderCategoryDiscounting();
        discounting.updateDiscountRoutine(category);
    }




    private void renderProductList() throws Exception {
        RenderList renderList = new RenderList();
        renderList.render(Launcher.setup.getProductRepository().findAll());
        renderProductListOptions();
    }
    private void renderProductListOptions() throws Exception {
        System.out.println();
        System.out.println("Enter according ID to EDIT product.");
        System.out.println("Enter 'M' for MAIN MENU." );
        System.out.println("Enter 'Q' to EXIT application." );
        render(Scanners.menuScannerForCategoriesList(), renderableProductId, null);
    }




    private void renderProductEditRoutine(int id) throws Exception {
        RenderEditProduct editProduct = new RenderEditProduct();
        editProduct.editProductRoutine(id);
    }


    private void renderProductDeleteRoutine(int id) throws Exception {
        RenderDeleteProduct deleteRoutine = new RenderDeleteProduct();
        deleteRoutine.startProductDeleteRoutine(id);
    }


    private void renderAddProductRoutine(ProductCategory category) throws Exception {
        RenderAddProduct addRoutine = new RenderAddProduct();
        addRoutine.addProductRoutine(category);
    }



    public void renderMainMenu() throws Exception {
        System.out.println();
        System.out.println(".<~-  Product Manager 2000 v0.1a -~>.");
        renderMenuBorder();
        System.out.printf("%4s  ---  Search product by ID\n", 1);
        System.out.printf("%4s  ---  List all products\n", 2);
        System.out.printf("%4s  ---  List categories\n", 3);
        System.out.printf("%4s  ---  Exit application\n", "Q");
        renderMenuBorder();
        renderMainMenuOptions();
    }
    private void renderMainMenuOptions() throws Exception {
        System.out.println();
        System.out.println("Enter according number to continue:");
        render(Scanners.menuScanner(), 0, null);
    }



    private void renderProductSearch() throws Exception {
        clearScreen();
        renderMenuBorder();
        System.out.printf("Product search by ID number\n");
        renderMenuBorder();
        renderProductSearchOptions();
        render(Scanners.menuScannerForProductSearch(), renderableProductId, null);
    }
    private void renderProductSearchOptions() {
        System.out.println();
        System.out.println("Enter according product ID");
        System.out.println("Enter 'M' for MAIN MENU." );
        System.out.println("Enter 'Q' to EXIT application." );
        System.out.println();
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
        render(MenuType.CATEGORY_VIEW, 0, Scanners.menuScannerForCategories());
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
        render(Scanners.menuScannerForCategoriesList(), renderableProductId, category);
    }



    public void renderProductView(int id) throws Exception {
        RenderProduct productView = new RenderProduct();
        productView.render(Launcher.setup.getProductRepository().findById((long) id));
        renderProductViewOptions(id);
    }
    private void renderProductViewOptions(int id) throws Exception {
        System.out.println();
        System.out.println("Enter 'E' to EDIT product.");
        System.out.println("Enter 'D' to DELETE product.");
        System.out.println("Enter 'M' for MAIN MENU." );
        System.out.println("Enter 'Q' to EXIT application." );
        render(Scanners.menuScannerForProductView(), id, null);
    }



    public void renderStartup() throws Exception {
        render(MenuType.MAIN, 0, null);
    }

    }
