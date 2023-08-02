package org.bancoldex.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
class ProductJpaEntity {

    @Id
    @GeneratedValue
    private Long id;


    @GeneratedValue
    private org.bancoldex.application.domain.model.TipoProdActivos tipoprodActivos;

    @GeneratedValue
    private org.bancoldex.application.domain.model.Estado estado;

    @GeneratedValue
    private Long noObligacion;

    @GeneratedValue
    private Long saldo;
    @GeneratedValue
    private Date fechaproxpago;


    @GeneratedValue
    private Boolean plataformaexistente;
}
