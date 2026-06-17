import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Cine implements Clasificable{
    private ArrayList<Pelicula> peliculas;
    private HashSet<String> titulosRegistrados;
    private HashMap<Pelicula, ArrayList<String>> proyecciones;
    private int[][] valoracionesPublico;

    public Cine(int numPeliculas, int sumSesiones) {
        this.titulosRegistrados = titulosRegistrados;
        this.peliculas = peliculas;
        this.proyecciones = proyecciones;

        this.valoracionesPublico = new int[numPeliculas][sumSesiones];
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }
    /*
    * Añadir pelicula
    * */

    public boolean addPelicula(Pelicula p){
        // evitar duplicados
        try{
            validarTitulo(p.getTitulo());
        }catch(TituloInvalidoException e){
           System.out.println("Error: " + e.getMessage());
           return false;
        }
        if(titulosRegistrados.contains(p.getTitulo())){
            System.out.println("Error: película existente");
            return false;
        }
        peliculas.add(p);
        titulosRegistrados.add(p.getTitulo());
        proyecciones.put(p, new ArrayList<>());

        System.out.println("Pelicula añadida correctamente");
        return true;
    }

    /*
    * Mostrar proyeccion
     */

    public void mostrarProyeccion(Pelicula p, String descripcion){
        if(!proyecciones.containsKey(p)){
            System.out.println("Error: la pelicula no está registrada");
            return;
        }
        proyecciones.get(p).add(descripcion);
        System.out.println("Proyeccion Registrada");
    }


    /*
    * Mostrar historial de proyecciones
    * */

    public void historialProyecciones(Pelicula p){
        if(!proyecciones.containsKey(p)){
            System.out.println("Error: la pelicula no existe en la base");
            return;
        }
        ArrayList<String> historial = proyecciones.get(p);

        if(historial.isEmpty()){
            System.out.println("No hay proyecciones registradas");
            return;
        }
        System.out.println("Historial de proyecciones de " + p.getTitulo() + " : ");
        for(String s : historial){
            System.out.println("- " + s);
        }
    }


    public void borrarProyeccion(Pelicula p, String descripcion){
        if(!proyecciones.containsKey(p)){
            System.out.println("Error: la pelicula no existe en la base");
            return;
        }
        ArrayList<String> lista = proyecciones.get(p);

        if(!lista.remove(descripcion)){
            System.out.println("No se ha encontrado");
        }else{
            System.out.println("Proyeccion Eliminada");
        }
    }


    public void removeFilm(Pelicula p){
        if(!peliculas.contains(p)){
            System.out.println("Error: la pelicula no existe en la base");
            return;
        }
        peliculas.remove(p);
        titulosRegistrados.remove(p.getTitulo());
        proyecciones.remove(p);
        System.out.println("Pelicula Eliminada");
    }


    public Pelicula[] generarRankingArray(){
        Pelicula[] array = new Pelicula[peliculas.size()];
        return peliculas.toArray(array);
    }

    public void ordenarRanking(Pelicula[] array){
        for(int i = 0; i < array.length -1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j].getValoracion() < array[j + 1].getValoracion()){
                    Pelicula temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public Pelicula buscarPorTitulo(Pelicula[] array, String titulo){
        for(int i = 0; i < array.length; i++){
            if(array[i].getTitulo().equalsIgnoreCase(titulo.trim())){
                return array[i];
            }
        }
        return null;
    }

    public void registarValoracion(int indicePelicula, int indiceSesion, int valor){
        try{
            valoracionesPublico[indicePelicula][indiceSesion] = valor;
            System.out.println("Valoración registrada");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: indice fuera de rango");
        }
    }

    public void mostrarMediaValoraciones(){
        for(int i = 0; i < valoracionesPublico.length; i++){
            int suma = 0;
            int sesiones = valoracionesPublico.length;
            for(int j = 0; j < sesiones; j++){
                suma += valoracionesPublico[i][j];
            }

            double media = (double) suma / sesiones;
            System.out.println("Media de la pelicula " + i + ": " + media);
        }
    }

    public void validarTitulo(String titulo) throws TituloInvalidoException{

        if(titulo == null || titulo.trim().isEmpty()){
            throw new TituloInvalidoException("El titulo no puede estar vacío");
        }
        if(titulo.length() < 1) {
            throw new TituloInvalidoException("El titulo debe tener al menos 2 caracteres");
        }
    }


    @Override
    public void calcularRanking() {
        Pelicula[] ranking = generarRankingArray();
        ordenarRanking(ranking);
        System.out.println("=== Ranking ===");
        for(int i = 0; i < ranking.length;i++){
            System.out.println((i+1)+ ", " + ranking[i].getTitulo() + ", " + ranking[i].getValoracion());
        }
    }
}
