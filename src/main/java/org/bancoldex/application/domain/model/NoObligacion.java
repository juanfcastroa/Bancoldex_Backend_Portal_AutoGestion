package org.bancoldex.application.domain.model;

public class NoObligacion {


    private Long noObligacion;


    public NoObligacion(Long noobligacion) {

        if(noobligacion !=null)
            {

                //this.noObligacion = "***"+codOperacion.substring(codOperacion.length() - 5);
                this.noObligacion =noobligacion;
            }
        else
        {
            throw new IllegalArgumentException(
                    " Código de  la obligación es null ");

        }



    }


    public static NoObligacion fromNoObligacion(Long noObligacion){
        return new NoObligacion(noObligacion);
    }
}
