package org.bancoldex.application.port.in;


import jakarta.validation.constraints.NotNull;
import org.bancoldex.application.domain.model.Estado;
import org.bancoldex.application.domain.model.Product.ProductId;
import org.bancoldex.application.domain.model.TipoProdActivos;

import java.util.Date;

import static org.bancoldex.common.validation.Validation.validate;
public record ProductCommand(
        @NotNull ProductId productId,
        @NotNull TipoProdActivos tipoProdActivos,
        @NotNull Estado estado,
        @NotNull Long nobligacion,
        @NotNull Long saldo,
        @NotNull Date fechaproxpago,
        @NotNull boolean plataformaExistente

) {

    public ProductCommand(
            ProductId productId,
            TipoProdActivos tipoProdActivos,
            Estado estado,
            Long nobligacion,
            Long saldo,
            Date fechaproxpago,
            boolean plataformaExistente
          ) {
        this.productId = productId;
        this.tipoProdActivos= tipoProdActivos;
        this.estado=estado;
        this.nobligacion = nobligacion;
        this.saldo = saldo;
        this.fechaproxpago=fechaproxpago;
        this.plataformaExistente= plataformaExistente;
        validate(this);
    }


}
