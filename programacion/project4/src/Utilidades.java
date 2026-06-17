public class Utilidades {

    public static double calcularMedia(int... puntos){
        int suma = 0;
        for(int p : puntos){
            suma += p;
        }
        return suma;
    }

    public static int sumaTotalPuntos(int[] array, int indice){
        if(indice == array.length){
            return 0;
        }
        return array[indice] + sumaTotalPuntos(array, indice + 1);
    }

}
