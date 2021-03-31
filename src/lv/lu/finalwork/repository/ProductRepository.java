package lv.lu.finalwork.repository;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductRepository implements Repository<Product>{

    private Long idCounter = 0L;
    private final Map<Long, Product> repository;

    public ProductRepository(Map<Long, Product> repository) {
        this.repository = repository;
    }

    @Override
    public Long save(Product entity) {
        idCounter += 1;
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

    public List<Product> findByCategory(ProductCategory category){
        List<Product> result = new ArrayList<Product>();
        for (Product product : repository.values()){
            if(product.getCategory() == category){
                result.add(product);
            }
        }
        return result;
    }
}
