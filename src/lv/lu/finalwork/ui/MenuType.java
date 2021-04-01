package lv.lu.finalwork.ui;

public enum MenuType {
    PRODUCT_SEARCH,
    CATEGORY_VIEW,
    CATEGORY_LIST,
    PRODUCT_VIEW,
    MAIN,
    PRODUCT_ADD;


    public static MenuType returnType(int value) {
        switch (value) {
            case 0:
                return MAIN;
            case 1:
                return PRODUCT_SEARCH;
            case 2:
                return CATEGORY_VIEW;
            case 3:
                return CATEGORY_LIST;
            case 4:
                return PRODUCT_VIEW;
            case 5:
                return PRODUCT_ADD;


            default:
                return null;
        }
    }


}
