import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {
    public BatalhaNaval() throws InterruptedException, IOException {
        Scanner entrada = new Scanner(System.in);
        Random aleat = new Random();
        int[][] matriz2 = new int[8][8];
        
        espacoBranco();
        System.out.println("O computador está posicionando seus navios...");

        int qtdPC = 0;
        int qtdPCNova = 0;
        int qtdJogadas = 0;

        qtdPCNova = barco(aleat, matriz2, qtdPCNova);
        qtdPC = qtdPCNova;

        System.out.println("Analise o mapa: ");
        impressaoMatrizes(matriz2, qtdPC, qtdPCNova);

        do {
            System.out.print("\nDiga onde você deseja procurar um barco inimigo: \nLinha (0 a 7): ");
            int misselL = entrada.nextInt();
            System.out.print("Coluna (0 a 7): ");
            int misselC = entrada.nextInt();
            if (misselL < 0 || misselC < 0 || misselL > 7 || misselC > 7) {
                System.out.println("Algum dos valores inseridos é inválido, tente novamente. \n");
            } else if (matriz2[misselL][misselC] == 3 || matriz2[misselL][misselC] == 2) {
                System.out.println("Você já atacou nessa casa antes. Vamos tentar outro lugar. \n");
            } else {
                espacoBranco();
                qtdPCNova = procurarBarco(matriz2, misselL, misselC, qtdPCNova);
                if (qtdPC == qtdPCNova) {
                    System.out.println("Você errou... \n Novo mapa: ");
                } else {
                    System.out.println("Você acertou! \n Novo mapa:");
                }
                impressaoMatrizes(matriz2, qtdPC, qtdPCNova);
                qtdPC = qtdPCNova;
                qtdJogadas++;
            }
        } while (qtdPC > 0 && qtdJogadas<30);

        entrada.close();

    }

    // ----------------------------------------------------IMPRESSAO
    // MATRIZ----------------------------------------------------

    public void impressaoMatrizes(int matriz2[][], int qtdPC, int qtdPCNova) {
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                if (matriz2[i][j] == 2) { // 2 == acerto
                    System.out.print("\u001b[1;31m" + "X " + "\u001b[0m"); // Isso aq ta colorido em vermelho, tá nos
                                                                           // exemplos postados no github da professora
                } else if (matriz2[i][j] == 3) { // 3 == erro
                    System.out.print("\u001b[1;30m" + "O " + "\u001b[0m"); // isso era pra ser preto, mas tá mais pra
                                                                           // cinza
                } else { // o resto, água
                    System.out.print("\u001b[1;34m" + "~ " + "\u001b[0m"); // e isso aq em azul, os três casos depois
                                                                           // setam pra cor padrão dnv pra n dar
                                                                           // problema
                }
            }
            System.out.println();
        }
    }

    public int barco(Random aleat, int matriz2[][], int qtdPCNova) {

        for (int i = 0; i < 10; i++) {
            int linha = aleat.nextInt(8);
            int coluna = aleat.nextInt(8);
            if (matriz2[linha][coluna] == 1) {
                i--;
            } else {
                matriz2[linha][coluna] = 1;
                qtdPCNova++;
            }
        }
        return qtdPCNova;
    }

    public int procurarBarco(int matriz2[][], int misselL, int misselC, int qtdPCNova) {
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                if (matriz2[misselL][misselC] == 1) {
                    matriz2[misselL][misselC] = 2;
                    qtdPCNova -= 1;
                    return qtdPCNova;
                } else {
                    matriz2[misselL][misselC] = 3;
                }
            }
        }
        return qtdPCNova;
    }

    public void espacoBranco() {
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

    public static void main(String[] args) throws InterruptedException, IOException {
        new BatalhaNaval();
    }
}
