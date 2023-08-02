package org.bancoldex.application.port.out;

import org.bancoldex.application.domain.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface LoadProductPort {


    Product loadProduct(Product.ProductId accountId, LocalDateTime baselineDate);
    List<Product> loadProducts();
}
