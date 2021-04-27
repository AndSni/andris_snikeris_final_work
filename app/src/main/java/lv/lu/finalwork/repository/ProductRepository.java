package lv.lu.finalwork.repository;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class ProductRepository implements Repository<Product> {

    private Long idCounter = 0L;

    public  Map<Long, Product> repository = new HashMap<>();


    @Override
    public Long save(Product entity) {
        idCounter += 1;
        entity.setId(idCounter);
        repository.put(idCounter, entity);
        return idCounter;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(repository.values());
    }

    @Override
    public Product findById(Long id) {
        return repository.get(id);
    }

    @Override
    public void delete(Long id) {
        repository.remove(id);
    }

    public List<Product> findByCategory(ProductCategory category) {
        List<Product> result = new ArrayList<Product>();
        for (Product product : repository.values()) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

    public void update(Long id, Product product) {
        repository.replace(id, product);
    }

    public void setIdCounter(Long idCounter) {
        this.idCounter = idCounter;
    }
}
