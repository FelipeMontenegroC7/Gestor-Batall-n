package co.edu.uniqundio.poo.model;

public class Vehiculo {
    protected String id;
    protected String modelo;
    protected int anioFabricacion;
    protected int kilometraje;
    protected EstadoOperativo estadoOperativo;
    protected int misionesCompletadas;

    public Vehiculo(String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {
        this.id = id;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
        this.estadoOperativo = EstadoOperativo.valorATexto(estadoOperativo);
        this.misionesCompletadas = misionesCompletadas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public EstadoOperativo getEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(int estadoOperativo) {
        this.estadoOperativo = EstadoOperativo.valorATexto(estadoOperativo);
    }

    public int getMisionesCompletadas() {
        return misionesCompletadas;
    }

    public void setMisionesCompletadas(int misionesCompletadas) {
        this.misionesCompletadas = misionesCompletadas;
    }

    public String toString() {
        return String.format("ID: %s, Modelo: %s, Año: %d, Km: %d, Estado: %s, Misiones: %d\n",
                id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
    }

}
