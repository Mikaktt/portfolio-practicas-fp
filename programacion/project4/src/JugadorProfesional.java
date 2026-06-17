public final class JugadorProfesional extends Jugador{

    private String equipo;

    public JugadorProfesional(String nickname, String nombre, int edad, int puntuacion, Categoria categoria,String equipo) {
        super(nickname, nombre, edad, puntuacion,  categoria);
        this.equipo = equipo;
    }

    @Override
    public void jugar() {
        super.jugar();
    }
}
