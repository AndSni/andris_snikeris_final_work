package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.ui.renders.RenderList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class RenderListTest {


    @InjectMocks
    private ProductRepository victim;
    @Mock
    private Map<Long, Product> repoMock;


    @Test
    public void RenderListShouldPrintList(){
        Product orange = new Product();
        orange.setId(1L);
        orange.setCategory(ProductCategory.FRUIT);
        orange.setName("Orange");
        orange.setPrice(new BigDecimal("2.80"));
        orange.setDiscount(new BigDecimal("5"));
        orange.setDescription("Very tasty oranges from arctic circle");

        Product fish = new Product();
        fish.setId(2L);
        fish.setCategory(ProductCategory.FISH);
        fish.setName("Fish");
        fish.setPrice(new BigDecimal("9.80"));
        fish.setDiscount(new BigDecimal("9"));
        fish.setDescription("Fish from Arizona desert");

        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

RenderList renderList = new RenderList();
renderList.render(victim.findAll());

    }

    @Test
    public void RenderShouldReturnOnlyOneCategory(){
        Product orange = new Product();
        orange.setId(1L);
        orange.setCategory(ProductCategory.FRUIT);
        orange.setName("Orange");
        orange.setPrice(new BigDecimal("2.80"));
        orange.setDiscount(new BigDecimal("5"));
        orange.setDescription("Very tasty oranges from arctic circle");

        Product fish = new Product();
        fish.setId(2L);
        fish.setCategory(ProductCategory.FISH);
        fish.setName("Fish");
        fish.setPrice(new BigDecimal("9.80"));
        fish.setDiscount(new BigDecimal("9"));
        fish.setDescription("Fish from Arizona desert");

        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        RenderList renderList = new RenderList();
        renderList.render(victim.findAll(), ProductCategory.FISH);

    }

}