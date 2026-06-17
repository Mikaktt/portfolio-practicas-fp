public non-sealed class Socio extends Usuario{
    private String nombre;
    private String codigoSocio;
    private int edad;
    private int puntosActividad;
    CategoriaSocio categoriaSocio;

    public Socio(String nombre, String codigoSocio, int edad, int puntosActividad, CategoriaSocio categoriaSocio) {
        this.nombre = nombre;
        this.codigoSocio = codigoSocio;
        this.edad = edad;
        this.puntosActividad = puntosActividad;
        this.categoriaSocio = categoriaSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(String codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntosActividad() {
        return puntosActividad;
    }

    public void setPuntosActividad(int puntosActividad) {
        this.puntosActividad = puntosActividad;
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " + nombre + "\nCodigoSocio: " + codigoSocio + "\nEdad: " + edad + "\npuntosActividad: " + puntosActividad
        + "\nCategoria Socio: " + categoriaSocio);
    }

    public void sumarPuntos(int puntos){
        puntosActividad += puntos;
    }

    public void sumarPuntos(int puntos, int bonus){
        puntosActividad += puntos + bonus;
    }

    @Override
    public void realizarActividad() {

    }
}
