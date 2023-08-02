package org.bancoldex.application.port.out;

import org.bancoldex.application.domain.model.Product;

public interface InsertProductPort {

    void insertProduct(Product product);
}
