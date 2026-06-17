import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Gimnasio {
    ArrayList<Socio> socios;
    HashSet<String> codigosSocio;
    HashMap<Socio, ArrayList<String>> historialReservas;
    private int[][] actividades;

    public Gimnasio() {
        socios = new ArrayList<>();
        codigosSocio = new HashSet<>();
        historialReservas = new HashMap<>();
    }

    public boolean addSocio(Socio socio){
        if(codigosSocio.contains(socio.getCodigoSocio())){
            return false;
        }
        socios.add(socio);
        codigosSocio.add(socio.getCodigoSocio());
        historialReservas.put(socio, new ArrayList<>());
        return true;
    }

    public boolean registrarReserva(String codigoSocio, String descripcion){
        Socio encontrado = null;

        for(Socio s : socios){
            if(s.getCodigoSocio().equals(codigoSocio)){
                encontrado = s;
                break;
            }
        }
        if(encontrado == null){
            return false;
        }

        historialReservas.get(encontrado).add(descripcion);
        return true;
    }

    public void mostrarHistorialReservas(String codigoSocio){
        Socio encontrado = null;
        for(Socio s : socios){
            if(s.getCodigoSocio().equals(codigoSocio)){
                encontrado = s;
                break;
            }
        }
        if(encontrado == null){
            System.out.println("No existe un socio con ese codigo");
            return;
        }

        System.out.println("Historial de " + encontrado.getNombre() + ": ");
        for(String reserva : historialReservas.get(encontrado)){
            System.out.println("- " + reserva);
        }
    }


    public Socio[] obtenerRanking(){
        Socio[] ranking = socios.toArray(new Socio[0]);

        Arrays.sort(ranking, (s1, s2) -> Integer.compare(s2.getPuntosActividad(), s1.getPuntosActividad()));
        return ranking;
    }

    public Socio buscarSocioPorCodigo(String codigoBuscado){
        for(Socio s : socios){
            if(s.getCodigoSocio().equals(codigoBuscado)){
                return s;
            }
        }
        return null;
    }

    private void actualizarMatrizActividades(){
        int filas = socios.size();
        int colmnas = 12;
        actividades = new int[filas][colmnas];
    }

    public void registrarActividadMensual(String codigoSocio, int mes, int puntos){
        Socio socio = buscarSocioPorCodigo(codigoSocio);

        if(socio == null){
            System.out.println("No existe un socio con ese codigo");
            return;
        }
        int fila = socios.indexOf(socio);
        actividades[fila][mes] += puntos;
    }

}
