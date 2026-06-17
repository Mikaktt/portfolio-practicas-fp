
public sealed class Jugador extends Participante permits JugadorProfesional{

        private String nombre;
        private String nickname;
        private int edad;
        private int puntuacion;
        Categoria categoria;

        /*
        * Constructor clase Jugador
        * */
        public Jugador(String nickname, String nombre, int edad, int puntuacion, Categoria categoria) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.edad = edad;
        this.puntuacion = puntuacion;
        this.categoria = categoria;
    }

    /*/
    *
    * Getters y Setters
     */

        public Categoria getCategoria() {
                return categoria;
        }

        public void setCategoria(Categoria categoria) {
                this.categoria = categoria;
        }


        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getNickname() {
                return nickname;
        }

        public void setNickname(String nickname) {
                this.nickname = nickname;
        }

        public int getEdad() {
                return edad;
        }

        public void setEdad(int edad) {
                this.edad = edad;
        }

        public int getPuntuacion() {
                return puntuacion;
        }

        public void setPuntuacion(int puntuacion) {
                this.puntuacion = puntuacion;
        }

        /*
        *
        * Metodo mostrar info
        * */

        public void mostrarInfo(){
                System.out.println("Nombre: " + nombre + "\nNickname: " + nickname + "\nEdad: " + edad + "\nPuntuacion: " + puntuacion);
        }


        /*
        *Sobrecarga del metodo sumarPuntos.
         */
        public void sumarPuntuacion(int puntos){
                this.puntuacion += puntuacion;
        }

        public void sumarPuntuacion(int puntos, int bonus){
                this.puntuacion += puntuacion * bonus;
        }


        /**
         * Metodo abstracto heredado de participante.
         */

        @Override
        public void jugar() {
                System.out.println("Está jugando");
        }
}
