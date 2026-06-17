public class Utilidad {
    public static int sumaValoraciones(int[] array, int indice){
        if(indice == array.length){
            return 0;
        }
        return array[indice] + sumaValoraciones(array, indice + 1);
    }
}
