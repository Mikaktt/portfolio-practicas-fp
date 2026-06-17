public final class PeliculaPremium extends Pelicula {

    private String plataformaExclusiva;


    public PeliculaPremium(String titulo, String director, int duracion, int valoracion, Genero genero,String plataformaExclusiva) {
        super(titulo, director, duracion, valoracion,genero);
        this.plataformaExclusiva = "PeliculaPremium";
    }

    public String getPlataformaExclusiva() {
        return plataformaExclusiva;
    }

    public void setPlataformaExclusiva(String plataformaExclusiva) {
        this.plataformaExclusiva = plataformaExclusiva;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo PELICULA PREMIUM en: " + plataformaExclusiva);
    }
}
