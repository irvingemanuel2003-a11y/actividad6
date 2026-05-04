package Observatorio;

import java.util.ArrayList;
import java.util.Objects;

public class CuerposCelestes implements Comparable<CuerposCelestes> {
    private String Nombre;
    private String  Composicion;
    private double DistanciaTierra;
    private String UnidadTierra;
    private ArrayList<PeriodoVisible> Periodos;

    public CuerposCelestes(String nombre, String composicion, double distanciaTierra, String unidadTierra, ArrayList<PeriodoVisible> periodos) {
        Nombre = nombre;
        Composicion = composicion;
        DistanciaTierra = distanciaTierra;
        UnidadTierra = unidadTierra;
        Periodos = periodos;

        if (distanciaTierra < 0) {
            throw new IllegalArgumentException("Distancia inválida");
        }

        if (periodos == null) {
            throw new NullPointerException("La lista de periodos no puede estar vacía");
        }
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getComposicion() {
        return Composicion;
    }

    public void setComposicion(String composicion) {
        Composicion = composicion;
    }

    public double getDistanciaTierra() {
        return DistanciaTierra;
    }

    public void setDistanciaTierra(double distanciaTierra) {
        DistanciaTierra = distanciaTierra;
    }

    public String getUnidadTierra() {
        return UnidadTierra;
    }

    public void setUnidadTierra(String unidadTierra) {
        UnidadTierra = unidadTierra;
    }

    public ArrayList<PeriodoVisible> getPeriodos() {
        return Periodos;
    }

    public void agregarPeriodo(PeriodoVisible p){
        if (p == null) {
            throw new NullPointerException("No se puede agregar un periodo vacío");
        }
        Periodos.add(p);
    }
    public void eliminarPeriodo(PeriodoVisible p){
        Periodos.remove(p);
    }
    @Override
    public int compareTo(CuerposCelestes c) {
        return Double.compare(this.getDistanciaTierra(), c.getDistanciaTierra());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CuerposCelestes)) return false;
        CuerposCelestes c = (CuerposCelestes) obj;
        return Nombre.equals(c.Nombre);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Nombre);
    }

    @Override
    public String toString() {
        return "cuerposCelestes{" +
                "Nombre='" + Nombre + '\'' +
                ", Composicion='" + Composicion + '\'' +
                ", DistanciaTierra=" + DistanciaTierra +
                ", UnidadTierra='" + UnidadTierra + '\'' +
                '}';
    }
}
