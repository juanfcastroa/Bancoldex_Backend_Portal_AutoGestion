package org.bancoldex.application.domain.model;


import lombok.Builder;
import lombok.Getter;


import java.util.Date;
import java.util.List;


@Getter
public class ProductosActivos extends Product {


    @Builder
    public ProductosActivos(ProductId id,org.bancoldex.application.domain.model.TipoProdActivos tipprodActivos, org.bancoldex.application.domain.model.Estado estado, Long noObligacion, Long saldo, Date fechaproxpago, boolean plataformaExistente, List<Product> productos) {
        super(id, tipprodActivos, estado, noObligacion, saldo, fechaproxpago, plataformaExistente, productos);
    }
}
