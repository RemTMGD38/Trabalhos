import java.util.Random;
import java.util.Scanner;

public class Main {
    public Main() {
        Scanner entrada = new Scanner(System.in);
        Random aleat = new Random();
        int[][] matriz1 = new int[8][8];
        int[][] matriz2 = new int[8][8];
        System.out.println("Digite o tipo de barco que voce deseja colocar: ");
        System.out.println("1.  Barco Pequeno (1 espaço)");
        System.out.println("2.  Barco Médio   (2 espaço)");
        System.out.println("3.  Barco Grande  (3 espaço)");
        int tipoBarco = tipoBarco(entrada);
        int linha = linha(entrada);
        int coluna = coluna(entrada);

        int tipoBarcoPC = aleat.nextInt(1, 3);
        int linhaPC = aleat.nextInt(8);
        int colunaPC = aleat.nextInt(8);

        definindoCasas(entrada, matriz1);

        int qtdBarco = 0;
        int qtdBarcoNova = 0;
        int qtdPC = 0;
        int qtdPCNova = 0;
        
        switch (tipoBarco) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    barco1(matriz1, linha, coluna, tipoBarco);
                }
                qtdBarco++;
                qtdBarcoNova++;
                break;

            case 2:
                for (int i = 0; i < 3; i++) {
                    barco2(matriz1, linha, coluna, tipoBarco);
                }
                qtdBarco++;
                qtdBarcoNova++;
                break;

            case 3:
                for (int i = 0; i < 3; i++) {
                    barco3(matriz1, linha, coluna, tipoBarco);
                }
                qtdBarco++;
                qtdBarcoNova++;
                break;

            default:
                break;
        }
        switch (tipoBarcoPC) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    barco1(matriz2, linhaPC, colunaPC, tipoBarcoPC);
                }
                qtdPC++;
                qtdPCNova++;
                break;

            case 2:
                for (int i = 0; i < 3; i++) {
                    barco2(matriz2, linhaPC, colunaPC, tipoBarcoPC);
                }
                qtdPC++;
                break;

            case 3:
                for (int i = 0; i < 3; i++) {
                    barco3(matriz2, linhaPC, colunaPC, tipoBarcoPC);
                }
                qtdPC++;
                break;

            default:
                break;
        }

        do {
            System.out.print("Insira onde você deseja procurar um barco inimigo: \nLinha: (0 a 7)");
            int misselL = entrada.nextInt();
            System.out.print("Coluna: (0 a 7)");
            int misselC = entrada.nextInt();
            qtdPCNova = procurarBarco(matriz2, misselL, misselC, qtdPCNova);
            if (qtdPC == qtdPCNova) {
            System.out.println("Você errou...");
            } else {
            System.out.println("Você acertou!");
            }
            int misselLPC = aleat.nextInt(8);
            int misselCPC = aleat.nextInt(8);
            qtdBarcoNova = procurarBarco(matriz1, misselLPC, misselCPC, qtdBarcoNova);
            qtdPC = qtdPCNova;
            qtdBarco = qtdBarcoNova;
        } while (qtdBarco>0 && qtdPC>0);

        espacoBranco();
        impressaoMatrizes(matriz1, matriz2);

    }
  // ----------------------------------------------------ENTRADAS NAVIOS----------------------------------------------------
    public int tipoBarco(Scanner entrada) {
        System.out.println("Tipo de barco: ");
        int tipoBarco = entrada.nextInt();
        return tipoBarco;
    }

    public int linha(Scanner entrada) {
        System.out.println("Linha: (0 a 7)");
        int linha = entrada.nextInt();
       
        return linha;
    }

    public int coluna(Scanner entrada) {
        System.out.println("Coluna: (0 a 7)");
        int coluna = entrada.nextInt();
        return coluna;
    }


    // ----------------------------------------------------DENIFINDO CASAS----------------------------------------------------
    public void definindoCasas(Scanner entrada, int[][] matriz1) {

        for (int i = 0; i < matriz1.length; i++)
        {
            for (int j = 0; j < matriz1[i].length; j++) {
                matriz1[i][j] = 0;
            }
        }
    }

    // ----------------------------------------------------IMPRESSAO MATRIZ1ES----------------------------------------------------

    public void impressaoMatrizes(int matriz2[][]) {
        for (int i = 0; i < matriz2.length; i++)

        {
            for (int j = 0; j < matriz2[i].length; j++) {
                if (matriz2[i][j]==1) {
                    System.out.print("\u001b[1;90m"+matriz2[i][j] + " "+"\u001b[0m"); // Isso aq ta colorido em cinza, tá nos exemplos postados no github da professora
                } else {
                    System.out.print("\u001b[1;34m"+"~ "+"\u001b[0m"); // e isso aq em azul, os dois depois setam pro padrão dnv pra n dar problema
                }
            }
            System.out.print("              ");
            for (int j = 0; j < matriz2[i].length; j++) {
                    System.out.print("~ ");
            }
            System.out.println();
        }
    }

    public void barco1(int matriz1[][], int linha, int coluna, int tipoBarco) {
        if (tipoBarco == 1) {
            matriz1[linha][coluna] = 1;
        }
    }

    public void barco2(int matriz1[][], int linha, int coluna, int tipoBarco) {
        if (tipoBarco == 2) {
            matriz1[linha][coluna] = 1;
            matriz1[linha][coluna + 1] = 1;
        }
    }

    public void barco3(int matriz1[][], int linha, int coluna, int tipoBarco) {
        if (tipoBarco == 3) {
            matriz1[linha][coluna] = 1;
            matriz1[linha][coluna + 1] = 1;
            matriz1[linha][coluna + 2] = 1;
        }
    }

    public int procurarBarco(int matriz2[][], int misselL, int misselC, int qtdBarcoNova) {
        int[][] matrizProcurar = new int[misselL][misselC];
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                if (matriz2[misselL][misselC] == 1) {
                    qtdBarcoNova-=1;
                    return qtdBarcoNova;
                }
            }
        }
        return -1;
    }

    public void espacoBranco(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public static void main(String[] args) {
        new Main();
    }
}
