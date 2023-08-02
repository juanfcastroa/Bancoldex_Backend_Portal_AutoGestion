package org.bancoldex.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.bancoldex.application.domain.model.Product;
import org.bancoldex.application.port.out.InsertProductPort;
import org.bancoldex.application.port.out.LoadProductPort;
import org.bancoldex.common.PersistenceAdapter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@PersistenceAdapter
public class ProductPersistenceAdapter implements LoadProductPort, InsertProductPort {

    private final SpringDataProductRepository productRepository;

    private final ProductMapper productMapper;
    @Override
    public void insertProduct(Product product) {

        productRepository.save(productMapper.mapToJpaEntity(product));
    }

    @Override
    public Product loadProduct(Product.ProductId accountId, LocalDateTime baselineDate) {

        return null;
    }

    @Override
    public List<Product> loadProducts() {
        List<ProductJpaEntity> jpaProductEntities= productRepository.findAll();
        List<Product> Products= new ArrayList<>();
        for (ProductJpaEntity jpaProductEntity : jpaProductEntities) {
            Product product = productMapper.mapToDomainEntity(jpaProductEntity);
            Products.add(product);
        }
        return Products;
    }
}
