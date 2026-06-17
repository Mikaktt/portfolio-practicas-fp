import java.util.*;

public class Torneo implements Clasificable{
    ArrayList<Jugador> jugadores;
    HashSet<String> nicknames;
    HashMap<Jugador, ArrayList<String>> historial;
    private int[][] puntuaciones;


    public Torneo(){
        jugadores = new ArrayList<>();
        nicknames = new HashSet<>();
        historial = new HashMap<>();
    }

    /*/
    * Metodo añadir jugador
     */
    public boolean addJugador(Jugador jugador){
        //1. Comprobamos si nickname existe en el HashSet

        try{
            this.validarNickname(jugador.getNickname());
        } catch(NicknameInvalidoException e){
            System.out.println("Error al añadr jugador: " +e.getMessage());
            return false;
        }


        if(nicknames.contains(jugador.getNickname())){
            System.out.println("Error: el nickname: " + jugador.getNickname() + " ya existe");
            return false;
        }

        //2. Añadir jugador a la lista
        this.jugadores.add(jugador);

        //3. Registrar nickname el hashset
        this.nicknames.add(jugador.getNickname());

        //4. Crear historial vacio para este jugador
        this.historial.put(jugador, new ArrayList<>());

        System.out.println("Jugador añadido correctamente: " + jugador.getNickname());
        return true;
    }

    /*
    *
    * Metodo registrar partida
    * */

    public void registrarPartida(Jugador jugador, String descripcion){
        //1. Obtener la lista de partidas del jugador
        ArrayList<String> partidas = this.historial.get(jugador);

        //2. Comprobamos si existe en el historial
        if (partidas == null){
            System.out.println("Error, el jugador no está registrado en el torneo");
            return;
        }

        //3. Añadir la descripcion de la partida
        partidas.add(descripcion);
        System.out.println("Partida registrada para " + jugador.getNickname() + ": " + descripcion);
    }

    public void mostrarHistorial(){
        // Si no hay jugadores, no hay historial
        if(this.historial.isEmpty()){
            System.out.println("No existen partidas");
            return;
        }
        // Recorremos el HashMap
        for(Jugador jugador : this.historial.keySet()){
            System.out.println("Historial de " + jugador.getNickname() + " : ");
            ArrayList<String> partidas = this.historial.get(jugador);

            // Si el jugador no tiene partidas registradas
            if(partidas.isEmpty()){
                System.out.println("No existen partidas");
                continue;
            }
            for(String descripcion : partidas){
                System.out.println(" - " + descripcion);
            }
        }
    }


    public Jugador[] generarRankingArray(){
        return this.jugadores.toArray(new Jugador[0]);
    }

    public void ordenarRanking(Jugador[] ranking){
        Arrays.sort(ranking, (j1, j2) -> Integer.compare(j2.getPuntuacion(), j1.getPuntuacion()));
    }

    public Jugador buscarPorNickname(Jugador[] ranking, String nickname){
        for(int i = 0; i < ranking.length; i++){
            if(ranking[i].getNickname().equals(nickname)){
                return ranking[i];
            }
        }
        return null;
    }

    public void inicializarPuntuaciones(int rondas){
        this.puntuaciones = new int[this.jugadores.size()][rondas];
    }

    public void registrarPuntuacion(int jugadorIndex, int ronda, int puntos){
        try {
            this.puntuaciones[jugadorIndex][ronda] = puntos;
            System.out.println("Puntuacion registrada correctamente");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: indice fuera de rango al registrar puntuación.");
        }finally {
            System.out.println("Operacion de registro de puntuacion finalizada.");
        }
    }

    public void mostrarMediaPuntuacion(){
        for(int i = 0; i < this.jugadores.size(); i++){
            int suma = 0;
            for(int j = 0; j < this.puntuaciones[i].length; j++){
                suma += this.puntuaciones[i][j];
            }
            double media = (double) suma / this.puntuaciones[i].length;
            System.out.println("Media de " + this.jugadores.get(i).getNickname() + ": " + media);
        }
    }

    private void validarNickname(String nickname)throws NicknameInvalidoException{
        if(nickname == null || nickname.isEmpty()){
            throw new NicknameInvalidoException("El nickname no puede estar vacio");
        }
        if(nickname.length() < 3){
            throw new NicknameInvalidoException("El nickname debe tener mas de 3 caracteres");
        }
        if(nickname.contains(" ")){
            throw new NicknameInvalidoException("El nickname no puede contener espacios");
        }
    }

    @Override
    public void calcularRanking() {
        //1. Convertir lista a array
        Jugador[] ranking = this.generarRankingArray();

        //2. Ordena puntuacion
        this.ordenarRanking(ranking);

        //3. Mostrar Ranking
        System.out.println("=== RANKING DE JUGADORES ===");
        for(int i = 0; i < ranking.length;i++){
            System.out.println((i + 1) + ", " + ranking[i].getNickname() + " - Puntos: " + ranking[i].getPuntuacion());
        }
    }


    public void mostrarJugadoresConIterator(){
        Iterator<Jugador> it = this.jugadores.iterator();

        while(it.hasNext()){
            Jugador j = it.next();
            System.out.println(j.getNickname() + " - Puntos: " + j.getPuntuacion());
        }
    }

    public void ordenarJugadoresPorPuntuacion(){
        Collections.sort(this.jugadores,
                (j1,j2)->Integer.compare(j2.getPuntuacion(), j1.getPuntuacion()));
        System.out.println("Jugadores ordenador por puntuacion");
    }


}
