package lv.lu.finalwork.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class Product implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductCategory category;
    private BigDecimal discount;
    private String description;




}
