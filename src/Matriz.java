import java.text.DecimalFormat;
import java.util.Scanner;

public class Matriz {

    public Matriz() {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        int[][] numeros = new int[3][2];

        numeros[0][0] = 5;

        // Popular valores:

        for (int linha = 0; linha < numeros.length; linha++) {
            for (int coluna = 0; coluna < numeros[linha].length; coluna++) {
                System.out.println("Número[" + linha + "][" + coluna + "]: ");
                numeros[linha][coluna] = entrada.nextInt();
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[0].length; j++) {
                System.out.print(numeros[i][j] + " ");
            }
            System.out.println("");
        }

        entrada.close();
    }

    public static void main(String[] args) {
        new Matriz();
    }

}
