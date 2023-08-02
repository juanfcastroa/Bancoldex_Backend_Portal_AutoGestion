package org.bancoldex.application.port.in;

import org.bancoldex.application.domain.model.Product;

import java.util.List;

public interface ProductUseCase {

    boolean createProduct(ProductCommand command);

    List<Product> getProducts();
}
