package co.edu.uniqundio.poo.model;

public class Mision {
    private final String fechaMision;
    private final String ubicacionMision;
    private final int personalAsignado;
    private final int vehiculosUtilizados;

    public Mision(String fechaMision, String ubicacionMision, int personalAsignado, int vehiculosUtilizados) {
        this.fechaMision = fechaMision;
        this.ubicacionMision = ubicacionMision;
        this.personalAsignado = personalAsignado;
        this.vehiculosUtilizados = vehiculosUtilizados;
    }

    @Override
    public String toString() {
        return String.format("Misión - Fecha: %s, Ubicación: %s, Personal: %s, Vehículos: %s\n",
                fechaMision, ubicacionMision, personalAsignado, vehiculosUtilizados);
    }
}

