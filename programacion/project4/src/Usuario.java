public sealed class Usuario permits Administrador {
    protected String nombre;

    public Usuario(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {return nombre;}

}
