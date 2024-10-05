import java.util.Scanner;

public class AnalizadorTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un texto para analizar:");
        String texto = scanner.nextLine().toLowerCase();

        final int cantidad_letras = 26;
        
        int[] frecuencia = new int[cantidad_letras];
        int totalLetras = 0;
        int totalPalabras = 0;
        int totalVocales = 0;

        int tamaño_texto = texto.length();
        
        for (int i = 0; i < tamaño_texto; i++) {
            char c = texto.charAt(i);
            if (c >= 'a' && c <= 'z') {
                frecuencia[c - 'a']++;
                totalLetras++;
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    totalVocales++;
                }
            } else if (c == ' ' && i > 0 && texto.charAt(i - 1) != ' ') {
                totalPalabras++;
            }
        }
        totalPalabras++; // Contar la última palabra

        System.out.println("Análisis del texto:");
        System.out.println("Total de letras: " + totalLetras);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de vocales: " + totalVocales);
        System.out.println("Frecuencia de letras:");
        for (int i = 0; i < cantidad_letras; i++) {
            if (frecuencia[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + frecuencia[i]);
            }
        }

        scanner.close();
    }
}

