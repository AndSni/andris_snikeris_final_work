/*package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UpdaterTest {

    private Map<Long, Product> repoMock;
    private ProductRepository victim;

    @Before
    public void setUp() throws Exception {
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);

    }

    @Test
    public void shouldUpdateProductName(){
        Product orange = new Product();
        orange.setName("Orange");
        Updater updater = new Updater();
        updater.updateProduct(orange,"Red Orange", null, null, null, null);

        assertEquals("Red Orange", orange.getName());
    }

    @Test
    public void shouldUpdateProductNameAndPrice(){
        Product orange = new Product();
        orange.setName("Orange");
        orange.setPrice(new BigDecimal("23.23"));
        Updater updater = new Updater();
        updater.updateProduct(orange,"Red Orange", new BigDecimal("20.45"), null, null, null);

        assertEquals("Red Orange", orange.getName());
        assertEquals(new BigDecimal("20.45"), orange.getPrice());
    }

    @Test
    public void shouldUpdateProductNameAndPriceAndCategory(){
        Product orange = new Product();
        orange.setName("Orange");
        orange.setPrice(new BigDecimal("23.23"));
        orange.setCategory(ProductCategory.CANDIES);
        Updater updater = new Updater();
        updater.updateProduct(orange,"Red Orange", new BigDecimal("20.45"), ProductCategory.BREAD, null, null);

        assertEquals("Red Orange", orange.getName());
        assertEquals(new BigDecimal("20.45"), orange.getPrice());
        assertEquals(ProductCategory.BREAD, orange.getCategory());
    }

    @Test
    public void shouldUpdateProductNameAndPriceAndCategoryAndDiscount(){
        Product orange = new Product();
        orange.setName("Orange");
        orange.setPrice(new BigDecimal("23.23"));
        orange.setCategory(ProductCategory.CANDIES);
        Updater updater = new Updater();
        updater.updateProduct(orange,"Red Orange", new BigDecimal("20.45"), ProductCategory.BREAD, new BigDecimal("5"), null);

        assertEquals("Red Orange", orange.getName());
        assertEquals(new BigDecimal("20.45"), orange.getPrice());
        assertEquals(ProductCategory.BREAD, orange.getCategory());
        assertEquals(new BigDecimal("5"), orange.getDiscount());
    }

    @Test
    public void shouldNotUpdateNameWhenUpdatingDescription(){
        Product orange = new Product();
        orange.setName("Orange");
        Updater updater = new Updater();
        updater.updateProduct(orange,null, null, null, null, "Very nice Orange");

        assertEquals("Orange", orange.getName());
        assertEquals("Very nice Orange", orange.getDescription());
    }

    @Test
    public void shouldUpdateDiscountForFishCategoryProducts(){
        Product orange = new Product();
        orange.setId(1L);
        orange.setCategory(ProductCategory.FRUIT);
        Product redOrange = new Product();
        redOrange.setId(2L);
        redOrange.setCategory(ProductCategory.FRUIT);
        Product fish = new Product();
        fish.setId(3L);
        fish.setCategory(ProductCategory.FISH);
        Product bigFish = new Product();
        bigFish.setId(4L);
        bigFish.setCategory(ProductCategory.FISH);

        repoMock.put(1L, orange);
        repoMock.put(2L, redOrange);
        repoMock.put(3L, fish);
        repoMock.put(4L, bigFish);

        Updater updater = new Updater();
        updater.updateDiscountForCategory(victim, ProductCategory.FISH, new BigDecimal("10"));

        assertEquals(null, repoMock.get(1L).getDiscount());
        assertEquals(null, repoMock.get(2L).getDiscount());
        assertEquals(new BigDecimal("10"), repoMock.get(3L).getDiscount());
        assertEquals(new BigDecimal("10"), repoMock.get(4L).getDiscount());

    }


}

 */