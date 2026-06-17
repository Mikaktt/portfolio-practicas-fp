public sealed class Pelicula extends ContenidoAudiovisual permits PeliculaPremium{
    private String titulo;
    private String director;
    private int duracion;
    private int valoracion;
    Genero genero;

    public Pelicula(String titulo, String director, int duracion, int valoracion, Genero genero) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.valoracion = valoracion;
        this.genero = genero;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }


    public void mostrarInfo(){
        System.out.println("Titulo: " + titulo + " \nDirector: " + director + "\nDuracion(minutos): " + duracion + "\nValoracion: " + valoracion + "\nGenero: " + genero);
    }

    public void mejorarValoracion(int puntos){
        this.valoracion += puntos;
    }

    public void mejorarValoracion(int puntos, int bonus){
        this.valoracion += (puntos + bonus);
    }


    @Override
    public void reproducir() {
        System.out.println("Reproduciendo pelicula... " + titulo);
    }
}
