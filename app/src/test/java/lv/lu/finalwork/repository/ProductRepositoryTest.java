package lv.lu.finalwork.repository;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductRepositoryTest {

    private Map<Long, Product> repoMock;
    private ProductRepository victim;


    public ProductRepositoryTest() {
    }

    @Before
    public void setUp() throws Exception {
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);

    }

    @Test
    public void shouldSaveOrangeWithId1() {
        Product orange = new Product();

        long id = victim.save(orange);

        assertEquals(1L, id);
        assertTrue(repoMock.containsKey(1L));
        assertEquals(orange, repoMock.get(1L));

    }

    @Test
    public void shouldFindAllProducts() {
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);

        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        List<Product> result = victim.findAll();
        assertNotNull(result);
        assertTrue(result.contains(orange));
        assertTrue(result.contains(fish));
    }

    @Test
    public void shouldFindFishById() {
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);

        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        assertEquals(fish, victim.findById(2L));
    }

    @Test
    public void shouldDeleteId1FromRepo() {
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);

        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        victim.delete(1L);
        assertFalse(repoMock.containsKey(1L));

    }

    @Test
    public void shouldChangePrice() {
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);

        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        assertEquals(fish, victim.findById(2L));
    }

    @Test
    public void shouldFind2FishProducts(){
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

        List<Product> result = victim.findByCategory(ProductCategory.FISH);
        assertNotNull(result);
        assertTrue(result.contains(fish));
        assertTrue(result.contains(bigFish));
        assertFalse(result.contains(orange));
        assertFalse(result.contains(redOrange));
    }
}