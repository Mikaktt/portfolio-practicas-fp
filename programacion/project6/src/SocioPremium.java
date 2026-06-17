public final class SocioPremium extends Socio{

    private int nivelPremium;

    public SocioPremium(String nombre, String codigoSocio, int edad, int puntosActividad,CategoriaSocio categoriaSocio,int nivelPremium) {
        super(nombre, codigoSocio, edad, puntosActividad,categoriaSocio);
        this.nivelPremium = nivelPremium;
    }

    @Override
    public void realizarActividad() {

    }
}
