import java.util.Scanner;

public class JogoDaMemoria {
    static int Linha1, Coluna1 ;
    static int LInha2, Coluna2;
    static String[][] tabuleiro = {
            {"A", "B", "C", "D"},
            {"E", "F", "G", "H"},
            {"A", "B", "C", "D"},
            {"E", "F", "G", "H"}
    };
    //static boolean[][] VerificarPos = new boolean[4][4];

    static void ImprimirTabuleiro(int Linha, int Coluna) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print("X  ");
            }
            System.out.println();
        }
    }


    static void Inicio() {
        Scanner sc = new Scanner(System.in);

        System.out.println("   Jogo da Memoria");
        System.out.println("=====================");
        ImprimirTabuleiro(Linha1,Coluna1);
        while (true) {
            System.out.println("Digite a linha primeira posição (0 - 3) -> ");
            Linha1 = sc.nextInt();
            System.out.println("Digite a coluna da primeira posição (0 - 3) ->");
            Coluna1 = sc.nextInt();
            ImprimirTabuleiro(Linha1,Coluna1);
            System.out.println("Digite a linha segunda posição (0 - 3) -> ");
            LInha2 = sc.nextInt();
            System.out.println("Digite a coluna da segunda posição (0 - 3) ->");
            Coluna2 = sc.nextInt();


        }

    }
    //problema de posição repitida

    public static void main(String[] args) {
        Inicio();
    }
}
