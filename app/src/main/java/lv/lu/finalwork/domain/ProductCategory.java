package lv.lu.finalwork.domain;

public enum ProductCategory {
    FRUIT,
    SOFT_DRINKS,
    BREAD,
    CHEESE,
    MEAT,
    FISH,
    MILK,
    VEGETABLES,
    CANDIES,
    NONE;

    public static ProductCategory returnCategory(int value) throws Exception {
        int i = 1;
        try{
        for (ProductCategory category : ProductCategory.values()) {
            if (i == value) {
                return category;
            }
            i++;
        }}
        catch (Exception e){
            System.out.println("Failed to find according category. Exiting.");
        }
       return ProductCategory.NONE;

    }
}
