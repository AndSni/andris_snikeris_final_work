package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.repository.ProductRepository;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class InputValidatorTest {
    @Test
    public void shouldAllowCharK() {
        assertTrue(InputValidator.validateMenu("K", 'L', 'K'));
    }

    @Test
    public void shouldAllowCharA() {
        assertTrue(InputValidator.validateMenuOnlyChars("A", 'A', 'K'));
    }

    @Test
    public void shouldDisallowCharA() {
        assertFalse(InputValidator.validateMenuOnlyChars("A", 'P', 'K'));
    }

    @Test
    public void shouldAllowNumber() {
        assertTrue(InputValidator.validateMenu("23", 'L', 'K'));
    }


    @Test
    public void shouldFailOnDisallowedChar() {
        assertFalse(InputValidator.validateMenu("A", 'G', 'Q', 'M'));
    }

    @Test
    public void shouldAllowString() {
        assertTrue(InputValidator.validateTextInput("Gaļas nams"));
    }

    @Test
    public void shouldAllowDecimal() {
        assertTrue(InputValidator.validateTextInput("34.02"));
    }

    @Test
    public void shouldAllowSimpleNumber() {
        assertTrue(InputValidator.validateTextInput("34"));
    }

    @Test
    public void shouldDisallowSpecialChars() {
        assertFalse(InputValidator.validateTextInput("%@$"));
    }

    @Test
    public void shouldValidateIdNumberAccordingToCategoryTypes() {
        assertTrue(InputValidator.validateCategoryMenuInput("10"));
    }

    @Test
    public void shouldValidateIdNumberAccordingToRepoEntries() {
        Map<Long, Product> repoMock;
        ProductRepository victim;
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);
        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        assertTrue(InputValidator.validateProductIdAllRange("1", victim));
    }

    @Test
    public void shouldFailValidateIdNumberAccordingToRepoEntries() {
        Map<Long, Product> repoMock;
        ProductRepository victim;
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);
        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        assertFalse(InputValidator.validateProductIdAllRange("4", victim));
    }

    @Test
    public void shouldValidateIdNumberAccordingToRepoEntriesInSpecificCategory() {
        Map<Long, Product> repoMock;
        ProductRepository victim;
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);
        orange.setCategory(ProductCategory.FRUIT);
        fish.setCategory(ProductCategory.FISH);
        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        assertTrue(InputValidator.validateProductIdWithinCategoryRange("1", victim, ProductCategory.FRUIT));
    }

    @Test
    public void shouldFailValidateIdNumberAccordingToRepoEntriesInSpecificCategory() {
        Map<Long, Product> repoMock;
        ProductRepository victim;
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);
        orange.setCategory(ProductCategory.FRUIT);
        fish.setCategory(ProductCategory.FISH);
        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        assertFalse(InputValidator.validateProductIdWithinCategoryRange("1", victim, ProductCategory.FISH));
    }
}