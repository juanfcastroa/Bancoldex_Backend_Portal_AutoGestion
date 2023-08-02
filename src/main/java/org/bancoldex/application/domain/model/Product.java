package org.bancoldex.application.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {



    /**
     * The unique ID of the product.
     */

    private final ProductId id;
    @Getter
    private org.bancoldex.application.domain.model.TipoProdActivos tipoProdActivos;
    @Getter
    private org.bancoldex.application.domain.model.Estado estado;
    @Getter
    private Long noObligacion;
    @Getter
    private Long saldo;
    @Getter
    private Date fechaproxpago;
    @Getter
    private Boolean plataformaExistente;
    @Getter
    private List<Product> productos;




//    public static Predicate<Product> getProductosActivosPredicate(ProductId idcliente) {
//        return r -> r.getProdActivos().equals(idcliente);
//
//
//    }

    public Optional<ProductId> getId(){
        return Optional.ofNullable(this.id);
    }

    /**
     * Creates an {@link Product} entity with an ID. Use to reconstitute a persisted entity.
     */
    public static Product withId(
            ProductId productId,
            org.bancoldex.application.domain.model.TipoProdActivos prodActivos,
            org.bancoldex.application.domain.model.Estado estado,
            Long noObligacion,
            Long saldo,
            Date fechaproxpago,
            Boolean plataformaExistente) {

        return new Product(productId, prodActivos,estado, noObligacion,saldo,fechaproxpago,plataformaExistente,null);

    }

    public boolean createProducto(Product producto) {
        return true;
    }
    @Value
    public static class ProductId {
        private Long value;
    }

    @Value
    public static class TipoProdActivos {
        public TipoProdActivos(org.bancoldex.application.domain.model.TipoProdActivos tipoprodActivos) {
        }
    }

    @Value
    public static class Estado {
        public Estado(org.bancoldex.application.domain.model.Estado estado) {
        }
    }

    @Value
    public static class NoObligacion {
        public NoObligacion(Long noObligacion) {
        }
    }
    @Value
    public static class Saldo {
        public Saldo(Long saldo) {
        }
    }

    @Value
    public static class FechaProxPago {
        public FechaProxPago(Date fechaproxpago) {
        }
    }


    @Value
    public static class PlataformaExistente {
        public PlataformaExistente(Boolean plataformaexistente) {
        }
    }
//
//    @Value
//    public static class TipoProdActivos {
//        private Product.TipoProdActivos value;
//    }
//
//
//    @Value
//    public static class Estado{
//        private Estado value;
//
//    }
//
//
//    @Value
//    public static class NoObligacion {
//        private Long value;
//    }
//
//    @Value
//    public static class Saldo {
//        private Long value;
//    }
//
//    @Value
//    public static class FechaProxPago {
//        private Date value;
//    }
//
//    @Value
//    public static class PlataformaExistente {
//        private Boolean value;
//    }
}



