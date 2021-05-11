package lv.lu.finalwork.service;

import lv.lu.finalwork.domain.Product;
import lv.lu.finalwork.domain.ProductCategory;
import lv.lu.finalwork.domain.ProductCrudRepository;
import lv.lu.finalwork.model.ProductData;
import lv.lu.finalwork.model.ProductInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProductService {


    private final ProductCrudRepository productRepository;

    @Autowired
    public ProductService(ProductCrudRepository productOrmRepository) {
        this.productRepository = productOrmRepository;
    }

    public void save(ProductInputData productInputData) {
        Product product = convertFrom(productInputData);
        productRepository.save(product);
    }

    public List<ProductData> findAll() {
        List<ProductData> result = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            result.add(covertFrom(product));
        }
        return result;
    }

    private ProductData covertFrom(Product product) {
        return new ProductData(
                product.getId().toString(),
                product.getName(),
                product.getPrice().toPlainString());
    }

    private Product convertFrom(ProductInputData productInputData) {
        Product product = new Product();
        product.setName(productInputData.getName());
        product.setPrice(BigDecimal.valueOf(productInputData.getPrice()));
        product.setCategory(ProductCategory.valueOf(productInputData.getCategory()));
        if (productInputData.getDiscount() != null) {
            product.setDiscount(BigDecimal.valueOf(productInputData.getDiscount()));
        }
        if (productInputData.getDescription() != null) {
            product.setDescription(productInputData.getDescription());
        }
        return product;
    }
}