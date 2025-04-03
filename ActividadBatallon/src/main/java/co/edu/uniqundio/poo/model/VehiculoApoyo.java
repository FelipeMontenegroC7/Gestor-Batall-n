package co.edu.uniqundio.poo.model;

public class VehiculoApoyo extends Vehiculo {
    private TipoDeFuncion tipoDeFuncion;
    public VehiculoApoyo (int tipoDeFuncion, String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {

        super(id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
        this.tipoDeFuncion = TipoDeFuncion.valorATexto(tipoDeFuncion);
    }
    public void setTipoDeFuncion(int tipoDeFuncion) {
        this.tipoDeFuncion = TipoDeFuncion.valorATexto(tipoDeFuncion);
    }

    @Override
    public String toString() {
        return String.format("Vehiculo de Apoyo - Tipo de Funcion: %s, ID: %s, Modelo: %s, Año: %d, Km: %d, Estado: %s, Misiones: %d\n",
                tipoDeFuncion, id , modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
    }
}
