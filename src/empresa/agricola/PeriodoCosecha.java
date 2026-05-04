package empresa.agricola;

public class PeriodoCosecha {
    private String NombrePeriodo;
    private double CantidadToneladas;
    private int TiempoCosecha;

    public PeriodoCosecha(String nombrePeriodo, double cantidadToneladas, int TiempoCosecha) {
        if (TiempoCosecha < 1 || TiempoCosecha > 6) {
            throw new IllegalArgumentException("Tiempo de cosecha debe ser entre 1 y 6");
        }

        if (cantidadToneladas < 0.5 || cantidadToneladas > 200) {
            throw new IllegalArgumentException("Cantidad de toneladas fuera de rango");
        }

        this.NombrePeriodo = nombrePeriodo;
        this.CantidadToneladas = cantidadToneladas;
        this.TiempoCosecha = TiempoCosecha;
    }

    public String getNombrePeriodo() {
        return NombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        NombrePeriodo = nombrePeriodo;
    }

    public double getCantidadToneladas() {
        return CantidadToneladas;
    }

    public void setCantidadToneladas(double cantidadToneladas) {
        CantidadToneladas = cantidadToneladas;
    }

    public int getTiempoCosecha() {
        return TiempoCosecha;
    }

    public void setTiempoCosecha(int tiempoCosecha) {
        TiempoCosecha = tiempoCosecha;
    }

    public double ProduccionTotal(double Hectareas) {
        return CantidadToneladas*Hectareas;

    }
    public double CostoProduccion(double Hectareas, double CostoTonleadas){
        return ProduccionTotal(Hectareas)*CostoTonleadas;
    }

    public double gananciaTotal(double Hectareas,double CostoToneladas, double precioVenta){
        double produccion=ProduccionTotal(Hectareas);
        return (produccion*precioVenta)- (produccion*CostoToneladas);
    }

    @Override
    public String toString() {
        return "PeriodoCosecha{" +
                "NombrePeriodo='" + NombrePeriodo + '\'' +
                ", CantidadToneladas=" + CantidadToneladas +
                ", TiempoCosecha=" + TiempoCosecha +
                '}';
    }
}
