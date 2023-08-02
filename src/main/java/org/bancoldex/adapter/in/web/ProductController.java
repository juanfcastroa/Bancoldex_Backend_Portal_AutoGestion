package org.bancoldex.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.bancoldex.application.domain.model.Estado;
import org.bancoldex.application.domain.model.Product;
import org.bancoldex.application.domain.model.TipoProdActivos;
import org.bancoldex.application.port.in.ProductCommand;
import org.bancoldex.application.port.in.ProductUseCase;
import org.bancoldex.common.WebAdapter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebAdapter
@RestController
@RequiredArgsConstructor
@Validated
class ProductController {

    private final ProductUseCase productUseCase;

    @PostMapping(path = "/products/create/{productId}/{noObligacion}/{saldo}/{fechaProxpago}/{plataformaExistente}")
    public void createProduct(
            @PathVariable("productId") Long productid,
            @PathVariable("noObligacion") Long noobligacion,
            @PathVariable("saldo") Long saldo,
            @PathVariable("fechaProxpago") String fechaproxpago,
            @PathVariable("plataformaExistente") Integer plataformaexistente
            ) {

        Date date1= null;
       boolean bool=false;

        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaproxpago);
            bool = (plataformaexistente != 0);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        ProductCommand command = new ProductCommand(new Product.ProductId(productid),TipoProdActivos.CREDITODIRECTO,Estado.ACTIVO,noobligacion,saldo,date1,bool );

        productUseCase.createProduct(command);
    }

    @GetMapping(path = "/products")
    public void getProducts() {


        productUseCase.getProducts();
    }

    @PostMapping(path = "/products/create/{productId}")
    public void createProduct(
            @PathVariable("productId") Long productid

    ) {
        Date date1= null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-10-22");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ProductCommand command = new ProductCommand(new Product.ProductId(productid), TipoProdActivos.CREDITODIRECTO, Estado.ACTIVO ,456L,5000L,date1,false );

        productUseCase.createProduct(command);
    }

    @GetMapping("/products/health")
    @ResponseBody
   public String health() {
        return "This is a test health !!";

    }

}
