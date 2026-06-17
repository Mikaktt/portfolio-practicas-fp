public class Analisis {
    public static double calcularPromedio(int... valores){
        if(valores.length == 0)
            return 0;

        int suma = 0;
        for(int v : valores){
            suma += v;
        }
        return (double) suma / valores.length;
    }
}
