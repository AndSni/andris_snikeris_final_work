package lv.lu.finalwork.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T> extends Serializable {

    Long save(T entity);

    List<T> findAll();

    //Optional<T> findById(Long id);
T findById(Long id);

    void delete(Long id);

}
