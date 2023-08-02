package org.bancoldex.adapter.out.persistence;

import org.bancoldex.application.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
class ProductMapper {


    Product mapToDomainEntity(
            ProductJpaEntity product
           ) {

//        Money baselineBalance = Money.subtract(
//                Money.of(depositBalance),
//                Money.of(withdrawalBalance));

        return Product.withId(
                new Product.ProductId(product.getId()),
                product.getTipoprodActivos(),
                product.getEstado(),
                product.getNoObligacion(),
                product.getSaldo(),
                product.getFechaproxpago(),
                product.getPlataformaexistente());


    }

    public ProductJpaEntity mapToJpaEntity(Product product) {
        return new ProductJpaEntity(
                product.getId() == null ? null : product.getId().get().getValue(),
               product.getTipoProdActivos(),
                product.getEstado(),
                product.getNoObligacion(),
                product.getSaldo(),
                product.getFechaproxpago(),
                product.getPlataformaExistente());


    }
}
