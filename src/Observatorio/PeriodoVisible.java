package Observatorio;

import java.util.Arrays;
import java.util.List;

public class PeriodoVisible {
    private String Periodo;
    private UbicacionEspacial Ubicacion;

    public PeriodoVisible(String periodo, UbicacionEspacial ubicacion) {
        Periodo = periodo;
        Ubicacion = ubicacion;

        List<String> meses = Arrays.asList(
                "Enero","Febrero","Marzo","Abril","Mayo","Junio",
                "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"
        );

        if (!meses.contains(periodo)) {
            throw new IllegalArgumentException("El mes ingresado no es válido");
        }

        if (ubicacion == null) {
            throw new NullPointerException("La ubicación es obligatoria para crear el periodo");
        }
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String periodo) {
        Periodo = periodo;
    }

    public UbicacionEspacial getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(UbicacionEspacial ubicacion) {
        Ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "periodoVisible{" +
                "periodo='" + Periodo + '\'' +
                ", ubicacion=" + Ubicacion +
                '}';
    }
}
