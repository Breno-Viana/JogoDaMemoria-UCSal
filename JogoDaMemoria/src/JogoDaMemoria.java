import java.util.Random;
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
    static int pares = 0;
    //static boolean[][] VerificarPos = new boolean[4][4];

    static void ImprimirTabuleiro(int Linha, int Coluna) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print("X  ");
            }
            System.out.println();
        }
    }
    static void ImprimirTabu(){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]+"  ");
            }
            System.out.println();
        }
    }

    static void Embaralhar(){
        Random Gerar = new Random();
        int I;
        int J;
        for (int i = 0; i <tabuleiro.length ; i++) {
            for (int j = 0; j <tabuleiro[i].length ; j++) {
                String temp = tabuleiro[i][j];
                I = Gerar.nextInt(tabuleiro.length);
                J = Gerar.nextInt(tabuleiro[i].length);
                tabuleiro[i][j] = tabuleiro[I][J];
                tabuleiro[I][J] = temp;
            }

        }
    }


    static void Inicio() {
        Scanner sc = new Scanner(System.in);

        System.out.println("   Jogo da Memoria");
        System.out.println("=====================");
        ImprimirTabu();
        System.out.println("Embaralhando....");
        try{Thread.sleep(3000);}catch (Exception _){}
        System.out.println("==============");
        System.out.println(" EMBARALHADO!");
        Embaralhar();
        ImprimirTabuleiro(Linha1,Coluna1);
        do {
            System.out.println("Digite a linha primeira posição (0 - 3) -> ");
            Linha1 = sc.nextInt();
            System.out.println("Digite a coluna da primeira posição (0 - 3) ->");
            Coluna1 = sc.nextInt();
            ImprimirTabuleiro(Linha1, Coluna1);
            System.out.println("Digite a linha segunda posição (0 - 3) -> ");
            LInha2 = sc.nextInt();
            System.out.println("Digite a coluna da segunda posição (0 - 3) ->");
            Coluna2 = sc.nextInt();

        }while (false/*pares != 8*/);



    }
    //problema de posição repitida

    public static void main(String[] args) {
        Inicio();
    }
}
