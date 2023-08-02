package org.bancoldex.application.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.bancoldex.application.domain.model.Product;
import org.bancoldex.application.port.in.ProductCommand;
import org.bancoldex.application.port.in.ProductUseCase;
import org.bancoldex.application.port.out.InsertProductPort;
import org.bancoldex.application.port.out.LoadProductPort;
import org.bancoldex.common.UseCase;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@UseCase
@Transactional
public class ProductService implements ProductUseCase {
    private final LoadProductPort loadProductPort;
    private final InsertProductPort insertProductPort;

    @Override
    public boolean createProduct(ProductCommand command) {
        LocalDateTime baselineDate = LocalDateTime.now();
        Product product = loadProductPort.loadProduct(
                command.productId(),
                baselineDate);

        if (product == null) {
            product = Product.withId(command.productId(), command.tipoProdActivos(), command.estado(), command.nobligacion(), command.saldo(), command.fechaproxpago(), command.plataformaExistente());


//        Product.ProductId productId = product.getId()
//                .orElseThrow(() -> new IllegalStateException("product ID esperado no debe estar vacio"));
            insertProductPort.insertProduct(product);


        }
        return true;
    }

    @Override
    public List<Product> getProducts() {

       return  loadProductPort.loadProducts();

    }
}
