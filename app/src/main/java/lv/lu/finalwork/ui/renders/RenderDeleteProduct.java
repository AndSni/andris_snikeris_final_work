package lv.lu.finalwork.ui.renders;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.ui.Launcher;
import lv.lu.finalwork.ui.Renderer;
import lv.lu.finalwork.ui.Scanners;

import static lv.lu.finalwork.system.Utilities.*;

public class RenderDeleteProduct {

    public void startProductDeleteRoutine(int id) throws Exception {
        ProductCategory currentCategory = Launcher.setup.getProductRepository().findById((long) id).getCategory();
        renderMenuBorder();
        System.out.println("You are about to delete product with ID " + id);
        System.out.println("Are you sure? Y / N");
        Renderer renderer = new Renderer();
        char option = Scanners.standardInputScanner().charAt(0);
        System.out.println(option);
        switch (Character.toUpperCase(option)) {
            case 'Y':
                Launcher.setup.getProductRepository().delete((long) id);
                renderer.renderCategoryView(currentCategory);
                break;
            case 'N':
                renderer.renderProductView(id);
                break;
            default:
                renderer.renderMainMenu();
        }
    }
}
