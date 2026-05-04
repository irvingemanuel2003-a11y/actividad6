package Fabrica.Ropa;

import java.util.Objects;

public class Prenda implements Comparable<Prenda> {
        private String Modelo;
        private String Tela;
        private double PrecioVentaPZ;
        private double PrecioVentaLote;
        private String Genero;
        private String Temporada;

    public Prenda(String modelo, String tela, double precioVentaPZ, double precioVentaLote, String genero, String temporada) {
            if (!(genero.equalsIgnoreCase("Masculino") ||
                    genero.equalsIgnoreCase("Femenino") ||
                    genero.equalsIgnoreCase("Mixto"))) {
                throw new IllegalArgumentException("Genero inválido");
            }

            if (!(temporada.equalsIgnoreCase("Primavera") ||
                    temporada.equalsIgnoreCase("Verano") ||
                    temporada.equalsIgnoreCase("Otoño") ||
                    temporada.equalsIgnoreCase("Invierno"))) {
                throw new IllegalArgumentException("Temporada inválida");
            }

            if (precioVentaPZ < 0 || precioVentaLote < 0) {
                throw new IllegalArgumentException("Precios negativos no permitidos");
            }


            this.Modelo = modelo;
            this.Tela = tela;
            this.PrecioVentaPZ = precioVentaPZ;
            this.PrecioVentaLote = precioVentaLote;
            this.Genero = genero;
            this.Temporada = temporada;
        }

        public String getModelo() {
            return Modelo;
        }

        public void setModelo(String modelo) {
            Modelo = modelo;
        }

        public String getTela() {
            return Tela;
        }

        public void setTela(String tela) {
            Tela = tela;
        }

        public String getGenero() {
            return Genero;
        }

        public void setGenero(String genero) {
            Genero = genero;
        }

        public String getTemporada() {
            return Temporada;
        }

        public void setTemporada(String temporada) {
            Temporada = temporada;
        }

        public double precioVentaPZ() {
            return PrecioVentaPZ * 1.15;
        }

        public double precioventaLote() {
            return PrecioVentaPZ * 1.05;
        }
        @Override
        public int compareTo(Prenda p) {
            return Double.compare(this.precioVentaPZ(), p.precioVentaPZ());
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Prenda)) return false;
            Prenda p = (Prenda) obj;
            return Modelo.equals(p.Modelo);
        }
        @Override
        public int hashCode() {
            return Objects.hash(Modelo);
        }


        @Override
        public String toString() {
            return "prenda{" +
                    "modelo='" + Modelo + '\'' +
                    ", Tela='" + Tela + '\'' +
                    ", precioventaPZ=" + PrecioVentaPZ +
                    ", precioVentaLote=" + PrecioVentaLote +
                    ", genero='" + Genero + '\'' +
                    ", temporada='" + Temporada + '\'' +
                    '}';
        }
}
