package empresa.agricola;

import java.util.ArrayList;
import java.util.Objects;

public class Fruta implements Comparable<Fruta> {
    private String NombreFruta;
    private double Hectareas;
    private double CostoProduccionTon;
    private double PrecioVentaTon;
    private double LimiteHectareas;
    private ArrayList<PeriodoCosecha> Periodos;

    public Fruta(String nombreFruta, double hectareas, double costoProduccionTon, ArrayList<PeriodoCosecha> periodos, double precioVentaTon,  double limiteHectareas) {
        if (limiteHectareas > 10) {
            throw new IllegalArgumentException("El límite de hectáreas no puede ser mayor a 10");
        }

        if (hectareas < 0.5 || hectareas > limiteHectareas) {
            throw new IllegalArgumentException("Hectáreas fuera de rango");
        }

        if (costoProduccionTon < 0) {
            throw new IllegalArgumentException("Costo inválido");
        }

        if (precioVentaTon <= costoProduccionTon) {
            throw new IllegalArgumentException("El precio debe ser mayor al costo");
        }

        double margen = (precioVentaTon - costoProduccionTon) / costoProduccionTon * 100;

        if (margen < 5 || margen > 30) {
            throw new IllegalArgumentException("El margen debe estar entre 5% y 30%");
        }

        this.NombreFruta = nombreFruta;
        this.Hectareas = hectareas;
        this.CostoProduccionTon = costoProduccionTon;
        this.Periodos = periodos;
        this.PrecioVentaTon = precioVentaTon;
        this.LimiteHectareas = limiteHectareas;
    }

    public String getNombreFruta() {
        return NombreFruta;
    }

    public void setNombreFruta(String nombreFruta) {
        NombreFruta = nombreFruta;
    }

    public double getHectareas() {
        return Hectareas;
    }

    public void setHectareas(double hectareas) {
        Hectareas = hectareas;
    }

    public double getCostoProduccionTon() {
        return CostoProduccionTon;
    }

    public void setCostoProduccionTon(double costoProduccionTon) {
        CostoProduccionTon = costoProduccionTon;
    }

    public double getPrecioVentaTon() {
        return PrecioVentaTon;
    }

    public void setPrecioVentaTon(double precioVentaTon) {
        PrecioVentaTon = precioVentaTon;
    }

    public ArrayList<PeriodoCosecha> getPeriodos() {
        return Periodos;
    }

    public void agregarPeriodo(PeriodoCosecha p) {
        if (p == null) {
            throw new NullPointerException("El periodo de cosecha no puede ser nulo");
        }
        Periodos.add(p);
    }

    public void eliminarPeriodo(PeriodoCosecha periodo) {
        Periodos.remove(periodo);
    }

    public double totalProduccion() {
        double total = 0;
        for (PeriodoCosecha p : Periodos) {
            total += p.getCantidadToneladas();
        }
        return total;
    }

    @Override
    public int compareTo(Fruta f) {
        return this.NombreFruta.compareTo(f.NombreFruta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fruta)) return false;
        Fruta f = (Fruta) obj;
        return NombreFruta.equals(f.NombreFruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NombreFruta);
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "NombreFruta='" + NombreFruta + '\'' +
                ", Hectareas=" + Hectareas +
                ", CostoProduccionTon=" + CostoProduccionTon +
                ", PrecioVentaTon=" + PrecioVentaTon +
                '}';
    }
}
