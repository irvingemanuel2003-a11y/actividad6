package Fabrica.Ropa;

import java.time.LocalDate;

public class Lote {
    private int NumDeLote;
    private int NumDePIezas;
    private LocalDate FechadeFabricacion;
    private double CostoProduccionPz;

    public Lote(int numDeLote, int numDePIezas, LocalDate fechadeFabricacion, double costoProduccionPz) {

        if (numDePIezas < 50 || numDePIezas > 350) {
            throw new IllegalArgumentException("Piezas deben estar entre 50 y 350");
        }

        if (costoProduccionPz < 0) {
            throw new IllegalArgumentException("Costo inválido");
        }

        this.NumDeLote = numDeLote;
        this.NumDePIezas = numDePIezas;
        this.FechadeFabricacion = fechadeFabricacion;
        this.CostoProduccionPz = costoProduccionPz;
    }

    public int getNumDeLote() {
        return NumDeLote;
    }

    public void setNumDeLote(int numDeLote) {
        NumDeLote = numDeLote;
    }

    public int getNumDePIezas() {
        return NumDePIezas;
    }

    public void setNumDePIezas(int numDePIezas) {
        NumDePIezas = numDePIezas;
    }

    public LocalDate getFechadeFabricacion() {
        return FechadeFabricacion;
    }

    public void setFechadeFabricacion(LocalDate fechadeFabricacion) {
        FechadeFabricacion = fechadeFabricacion;
    }

    public double getCostoProduccionPz() {
        return CostoProduccionPz;
    }

    public void setCostoProduccionPz(double costoProduccionPz) {
        CostoProduccionPz = costoProduccionPz;
    }

    public double costoProduccionLote(){
        return NumDePIezas*CostoProduccionPz;
    }
    public double calcularMontoRecuperacion(){

        if (CostoProduccionPz == 0) {
            throw new ArithmeticException("Costo no puede ser 0");
        }

        double precioVenta=CostoProduccionPz*1.15;
        return NumDePIezas*precioVenta;
    }

    @Override
    public String toString() {
        return "lote{" +
                "numDeLote=" + NumDeLote +
                ", numDePIezas=" + NumDePIezas +
                ", fechadeFabricacion=" + FechadeFabricacion +
                '}';
    }
}
