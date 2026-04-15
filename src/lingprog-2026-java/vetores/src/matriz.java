import java.util.Scanner;

public class matriz {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        float [][] matr = new float[3][4];
        String op;

        do {
        //inicio
        System.out.println("-------------------");
        System.out.println(" Média Matrizes ");
        System.out.println("-------------------");

        float soma = 0;
        float medialuno = 0;
        float media = 0;
        int i = 0;

        //valor das matrizes
            for (i = 0; i < matr.length; i++){
                float somaaluno = 0;
                System.out.println(i + "° Aluno");
                System.out.print("Notas: ");
                for (int j =0; j < matr[1].length; j++){
                    matr [i][j] = (float) Math.random() * 10;
                    System.out.printf("%.2f  ", matr[i][j]);
                    soma += matr [i][j];
                    somaaluno += matr [i][j];
                }
                //media por aluno
                medialuno = somaaluno / matr[i].length;
                System.out.printf("\nMedia do aluno é: %.2f", medialuno);
                System.out.println("");
                System.out.println("===============================");


            }
            float notas = matr.length * matr[0].length;
            media = soma / notas;

            //relatório
            System.out.printf("A média da sala é: %.2f", media);

            //menu para imprimir novas notas
            System.out.println("\n\n----------------------------");
            System.out.println("Desja imprimir novas notas?");
            System.out.println("S == Sim / N == Não");
            System.out.println("Resposta: ");
            op = sc.next();

        } while (op.equalsIgnoreCase("Sim") || op.equalsIgnoreCase("S"));

        System.out.println("Programa encerrado");
    }
}