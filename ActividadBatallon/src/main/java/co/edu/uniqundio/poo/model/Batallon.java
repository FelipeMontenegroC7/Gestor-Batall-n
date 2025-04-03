package co.edu.uniqundio.poo.model;
import java.util.ArrayList;
import java.util.List;

public class Batallon {
    private String numeroBatallon;
    private List<Vehiculo> listaVehiculos;
    private List<Mision> listaMisiones;

    public Batallon(String numeroBatallon) {
        this.numeroBatallon = numeroBatallon;
        this.listaVehiculos = new ArrayList<>();
        this.listaMisiones = new ArrayList<>();
    }

    public String registrarVehiculo(int tipoVehiculo, int extra, String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {
        String mensaje = "";
        switch (tipoVehiculo) {
            case 1:
                Vehiculo nuevoVehiculo = null;
                nuevoVehiculo = buscarVehiculo(id);
                if (nuevoVehiculo == null) {
                    nuevoVehiculo = new TransporteTropas(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                    listaVehiculos.add(nuevoVehiculo);
                    mensaje = "Vehiculo de Tropas registrado correctamente";
                }else{
                    mensaje = "Vehiculo ya existe en la lista de vehiculos";
                }
                break;
            case 2:
                Vehiculo nuevoVehiculo1 = null;
                nuevoVehiculo1 = buscarVehiculo(id);
                if (nuevoVehiculo1 == null) {
                    nuevoVehiculo1 = new VehiculoBlindado(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                    listaVehiculos.add(nuevoVehiculo1);
                    mensaje = "Vehiculo de Blindado registrado correctamente";
                }else{
                    mensaje = "Vehiculo ya existe en la lista de vehiculos";
                }
                break;
            case 3:
                Vehiculo nuevoVehiculo2 = null;
                nuevoVehiculo2 = buscarVehiculo(id);
                if (nuevoVehiculo2 == null) {
                    nuevoVehiculo2 = new VehiculoApoyo(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                    listaVehiculos.add(nuevoVehiculo2);
                    mensaje = "Vehiculo de apoyo registrado correctamente";
                }else{
                    mensaje = "Vehiculo ya existe en la lista de vehiculos";
                }
                break;
            default:
                mensaje = "Tipo de Vehiculo no existe";
        }
        return mensaje;
    }

    public String editarVehiculo(String id, int tipoVehiculo, int extra, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas){
        String mensaje = "";
        Vehiculo vehiculoEditar = null;
        vehiculoEditar = buscarVehiculo(id);
        if (vehiculoEditar == null) {
            mensaje = "Vehiculo no existe";
        }else{
            switch (tipoVehiculo) {
                case 1:
                    //Aquí hago un cast del VehiculoEditar a TransporteTropas
                    ((TransporteTropas) vehiculoEditar).setCapacidadSoldadosTransportados(extra);
                    vehiculoEditar.setId(id);
                    vehiculoEditar.setModelo(modelo);
                    vehiculoEditar.setAnioFabricacion(anioFabricacion);
                    vehiculoEditar.setKilometraje(kilometraje);
                    vehiculoEditar.setEstadoOperativo(estadoOperativo);
                    vehiculoEditar.setMisionesCompletadas(misionesCompletadas);
                    mensaje = "Vehiculo de transporte de tropas editado correctamente";
                    break;
                case 2:
                    //Aquí hago un cast del VehiculoEditar a Vehiculo Blindado
                    ((VehiculoBlindado) vehiculoEditar).setNivelBlindaje(extra);
                    vehiculoEditar.setId(id);
                    vehiculoEditar.setModelo(modelo);
                    vehiculoEditar.setAnioFabricacion(anioFabricacion);
                    vehiculoEditar.setKilometraje(kilometraje);
                    vehiculoEditar.setEstadoOperativo(estadoOperativo);
                    vehiculoEditar.setMisionesCompletadas(misionesCompletadas);
                    mensaje = "Vehiculo Blindado editado correctamente";
                    break;
                case 3:
                    //Aquí hago un cast del VehiculoEditar a Vehiculo de Apoyo
                    ((VehiculoApoyo) vehiculoEditar).setTipoDeFuncion(extra);
                    vehiculoEditar.setId(id);
                    vehiculoEditar.setModelo(modelo);
                    vehiculoEditar.setAnioFabricacion(anioFabricacion);
                    vehiculoEditar.setKilometraje(kilometraje);
                    vehiculoEditar.setEstadoOperativo(estadoOperativo);
                    vehiculoEditar.setMisionesCompletadas(misionesCompletadas);
                    mensaje = "Vehiculo de Apoyo editado correctamente";
                    break;
                default:
                    mensaje = "Ese Tipo de Vehiculo no existe";
            }
        }
        return  mensaje;
    }

    public String mostrarVehiculoPorID(String id) {
        String mensaje = "";
        Vehiculo vehiculoMostrar = null;
        vehiculoMostrar = buscarVehiculo(id);
        mensaje = vehiculoMostrar.toString();
        return mensaje;
    }

    public String mostrarListaVehciculos(){
        String mensaje = "";
        for(Vehiculo vehiculoAux : listaVehiculos){
            mensaje += vehiculoAux.toString();
        }
        return mensaje;
    }

    public String actualizarNumeroMisiones(String id, int numeroMisionesActualizada){
        String mensaje = "";
        Vehiculo vehiculoActualizarMisiones = null;
        vehiculoActualizarMisiones = buscarVehiculo(id);
        if  (vehiculoActualizarMisiones != null) {
            vehiculoActualizarMisiones.setMisionesCompletadas(numeroMisionesActualizada);
            mensaje = "Numero de misiones actualizado correctamente";
        }else{
            mensaje = "Id del vehiculo no encontrada";
        }
        return  mensaje;
    }
    public String actualizarEstadoOperativo(String id, int estadoOperativo){
        String mensaje = "";
        Vehiculo vehiculoActualizarEstadoOperativo = null;
        vehiculoActualizarEstadoOperativo = buscarVehiculo(id);
        if(vehiculoActualizarEstadoOperativo != null) {
            vehiculoActualizarEstadoOperativo.setEstadoOperativo(estadoOperativo);
            mensaje = "Estado Operativo actualizado correctamente";
        }else{
            mensaje = "Este ID de Vehiculo no existe";
        }
        return mensaje;
    }

    public String eliminarVehiculo(String id) {
        String mensaje = "";
        Vehiculo vehiculoEliminar = null;
        vehiculoEliminar = buscarVehiculo(id);
        if (vehiculoEliminar != null) {
            listaVehiculos.remove(vehiculoEliminar);
            mensaje = "Vehiculo eliminado correctamente";
        }else{
            mensaje  = "Vehiculo no existe para eliminar";
        }
        return  mensaje;
    }

    public String obtenerVehiculosMas50Misiones() {
        ArrayList<Vehiculo> vehiculosMas50Misiones = new ArrayList<>();
        for  (Vehiculo vehiculoAux : listaVehiculos) {
            if (vehiculoAux.getMisionesCompletadas() > 50) {
                vehiculosMas50Misiones.add(vehiculoAux);
            }
        }
        String resultado = "";
        resultado += vehiculosMas50Misiones.toString();
        return resultado;
    }

    public String registrarMision(String fechaMision, String ubicacionMision, int personalAsignado, int vehiculosUtilizados){
        String mensaje = "";
        Mision nuevoRegistroMision = new Mision(fechaMision, ubicacionMision, personalAsignado, vehiculosUtilizados);
        listaMisiones.add(nuevoRegistroMision);
        mensaje = "Registro de la misión exitoso";
        return  mensaje;
    }

    public String mostrarListaMisiones(){
        String mensaje = "";
        for(Mision misionAux : listaMisiones){
            mensaje = misionAux.toString();
        }
        return mensaje;
    }

    private Vehiculo buscarVehiculo(String id) {
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculoAux : listaVehiculos) {
            if (vehiculoAux.getId().equals(id)) {
                vehiculoEncontrado = vehiculoAux;
            }
        }
        return  vehiculoEncontrado;
    }


}
