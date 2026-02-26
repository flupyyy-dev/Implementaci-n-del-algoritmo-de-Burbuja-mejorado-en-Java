import java.util.Random;
import java.util.Arrays;

public class BubbleSortOptimizadoCompleto {

    static class Resultado {
        long tiempo;
        long comparaciones;
        long intercambios;

        Resultado(long tiempo, long comparaciones, long intercambios) {
            this.tiempo = tiempo;
            this.comparaciones = comparaciones;
            this.intercambios = intercambios;
        }
    }

    // Bubble Sort optimizado con marca de último intercambio
    public static Resultado bubbleSortOptimizado(int[] arr) {

        long comparaciones = 0;
        long intercambios = 0;

        int limite = arr.length - 1;

        long inicio = System.nanoTime();

        while (limite > 0) {
            int ultimoIntercambio = 0;

            for (int i = 0; i < limite; i++) {
                comparaciones++;

                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    intercambios++;
                    ultimoIntercambio = i;
                }
            }

            limite = ultimoIntercambio;
        }

        long fin = System.nanoTime();

        return new Resultado(fin - inicio, comparaciones, intercambios);
    }

    // Generar arreglo aleatorio
    public static int[] generarAleatorio(int tamaño) {
        Random rand = new Random();
        int[] arr = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    // Generar arreglo ordenado (mejor caso)
    public static int[] generarOrdenado(int tamaño) {
        int[] arr = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // Generar arreglo inverso (peor caso)
    public static int[] generarInverso(int tamaño) {
        int[] arr = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arr[i] = tamaño - i;
        }
        return arr;
    }

    // Ejecutar promedio de varias repeticiones
    public static Resultado ejecutarPromedio(int tamaño, String tipo) {

        int repeticiones = 5;
        long totalTiempo = 0;
        long totalComp = 0;
        long totalInter = 0;

        for (int i = 0; i < repeticiones; i++) {

            int[] arr;

            switch (tipo) {
                case "ORDENADO":
                    arr = generarOrdenado(tamaño);
                    break;
                case "INVERSO":
                    arr = generarInverso(tamaño);
                    break;
                default:
                    arr = generarAleatorio(tamaño);
            }

            Resultado r = bubbleSortOptimizado(arr);

            totalTiempo += r.tiempo;
            totalComp += r.comparaciones;
            totalInter += r.intercambios;
        }

        return new Resultado(
                totalTiempo / repeticiones,
                totalComp / repeticiones,
                totalInter / repeticiones
        );
    }

    public static void main(String[] args) {

        int[] tamaños = {1000, 2000, 5000, 10000};

        System.out.println("===== RESULTADOS PROMEDIO (5 EJECUCIONES) =====\n");

        System.out.println("Escenario,Tamaño,Tiempo(ns),Comparaciones,Intercambios");

        for (int tamaño : tamaños) {

            Resultado promedio = ejecutarPromedio(tamaño, "ALEATORIO");
            System.out.println("ALEATORIO," + tamaño + "," +
                    promedio.tiempo + "," +
                    promedio.comparaciones + "," +
                    promedio.intercambios);

            Resultado mejor = ejecutarPromedio(tamaño, "ORDENADO");
            System.out.println("ORDENADO," + tamaño + "," +
                    mejor.tiempo + "," +
                    mejor.comparaciones + "," +
                    mejor.intercambios);

            Resultado peor = ejecutarPromedio(tamaño, "INVERSO");
            System.out.println("INVERSO," + tamaño + "," +
                    peor.tiempo + "," +
                    peor.comparaciones + "," +
                    peor.intercambios);
        }
    }
}