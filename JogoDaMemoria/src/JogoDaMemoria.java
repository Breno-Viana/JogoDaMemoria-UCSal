/**/
import java.util.Random;
import java.util.Scanner;

public class JogoDaMemoria {
    static int iI=0,iJ=0;
    static int pos1,pos2;
   
    static final String[][] tabuleiro = {
            {"A", "B", "C", "D"},
            {"E", "F", "G", "H"},
            {"A", "B", "C", "D"},
            {"E", "F", "G", "H"}
    };
    static final int[][] Posi = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    static int pares = 0;
    static boolean[][] VerificarPos = new boolean[4][4];
    static boolean Desistiu = false; 

    static void ImprimirTabuleiro() {
        for (String[] strings : tabuleiro) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print("X  ");
            }
            System.out.println();
        }
    }

    static void ImprimirTabu() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static void Embaralhar() {
        Random Gerar = new Random();
        int I;
        int J;
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                String temp = tabuleiro[i][j];
                I = Gerar.nextInt(tabuleiro.length);
                J = Gerar.nextInt(tabuleiro[i].length);
                tabuleiro[i][j] = tabuleiro[I][J];
                tabuleiro[I][J] = temp;
            }

        }
    }

    static void AbrirPos(int pos) {

        for (int i = 0; i <Posi.length ; i++) {
            for (int j = 0; j <Posi[i].length ; j++) {
                if (Posi[i][j] == pos){
                    iI = i;
                    iJ = j;
                    break;
                }
            }
        }
        VerificarPos[iI][iJ] = true;
        for (int i = 0; i < VerificarPos.length; i++) {
            for (int j = 0; j < VerificarPos[i].length; j++) {
                if (VerificarPos[i][j]) {
                    System.out.print(tabuleiro[i][j] + "  ");
                } else {
                    System.out.print("X  ");
                };
            }
            System.out.println();
        }
    }

    static void ChecarPos(int pos) {
         int iI2=0, iJ2 =0;
        for (int i = 0; i <Posi.length ; i++) {
            for (int j = 0; j <Posi[i].length ; j++) {
                if (Posi[i][j] == pos){
                    iI2 = i;
                    iJ2 = j;
                    break;
                }
            }
        }

        if (tabuleiro[iI][iJ].equals(tabuleiro[iI2][iJ2])) {
            AbrirPos(pos);
            pares++;
        } else {
            VerificarPos[iI][iJ] = false;
            System.out.println("Nao é um par");
        }


    }

    static boolean JaEPar(int posRep) {
        int N= 0,n=0;
        for (int i = 0; i <Posi.length ; i++) {
            for (int j = 0; j < Posi[i].length; j++) {
                if (posRep == Posi[i][j]){
                    N = i;
                    n = j;
                }
            }
        }
        return VerificarPos[N][n];
    }
    
    static void Desistir(){
        System.out.println("DESISTÊNCIA, REVELANDO PARES");
        for(int i = 0; i < tabuleiro.length; i++){
            for(int j = 0; j < tabuleiro[i].length;j++){
                System.out.print(tabuleiro[i][j]+"  ");
            }
            System.out.println();
        }
        Desistiu = true;
        
    }


    static void Inicio() {
        Scanner sc = new Scanner(System.in);

        System.out.println("   Jogo da Memoria");
        System.out.println("=====================");
        ImprimirTabu();
        System.out.println("Embaralhando....");
        System.out.println("==============");
        System.out.println(" EMBARALHADO!");
        Embaralhar();
        ImprimirTabuleiro();
        do {
            while (true){
                System.out.println("Digite um numero de 1 a 16 ou [-1] para desistir");
                pos1 = sc.nextInt();
                if(pos1 == -1){
                    Desistir();
                    return;
                }
                if (pos1 > 16 || pos1 < 1){
                    System.out.println("posição invalida");
                }else{
                    if (JaEPar(pos1)){
                        System.out.println("Par ja encontrado");
                    }else break;
                }
            }
            AbrirPos(pos1);
            while (true){
                System.out.println("Digite outro numero de 1 a 16");
                pos2 = sc.nextInt();
                if (pos2 > 16 || pos2 < 1||pos1 == pos2){
                    System.out.println("posição invalida");
                }else {
                    if (JaEPar(pos2)){
                        System.out.println("Par ja encontrado");
                    }else break;
                }
            }

            ChecarPos(pos2);
            System.out.println("Pares encontrados - > " + pares);
        } while (pares != 8);
        System.out.println("VOCE GANHOU O JOGO!");
    }

    public static void main(String[] args) {
        Inicio();
        if(Desistiu){
        System.out.println("Voce desistiu, pares encontrados -> "+ pares);
        }
}
}
